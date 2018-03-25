package com.main;

import com.configurations.EmbeddedConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by bradleyw on 25/03/2018.
 */
@SpringBootApplication
public class main {
    public static void main(final String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(EmbeddedConfiguration.class);
    }
}
