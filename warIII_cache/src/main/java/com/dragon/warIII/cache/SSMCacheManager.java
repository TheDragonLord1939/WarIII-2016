package com.dragon.warIII.cache;

import java.util.Collection;

import org.springframework.cache.support.AbstractCacheManager;

/**
 * @description 功能描述:自定义SSMCache管理器
 * @author 作 者: L.D
 * @date 建立日期：2016-7-16
 * @name 项目名称: warIII_cache
 * @package 包及类名: com.dragon.warIII.cache   SSMCacheManager.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class SSMCacheManager extends AbstractCacheManager{
	
	private Collection<SSMCacheCache> caches;

	/**
	 * Specify the collection of Cache instances to use for this CacheManager.
	 */
	public void setCaches(Collection<SSMCacheCache> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<SSMCacheCache> loadCaches() {
		return this.caches;
	}

	
}
