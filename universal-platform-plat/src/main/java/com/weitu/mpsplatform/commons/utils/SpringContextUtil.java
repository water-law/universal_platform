package com.weitu.mpsplatform.commons.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Component
public class SpringContextUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringContextUtil.applicationContext == null){
			SpringContextUtil.applicationContext = applicationContext;
		}
		
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	
	public static Object getBean(String name){
		return getApplicationContext().getBean(name);
	}
	
	public static <T> T getBean(Class<T> clazz){
		return getApplicationContext().getBean(clazz);
	}

	/**
	 * 获取pageoffice路径
	 *
	 * @return
	 */
	public static File getPageofficePath() {
		try {
			return ResourceUtils.getFile("classpath:pageoffice");
		} catch (Exception e) {
			return null;
		}
	}
	
}
