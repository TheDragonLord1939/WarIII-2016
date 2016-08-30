package com.dragon.warIII.cache;

import org.springframework.cache.Cache;

import com.dragon.warIII.core.log.AsyncLogRecord;

/**
 * @description 功能描述:SSMCache扩展管理器
 * @author 作 者: L.D
 * @date 建立日期：2016-7-16
 * @name 项目名称: warIII_cache
 * @package 包及类名: com.dragon.warIII.cache   SSMCacheExtendManager.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class SSMCacheExtendManager extends SSMCacheManager{
	
	/**
	 * 重写父类方法
	 */
	@Override
	public Cache getCache(String name) {
		Cache cache = super.lookupCache(name);
		if (cache != null) {
			return cache;
		}
		Cache missingCache = this.getMissingCache(name);
		if (missingCache != null) {
			addCache(missingCache);
			return super.lookupCache(name.substring(0,name.lastIndexOf("#")));
		}
		return null;
	}
	
	@Override
	protected Cache getMissingCache(String name) {
		int index = name.lastIndexOf('#');
		if(index < 0){
			return null;
		}
		String cacheName = name.substring(0,index);
		Cache cache = super.lookupCache(cacheName);
		if(cache == null){
			return null;
		}
		int timeout = 0;
		try {
			timeout = Integer.parseInt(name.substring(index+1));
		} catch (Exception e) {
			AsyncLogRecord.getInstance().error(e, this.getClass());
		}
		if(timeout <= 0){
			return cache;
		}
		return new SSMCacheCache((SSMCacheCache)cache,timeout);
	}
}
