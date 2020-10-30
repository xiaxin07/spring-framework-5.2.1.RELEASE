package com.xiaxin.mapperScan;

import com.xiaxin.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author cxq
 * @date 2020/9/10 17:14
 * @description
 */
public class MapperScanImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry) {

		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserMapper.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionBuilder.getBeanDefinition();
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.xiaxin.mapper.UserMapper");
		beanDefinition.setBeanClass(MyFactoryBean.class);
		registry.registerBeanDefinition("userMapper", beanDefinition);
	}
}
