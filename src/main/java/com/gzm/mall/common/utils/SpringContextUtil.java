package com.gzm.mall.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SPRING 上下文工具
 * @author qiuyunbo
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
    /**
     * 判断spring上下文是否已经初始化完毕
     * @return boolean
     */
    public static boolean initialize (){
        return applicationContext != null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String name) {
        return (T)applicationContext.getBean(name);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> type){

        return applicationContext.getBean(type);
    }

    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> getBeansOfType(Class<T> type){
        return applicationContext.getBeansOfType(type);
    }
}
