package com.xiaxin.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author cxq
 * @date 2020/9/9 17:17
 * @description
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware {

	public MyApplicationContextAware() {
		System.out.println("myApplicationContextAware");
	}

	/**
	 * 生命周期初始化回调方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("postConstruct callback");
	}

	/**
	 * ApplicationContextAware 回调方法
	 *
	 * @param applicationContext the ApplicationContext object to be used by this object
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("aware callback");
	}
}
