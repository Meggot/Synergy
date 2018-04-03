package com.runConfigurations;

import com.configurations.EmbeddedServletConfiguration;
import dbConfigurations.EmbeddedDatabaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = {"handlers","accountDao","projectDao"})
@ComponentScan("com")
@Configuration
@Import({EmbeddedDatabaseConfiguration.class, EmbeddedServletConfiguration.class})
public class EmbeddedConfiguration {
}