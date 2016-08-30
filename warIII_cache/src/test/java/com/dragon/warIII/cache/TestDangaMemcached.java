package com.dragon.warIII.cache;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danga.MemCached.MemCachedClient;
import com.dragon.warIII.cache.common.SuperTest;

@Ignore
public class TestDangaMemcached extends SuperTest{

	@Autowired
	MemCachedClient memCachedClient;
	
	@Test
	public void testConnection() {
		long time1 = System.currentTimeMillis();
		boolean b = memCachedClient.set("girl", "LiuYiFeifff");
		System.out.println("b=" + b);
		System.out.println(memCachedClient.get("girl"));
		long time2 = System.currentTimeMillis();
		System.out.println("time=" + (time2-time1));
	}
}
