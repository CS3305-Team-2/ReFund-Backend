package com.bestteam.helpers;

import java.io.IOException;

import com.sendgrid.*;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MailHelper implements EnvironmentAware {
    private static Environment environment;

    public static void send(String recipient, String subject, String content) throws IOException {
        Email from = new Email("sesame@refund.noahsc.xyz");
        Email to = new Email(recipient);
        Content body = new Content("text/html", content);
        Mail email = new Mail(from, subject, to, body);
        SendGrid sg = new SendGrid(environment.getProperty("sendgrid_key"));
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(email.build());
        sg.api(request);
    }

    @Override
    public void setEnvironment(Environment environment) {
        MailHelper.environment = environment;
    }
}