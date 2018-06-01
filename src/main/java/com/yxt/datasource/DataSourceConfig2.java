package com.yxt.datasource;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 配置数据库（使用MyBatis）
 * 
 * 1.配置数据库 2.sql会话工厂 3.事务管理 4.sql会话模版
 *
 */

@Configuration
// 扫描test2中的包（dao层）
@MapperScan(basePackages = "com.yxt.mappertest2", sqlSessionFactoryRef = "sqlSessionFactory2")
public class DataSourceConfig2 {

	/**
	 * 配置数据库
	 * 
	 * @return
	 */
	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.datasource.test2")
	public DataSource dataSource2() {

		return DataSourceBuilder.create().build();
	}

	/**
	 * sql会话工厂
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "sqlSessionFactory2")
	public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource) throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

	/**
	 * 事务管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "transactionManager2")
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource2") DataSource dataSource) {

		return new DataSourceTransactionManager(dataSource);
	}
	
	/**
	 * sql会话模版
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name = "sqlSessionTemplate2")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) {
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
