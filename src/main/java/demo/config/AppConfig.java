package demo.config;

import javax.sql.DataSource;

import demo.DAO.AppDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javalearn");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    public AppDAOImpl AppDAO(){
        return new AppDAOImpl(getDataSource());
    }

}
