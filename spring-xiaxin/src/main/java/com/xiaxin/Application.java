package com.xiaxin;

import com.xiaxin.config.AppConfig;
import com.xiaxin.mapper.UserMapper;
import com.xiaxin.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cxq
 * @date 2020/9/9 17:09
 * @description
 */
public class Application {

	public static void main(String[] args) {
		// 实例化ApplicationContext容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		//applicationContext.getBeanFactory().registerSingleton("",new IndexService());
		//applicationContext.register(AppConfig.class);
		//// spring容器初始化，正好初始化的时候扫描到了IndexService，那么这个时候IndexService已经在容器里了，所以要进行判断
		//applicationContext.refresh();
		UserMapper bean = (UserMapper)ac.getBean("userMapper");
		System.out.println(bean.listSysUser());

		/*ac.registerBean("userService", UserService.class,UserService::new);
		ac.refresh();*/
		//System.out.println(ac.getBean("userService"));
	}
}
