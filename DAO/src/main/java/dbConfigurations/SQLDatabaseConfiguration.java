package dbConfigurations;

import org.hibernate.SessionFactory;
import org.hsqldb.jdbc.JDBCDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SQLDatabaseConfiguration {

    @Value("${dao.jdbc.username}")
    private String username;
    @Value("${dao.jdbc.password}")
    private String password;
    @Value("${dao.jdbc.url}")
    private String url;
    @Value("${dao.jdbc.driver}")
    private String driver;

    @Bean(name = "dataSource")
    @Profile(value = "default")
    public DataSource dataSource() {
        try {
            Properties props = getProperties();
            System.out.println(props);
            return new JDBCDataSourceFactory()
                    .createDataSource(getProperties());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("accountDao","projectDao");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory.getObject();
    }

    @Bean(name="transactionManager")
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "create-drop");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        return hibernateProperties;
    }

    private Properties getProperties() {
        return new Properties() {{
            put("user", username);
            put("password", password);
            put("url", url);
            put("driverClassName", driver);
        }};
    }

}
