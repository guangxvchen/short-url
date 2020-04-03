package com.url.shorturl.recordip.controller;

import com.url.shorturl.common.mails.MailServer;
import com.url.shorturl.recordip.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenguangxu
 * @create 2020/3/17 17:36
 */
@Controller
@RequestMapping("/v")
public class GetController {

    @Autowired
    private IpUtil ipUtil;

    @Autowired
    private MailServer mailServer;


    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public String shortUrl(@RequestParam(required = false) String email, Model model, HttpServletRequest request) {
        if (StringUtils.isEmpty(email)) {
            return "index";
        }
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        // 当前时间戳
        String now = String.valueOf(System.currentTimeMillis());
        // 对邮箱进行加密-BASE64（"邮箱" + "#" + "时间戳"）
        String encode = Base64Utils.encodeToUrlSafeString((email + "#" + now).getBytes());
        // 生成的地址发往前端
        model.addAttribute("url", basePath + encode);
        return "index";
    }


    @RequestMapping(value = "/ip/{deCode}", method = RequestMethod.GET)
    public void deCode(@PathVariable String deCode, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ip = ipUtil.getIpAddr(request);
        // 对地址进行解码，decode[0]为邮箱，decode[1]为时间戳
        String[] decode = new String(Base64Utils.decodeFromUrlSafeString(deCode)).split("#");
        if (System.currentTimeMillis() - Long.parseLong(decode[1]) < 1000 * 60 * 10)
            mailServer.sendMail(decode[0], "IP地址获取成功，请查收！", "IP地址：" + ip);
        response.sendRedirect("https://api.lovelive.tools/api/SweetNothings");
    }

}
