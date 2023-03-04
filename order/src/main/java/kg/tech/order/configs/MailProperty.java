package kg.tech.order.configs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailProperty {
    String host;
    Integer port;
    String username;
    String password;
    String fileType;
}
