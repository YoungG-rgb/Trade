package kg.tech.order.services;

public interface EmailSenderService {
    void sendToEmail(Long userId, String subject, String body);
}
