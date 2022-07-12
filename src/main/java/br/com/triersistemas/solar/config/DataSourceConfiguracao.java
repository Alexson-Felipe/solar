package br.com.triersistemas.solar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguracao {

    @Bean
    public DataSource dataSource(){
        //Trier
        //String url = "jdbc:postgresql://localhost:5434/solar"; //porta da esquerda no container docker 5434:5432

        //Em casa
        String url = "jdbc:postgresql://localhost:5432/solar"; //porta da esquerda no container docker 5434:5432

        String usuario = "postgres";
        String senha = "postgres";

        return new DriverManagerDataSource(url, usuario, senha);
    }
}
