package lv.javaguru.crm.core.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(value = "lv.javaguru.crm.core.modules")
@EntityScan(basePackages = "lv.javaguru.crm.core.modules")
@ComponentScan(basePackages = "lv.javaguru.crm.core.modules")
@EnableTransactionManagement
public class CourseConfiguration {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://89.201.4.13:3306/javaguru_crm?createDatabaseIfNotExist=true" +
                "&autoReconnect=true&useSSL=false");
        dataSource.setUsername("javaguru");
        dataSource.setPassword("Java#Guru*");
        return dataSource;
    }

    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:/db/changelog/changelog-master.xml");
        liquibase.setShouldRun(true);
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}