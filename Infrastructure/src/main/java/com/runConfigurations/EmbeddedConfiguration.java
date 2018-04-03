package com.runConfigurations;

import com.configurations.EmbeddedServletConfiguration;
import dbConfigurations.EmbeddedDatabaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {"handlers", "dao", "repositories"})
@ComponentScan("com")
@Configuration
@Import({EmbeddedDatabaseConfiguration.class, EmbeddedServletConfiguration.class})
public class EmbeddedConfiguration {
}