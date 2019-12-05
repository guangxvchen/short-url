package com.url.shorturl.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author chenguangxu
 * @create 2019/9/27 10:05
 */
public class GetPageSource {

    /**
     * 获取网页信息
     * @param pageUrl
     * @param encoding
     * @return
     */
    public static String getPageSource(String pageUrl, String encoding) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url
                    .openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex);
        }
        return stringBuffer.toString();
    }

}
