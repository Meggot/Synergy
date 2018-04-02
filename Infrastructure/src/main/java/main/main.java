package main;

import com.configurations.EmbeddedServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import runConfigurations.EmbeddedConfiguration;

/**
 * Created by bradleyw on 25/03/2018.
 */
@SpringBootApplication
public class main {
    public static void main(final String[] args) {
        SpringApplication.run(EmbeddedConfiguration.class);
    }
}
