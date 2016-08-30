package com.dragon.warIII.cache;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.cache.common.SuperTest;

@Ignore
public class TestXMemcached extends SuperTest{

	@Autowired
	MemcachedClient memcachedClient;
	
	@Test
	public void testConnection() {
		try {
			//设置、读取
			memcachedClient.set("city", 3600, "changchun111");
			System.out.println("city=" + memcachedClient.get("city"));
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}
		
	}
}
