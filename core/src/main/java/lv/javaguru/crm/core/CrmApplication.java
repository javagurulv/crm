package lv.javaguru.crm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication()
public class CrmApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CrmApplication.class);
        System.out.println("App started");
    }
}