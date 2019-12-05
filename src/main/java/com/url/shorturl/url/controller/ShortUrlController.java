package com.url.shorturl.url.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.url.shorturl.common.result.Result;
import com.url.shorturl.common.utils.GetPageSource;
import com.url.shorturl.url.entity.ShortUrl;
import com.url.shorturl.url.entity.vo.ShortUrlVO;
import com.url.shorturl.url.service.impl.ShortUrlServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenguangxu
 * @since 2019-09-25
 */
@Api(tags = "接口")
@RestController
//swagger-ui.html 操作
//@RequestMapping("/v1")
//部署 || 测试
@RequestMapping("/")
public class ShortUrlController {

    @Autowired
    ShortUrlServiceImpl shortUrlService;

    @ApiOperation(value = "获取所有数据")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    Result shortURL() {
        try {
            List<ShortUrl> list = shortUrlService.list();
            return Result.ok(list);
        } catch (Exception e) {
            return Result.fail("失败" + e);
        }
    }

    @ApiOperation(value = "获取所有链接")
    @RequestMapping(value = "/url", method = RequestMethod.GET)
    Result url(HttpServletRequest request) {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        List<Object> url = new ArrayList<>();
        try {
            List<ShortUrl> list = shortUrlService.list();
            list.forEach(shortUrl -> {
                url.add(basePath + "/" + shortUrl.getUrlKey());
            });
            return Result.ok(url);
        } catch (Exception e) {
            return Result.fail("失败" + e);
        }
    }

    @ApiOperation(value = "通过短链接请求原文")
    @RequestMapping(value = "/{url}", method = RequestMethod.GET)
    Result shortURL(HttpServletResponse response, @PathVariable String url) {
        if (null == url) {
            return Result.fail("请求为空");
        }
        try {
            QueryWrapper<ShortUrl> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(ShortUrl::getUrlKey, url);
            ShortUrl shortUrl = shortUrlService.getOne(queryWrapper);
            if (null == shortUrl) {
                return Result.fail("请求连接不存在");
            }
            response.sendRedirect(shortUrl.getUrlValue());
            return Result.ok("");
        } catch (Exception e) {
            return Result.fail("失败" + e);
        }
    }

    @ApiOperation(value = "连接转换 返回短链接 uri")
    @RequestMapping(value = "", method = RequestMethod.POST)
    Result shortURL(HttpServletRequest request, @RequestBody ShortUrlVO shortUrlVO) {
        String url = shortUrlVO.getUrlValue();
        QueryWrapper<ShortUrl> queryWrapper;
        String title = shortUrlVO.getTitle();
        String keys = "";
        String re = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (null == url) {
            return Result.fail("url 请求为空");
        }
        //解析
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(url);
        if (!matcher.matches()) {
            return Result.fail("url 验证失败");
        }
        try {
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
            String md5 = DigestUtils.md5DigestAsHex(url.getBytes());
            //实测 10W 条数据中 有 条重复
            // python 多线程 post 20min
            //url 为 http://localhost:8080/api/vi/JasperTest/template + for i in range(100000)
            String key = md5.substring(8, 16).toUpperCase();//取md5中的8位
            queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(ShortUrl::getUrlKey, key);
            ShortUrl getShortUrl = shortUrlService.getOne(queryWrapper);
            if (null != getShortUrl) {
                if (md5.equals(getShortUrl.getMd5())) {
                    return Result.ok(basePath + "/" + key);
                }
                keys = key + "-1";
                queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(ShortUrl::getUrlKey, keys);
                ShortUrl getShortUrl2 = shortUrlService.getOne(queryWrapper);
                if (null != getShortUrl2) {
                    System.err.println(md5.equals(getShortUrl2.getMd5()));
                    System.err.println(md5);
                    System.err.println(getShortUrl2.getMd5());
                    if (md5.equals(getShortUrl2.getMd5())) {
                        return Result.ok(basePath + "/" + keys);
                    }
                    keys = key + "-2";
                }
                queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(ShortUrl::getUrlKey, keys);
                ShortUrl getShortUrl3 = shortUrlService.getOne(queryWrapper);
                if (null != getShortUrl3) {
                    return Result.ok("请联系管理员删除数据: 307185474@qq.com");
                }
            } else {
                keys = key;
            }

            if (StringUtils.isEmpty(shortUrlVO.getTitle())) {
                String pageSource = GetPageSource.getPageSource(url, "UTF-8");
                title = pageSource.substring(pageSource.indexOf("<title>") + 7, pageSource.indexOf("</title>"));
            }
            ShortUrl shortUrl = new ShortUrl();
            shortUrl.setTitle(title).setMd5(md5).setUrlKey(keys).setCreateTime(Instant.now().toEpochMilli()).setUrlValue(url);
            shortUrlService.save(shortUrl);
            return Result.ok(basePath + "/" + keys);
        } catch (Exception e) {
            return Result.fail("失败" + e);
        }
    }

    @ApiOperation(value = "删除最近 i 天的数据")
    @RequestMapping(value = "/{i}", method = RequestMethod.DELETE)
    Result shortURL(@PathVariable Integer i) {
        Long day = 86400000l;
        if (null == i) {
            return Result.fail("请求为空");
        }
        try {
            Long thisT = Instant.now().toEpochMilli();
            Long toT = i * day;
            QueryWrapper<ShortUrl> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().le(ShortUrl::getCreateTime, thisT - toT);
            List<ShortUrl> list = shortUrlService.list(queryWrapper);
            list.forEach(id -> {
                shortUrlService.removeById(id);
            });
            return Result.ok("");
        } catch (Exception e) {
            return Result.fail("失败" + e);
        }
    }

    public static void main(String[] args) {
        String url = "http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666273431&amp;idx=1&amp;sn=9c84f1374c5db160b21ae0fc3b90cadf&amp;chksm=bdb473d48ac3fac242f3972f4e0620fed8a0211d230cd2d767f7472d852585aad57db715b989&amp;mpshare=1&amp;scene=1&amp;srcid=&amp;sharer_sharetime=1569373321962&amp;sharer_shareid=4ba73b7c712b1fff9cc33b4a6ce70432#rd";
        String re = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        //解析
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(url);
        if (!matcher.matches()) {
            System.err.println("url 验证失败");
        }
        String value = url;
        System.err.println(value);
    }


}
