package com.jt.sd.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class RequestUtil {

	public static Object setParameters(Class clz, HttpServletRequest request) {
		Object o = null;
		try {
			o = clz.newInstance();
			Map<String, String[]> params = request.getParameterMap();
			Set<String> keys = params.keySet();
			for (String key : keys) {
//				if(key.equals("method")) continue;
				String[] s = params.get(key);
				if (s.length > 1) {
					BeanUtils.copyProperty(o, key, s);
				} else {
					BeanUtils.copyProperty(o, key, s[0]);
				}
			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

}
