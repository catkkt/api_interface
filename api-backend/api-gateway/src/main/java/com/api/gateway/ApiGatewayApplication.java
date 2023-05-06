package com.api.gateway;


    import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
    import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
    import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
    import org.springframework.context.ConfigurableApplicationContext;
    import org.springframework.stereotype.Service;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableDubbo
@Service
public class ApiGatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiGatewayApplication.class,args);
        ApiGatewayApplication apiGatewayApplication = context.getBean(ApiGatewayApplication.class);
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}

