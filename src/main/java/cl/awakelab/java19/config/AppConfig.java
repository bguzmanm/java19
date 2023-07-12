package cl.awakelab.java19.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cl.awakelab.java19")
@PropertySource("classpath:database.properties")
public class AppConfig {

  Environment environment;

  public AppConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  DataSource dataSource(){
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setUrl(environment.getProperty("url"));
    driverManagerDataSource.setUsername(environment.getProperty("dbuser"));
    driverManagerDataSource.setPassword(environment.getProperty("dbpassword"));
    driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
    return driverManagerDataSource;
  }
}
