package com.dragon.warIII.test.md5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.dragon.warIII.md5.MD5Util;

public class md5UtilTest {

	@Ignore
	@Test
	public void testGetMD5() {
		String strMd5 = MD5Util.getMD5("瀧爷");
		System.out.println("strMd5=" + strMd5);//strMd5=d3b7fda5b4bea99e321b9f07f0672ef8	
		System.out.println("length=" + strMd5.length());//length=32
	}
	
}
