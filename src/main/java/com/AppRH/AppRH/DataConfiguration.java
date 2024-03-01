package com.AppRH.AppRH;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


@Configuration
public class DataConfiguration {

    @Bean //A anotation Bean trabalha com exportação de classes. Ajuda a fazer injeção de dependencia dessa classe em outras.

    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); //objeto de conexao
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/AppRH?useTimezone=true&serverTimeZone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("rod1234");
        return dataSource;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect" );
        return adapter;
    }

}
