package kg.tech.order.services.impl;

import kg.tech.order.repositories.UserRepository;
import kg.tech.order.services.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailSenderService {
    private final UserRepository userRepository;
    private final MimeMessage mimeMessage;
    private final Transport transport;

    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Override
    public void sendToEmail(Long userId, String subject, String body) {
        userRepository.findById(userId).ifPresent(user -> {
            try(transport) {
                mimeMessage.setRecipients(Message.RecipientType.TO, user.getEmail());
                mimeMessage.setSubject(subject);
                mimeMessage.setSentDate(new Date());
                mimeMessage.setText(body);

                transport.connect(username, password);
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            log.info("send order information to email: " + user.getEmail());
        });
    }
}
