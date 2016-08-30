package com.dragon.warIII.cache;

import java.util.concurrent.TimeoutException;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.dragon.warIII.core.log.AsyncLogRecord;

import com.google.code.ssm.aop.support.PertinentNegativeNull;
import com.google.code.ssm.providers.CacheException;


/**
 * @description 功能描述: 自定义MemCache
 * @author 作 者: L.D
 * @date 建立日期：2016-7-17
 * @name 项目名称: warIII_cache
 * @package 包及类名: com.dragon.warIII.cache   SSMCacheCache.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class SSMCacheCache implements Cache{

	private com.google.code.ssm.Cache cache;
	private volatile Integer timeout = 0;
	private boolean allowClear;
	
	public SSMCacheCache(){
	}
	
	public SSMCacheCache(com.google.code.ssm.Cache cache, int timeout, boolean allowClear) {
		this.cache = cache;
		this.timeout = timeout;
		this.allowClear = allowClear;
	}
	
	public SSMCacheCache(com.google.code.ssm.Cache cache, int timeout) {
		this(cache, timeout, false);
	}
	
	public SSMCacheCache(SSMCacheCache ssmCache, int timeout){
		this(ssmCache.cache, timeout, ssmCache.allowClear);
	}
	
	@Override
	public String getName() {
		return this.cache.getName();
	}

	@Override
	public Object getNativeCache() {
		return this.cache;
	}
	
	@Override
	public ValueWrapper get(Object key) {
		Object value = null;
		try {
			value = this.cache.get(getKey(key), null);
		} catch (TimeoutException | CacheException e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
		return toWrapper(key,value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Object key, Class<T> type) {
		Object value = null;
		try {
			value = this.cache.get(getKey(key),null);
		} catch (TimeoutException | CacheException e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
		if (value != null && type != null && !type.isInstance(value)) {
			throw new IllegalStateException("Cached value is not of required type [" + type.getName() + "]: " + value);
		}
		return (T) value;
	}
	
	@Override
	public void put(Object key, Object value) {
		timeout = timeout==null||timeout.intValue()<=0?(30*60):timeout;
		try {
			this.cache.set(getKey(key), timeout, value==null?PertinentNegativeNull.NULL:value, null);
		} catch (TimeoutException | CacheException e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
	}
	
	/**
	 * 存在直接返回，不存在添加后返回
	 */
	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		Object cacheValue = null;
		try {
			cacheValue = this.cache.get(getKey(key),null);
		} catch (TimeoutException | CacheException e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
		if(cacheValue == null){
			this.put(key, value);
			cacheValue = value;
		}
		return toWrapper(key, cacheValue);
	}
	
	@Override
	public void evict(Object key) {
		try {
			this.cache.delete(getKey(key));
		} catch (TimeoutException | CacheException e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
	}
	
	@Override
	public void clear() {
		try {
			this.cache.flush();
		} catch (TimeoutException | CacheException e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
	}
	
	private ValueWrapper toWrapper(Object key ,Object value) {
		return value==null||(value instanceof PertinentNegativeNull)?null:new SimpleValueWrapper(value);
	}
	
	private String getKey(Object key){
		return key.toString();
	}
	
	public com.google.code.ssm.Cache getCache() {
		return cache;
	}
	public void setCache(com.google.code.ssm.Cache cache) {
		this.cache = cache;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public boolean isAllowClear() {
		return allowClear;
	}
	public void setAllowClear(boolean allowClear) {
		this.allowClear = allowClear;
	}	
	
}
















