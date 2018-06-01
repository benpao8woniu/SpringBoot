package com.yxt.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 配置数据库（使用MyBatis）
 * 
 * 1.配置数据库
 * 2.sql会话工厂
 * 3.事务管理
 * 4.sql会话模版
 *
 */


@Configuration
//扫描test1中的包（dao层）
@MapperScan(basePackages = "com.yxt.mappertest1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSourceConfig1 {

	/**
	 * 配置数据库
	 * 
	 * @return
	 */
	@Bean(name = "dataSource1")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.test1")
	public DataSource dataSource1() {

		return DataSourceBuilder.create().build();
	}

	/**
	 * sql会话工厂
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionFactory1")
	@Primary
	public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource) throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();

	}

	/**
	 * 事物管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "transactionManager1")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource1") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * sql会话模版
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name = "sqlSessionTemplate1")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate1(
			@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
