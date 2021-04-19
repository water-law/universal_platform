package com.weitu.mpsplatform.commons.utils;

import com.weitu.mpsplatform.commons.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象转换工具类
 * 
 * @author fsh
 */
public class BeanConvertTools {
    private static final Logger logger = LoggerFactory.getLogger(BeanConvertTools.class);
    

    /**
     * Method description : 对象转换
     *
     * Author：        fsh
     * @param source 源对象
     * @param clazz  目标类
     * @return
     *
     */
	public static <T> T copyPropertiesToClazz(Object source, Class clazz) {
    	if (SString.isBlank(SString.getTrimString(source))) {
    		return null;
		}
		if (SString.isBlank(SString.getTrimString(clazz))) {
            logger.error("clazz为空");
			throw new BaseException("clazz为空");
		}
		T target = null;
		try {
			target = (T)clazz.newInstance();
			BeanUtils.copyProperties(source, target);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return target;
	}

    /**
	 * 对象列表转换
	 * @param sourceList	数据源列表
	 * @param clazz		转换列表的对象类型
	 * @param <T>
	 * @param <E>
	 * @return
	 */
	public static <T, E> List<T> copyList(List<E> sourceList, Class clazz) {
	        if (CollectionUtils.isEmpty(sourceList)) {
	            return null;
            }
            if (SString.isBlank(SString.getTrimString(clazz))) {
                logger.error("clazz 为空");
                throw new BaseException("clazz 为空");
            }
			List<T> resultList = new ArrayList<>();
            T target;
            for(E source : sourceList) {
				target = copyPropertiesToClazz(source, clazz);
				if (target != null) {
					resultList.add(target);
				}
            }
            return resultList;
    }

}