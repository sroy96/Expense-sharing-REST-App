package com.split.split.MailFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Generate {
    @Autowired
    private EmailService emailService;
    public void run(String to, String content) throws Exception {
        Mail mail = new Mail();
        mail.setFrom("sauravarduino@gmail.com");
        mail.setTo(to);
        mail.setSubject("CHECK YOUR NEW TRANSACTION");
        mail.setContent(content);

        emailService.sendSimpleMessage(mail);
    }
}
