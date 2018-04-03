package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.runConfigurations.EmbeddedConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by bradleyw on 25/03/2018.
 */
@SpringBootApplication
@EnableJpaRepositories
public class main {
    public static void main(final String[] args) {
        SpringApplication.run(EmbeddedConfiguration.class);
    }
}
