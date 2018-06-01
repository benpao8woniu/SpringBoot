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
 * �������ݿ⣨ʹ��MyBatis��
 * 
 * 1.�������ݿ�
 * 2.sql�Ự����
 * 3.�������
 * 4.sql�Ựģ��
 *
 */


@Configuration
//ɨ��test1�еİ���dao�㣩
@MapperScan(basePackages = "com.yxt.mappertest1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSourceConfig1 {

	/**
	 * �������ݿ�
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
	 * sql�Ự����
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
	 * �������
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
	 * sql�Ựģ��
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
