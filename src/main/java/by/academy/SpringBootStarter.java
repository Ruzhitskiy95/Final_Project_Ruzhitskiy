package by.academy;

import by.academy.configuration.ConnectionPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "by.academy")
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(ConnectionPoolConfig.class)
public class SpringBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);

    }
}