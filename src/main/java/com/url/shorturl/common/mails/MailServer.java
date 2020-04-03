package com.url.shorturl.common.mails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author chenguangxu
 * @create 2020/3/17 17:31
 */
@Component
public class MailServer {

    private final Logger log = LoggerFactory.getLogger(MailServer.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String addr;

    @Async
    public void sendMail(String mailTo, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(addr);
        message.setTo(mailTo);
        message.setSubject(title);
        message.setText(content);
        try {
            mailSender.send(message);
            log.info("邮件已经发送。");
        } catch (Exception e) {
            log.error("发送邮件时发生异常！", e);
        }
    }

}
