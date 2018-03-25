package database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

/**
 * Created by bradleyw on 25/03/2018.
 */
@Configuration
public class EmbeddedDatabaseConfiguration {

    @Bean(name = "dataSource")
    public EmbeddedDatabase datasource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(false)
                .setType(HSQL)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("db/schema.sql")
                .setName("TestDatabase")
                .build();
    }
}

