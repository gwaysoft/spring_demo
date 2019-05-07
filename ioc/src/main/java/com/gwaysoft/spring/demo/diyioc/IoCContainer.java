package com.gwaysoft.spring.demo.diyioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
1. 实例化bean
2. 保存bean
3. 提供bean
4. 每一个bean，需要产生一个唯一的beanId
 */
public class IoCContainer {
    private Map<String, Object> beans = new ConcurrentHashMap<String, Object>();

    /**
     * 根据beanId，获得一个bean
     *
     * @param beanId
     * @return bean
     */
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托一个IoC容器创建一个bean
     *
     * @param clazz        要创建的bean的class
     * @param beanId       要创建的bean的Id
     * @param paramBeanIds 要创建的bean的构造方法所需要的参数的beanIds
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        // 1. 组装构造方法所需要的参数值
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }
        // 2. 调用构造方法实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }

        if (bean == null) {
            throw new RuntimeException();
        }
        // 3. 将实例化好的bean放入容器
        beans.put(beanId, bean);
    }
}
