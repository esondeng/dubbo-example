package com.dubbo.example.product.spring;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.TransactionTemplate;

import com.trace.mybatis.interceptor.TraceMybatisInterceptor;

/**
 * @author dengxiaolin
 * @since 2021/01/14
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.dubbo.example.product.mapper")
public class MybatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private DataSource dataSource;

    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            factoryBean.setMapperLocations(resolver.getResources("classpath*:com/dubbo/example/product/mapper/*.xml"));
        }
        catch (Exception e) {
            throw new RuntimeException("mapper扫描失败");
        }

        return factoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 启动mybatis trace 扫描
     */
    @Bean
    public TraceMybatisInterceptor traceMybatisInterceptor(SqlSessionFactory sqlSessionFactory) {
        TraceMybatisInterceptor traceMybatisInterceptor = new TraceMybatisInterceptor();
        sqlSessionFactory.getConfiguration().addInterceptor(traceMybatisInterceptor);
        return traceMybatisInterceptor;
    }
}
