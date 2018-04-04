package com.configurations;

import io.undertow.Undertow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"handlers"})
@ComponentScan("com")
@Configuration
    public class EmbeddedServletConfiguration {

        @Value("${jetty.port}")
        private Integer port;

    @Bean
    public UndertowEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
        final UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
            @Override
            public void customize(final Undertow.Builder builder) {
                builder.addHttpListener(port, "localhost");
            }

        });

        return factory;
    }
}
