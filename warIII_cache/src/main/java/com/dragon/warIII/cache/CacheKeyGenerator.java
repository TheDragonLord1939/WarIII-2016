package com.dragon.warIII.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

public class CacheKeyGenerator implements KeyGenerator{

	/**
	 * 重写默认缓存器key,提供包含了方法全路径的key策略,给出一个调试中的method参数示例：
	 * @param target
	 * @param method
	 * @param params
	 * @return
	 */
	@Override
	public  Object generate(Object target, Method method, Object... params) {
		/*先hash当前方法，然后hash所有参数*/
		int  key = ((method == null) ? 53 : method.hashCode())*target.hashCode();
		
		for (Object object : params) {
			key = 31 * key + ((object == null) ? 53 : object.hashCode());
		}

		return key;
	}

}
