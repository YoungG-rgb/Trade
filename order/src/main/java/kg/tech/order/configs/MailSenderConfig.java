package kg.tech.order.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Configuration
public class MailSenderConfig {

    @Value("${spring.mail.host}")
    private String smtpHost;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Value("${spring.mail.port}")
    private int port;

    @Bean
    public MimeMessage mimeMessage(){
        return new MimeMessage(session());
    }

    @Bean
    public Session session(){
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.from", mailFrom);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", port);

        return Session.getInstance(props, null);
    }

    @Bean
    public Transport transport() throws NoSuchProviderException {
        return session().getTransport();
    }
}
