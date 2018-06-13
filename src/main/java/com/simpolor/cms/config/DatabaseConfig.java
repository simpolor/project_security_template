package com.simpolor.cms.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.simpolor.cms.module.access.domain.Access;
import com.simpolor.cms.module.demo.domain.Demo;
import com.simpolor.cms.module.member.domain.Member;
import com.simpolor.cms.module.member.domain.MemberRole;
import com.simpolor.cms.security.domain.Role;
import com.simpolor.cms.security.domain.Token;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
	@Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo_db");
        dataSource.setUsername("demo");
        dataSource.setPassword("demo");
     
        return dataSource;
    }
	
	@Bean
    public  SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setTypeAliases(new Class[] {
        		Demo.class,
        		Member.class,
        		MemberRole.class,
        		Role.class,
        		Access.class,
        		Token.class
        });
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*/*.xml"));
        //sessionFactory.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

}
