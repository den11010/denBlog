package blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // this annotation applies the default configuration settings for Spring Boot application
public class DenBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(DenBlogApplication.class, args);
    }
}
