package io.dsub.shoppingdemo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public DataSource dataSource(Environment environment) {
        return DataSourceBuilder.create()
                .url(environment.getProperty("url"))
                .username(environment.getProperty("username"))
                .password(environment.getProperty("password"))
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
