package com.registerApp.EmailVerification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.yaml.snakeyaml.introspector.Property;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Value("${spring.mail.host}")
    private String mailHost;
    @Value("${spring.mail.port}")
    private  String mailPort;
    @Value("otptest1225@gmail.com")
    private  String mailUsername;
    @Value("sxrq rcnm gelu ymij")
    private  String mailPassword;
    @Bean
    public JavaMailSender getJavMailSender(){
        JavaMailSenderImpl javaMailSender =new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(Integer.parseInt(mailPort));
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        Properties props =javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable","true");
        return javaMailSender;

    }

}
