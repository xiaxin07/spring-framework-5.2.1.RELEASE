package com.xiaxin.mapperScan;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.xiaxin.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean, InvocationHandler {
    private Class clazz;

    public MyFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        UserMapper cardDao = (UserMapper) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, this);
        return cardDao;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName());
        Select declaredAnnotation = method1.getDeclaredAnnotation(Select.class);
        System.out.println(declaredAnnotation.value()[0]);
        System.out.println("proxy");
        return null;
    }
}