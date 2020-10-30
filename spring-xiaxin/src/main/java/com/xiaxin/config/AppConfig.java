package com.xiaxin.config;

import javax.sql.DataSource;

import com.xiaxin.mapperScan.XiaxinScan;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 为什么AppConfig会需要实例化呢？
 * 因为AppConfig当中有很多加了@Bean的方法，这些方法需要被调用，故而需要实例化，
 * 但是AppConfig类的实例化很复杂，比一般类实例化过程复杂很多，涉及到代理涉及到cglib等等，
 *
 * @author cxq
 * @date 2020/9/9 17:09
 * @description
 */
@Configuration
@ComponentScan("com.xiaxin")
@XiaxinScan
//@MapperScan("com.xiaxin.mapper")
public class AppConfig {

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(
				"jdbc:mysql://localhost:3306/test?autoReconnect=true&autoReconnectForPools=true&useUnicode=true"
						+ "&characterEncoding=UTF8&useSSL=false&allowMultiQueries=true&serverTimezone=Asia/Shanghai");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		return dataSource;
	}
}
