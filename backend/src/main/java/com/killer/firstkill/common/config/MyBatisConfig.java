package com.killer.firstkill.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.killer.firstkill.book.repository") // Mapper 인터페이스가 위치한 패키지
public class MyBatisConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations; // MyBatis XML 파일 경로

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dataSourceUrl); // 프로퍼티에서 데이터베이스 URL 가져오기
        dataSource.setUsername(dataSourceUsername); // 프로퍼티에서 사용자 이름 가져오기
        dataSource.setPassword(dataSourcePassword); // 프로퍼티에서 비밀번호 가져오기
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(mapperLocations));   // Mapper XML 파일 경로
                 // .getResources("classpath*:com/killer/firstkill/book/repository/*.xml")); // Mapper XML 파일 경로
        return sessionFactory.getObject();
    }
}
