package com.dragon.warIII.product.impl;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dragon.warIII.product.ProductService;
import com.dragon.warIII.util.LogUtil;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	/*
	 * public void save() { LogUtil.debug("ProductServiceImpl.save() start-->");
	 * 
	 * try { System.out.println("保存中"); } catch (Exception e) {
	 * e.printStackTrace(); LogUtil.info(e.getMessage()); }
	 * 
	 * LogUtil.debug("ProductServiceImpl.save() -->success-->");
	 * 
	 * }
	 */

	public void save() {
		logger.debug(" ===>ProductServiceImpl.save() 开始执行");

		String str = "123abc";
		try {
			System.out.println("保存中");
			logger.debug("ProductServiceImpl.save() 保存的数据是-->"+str);
			@SuppressWarnings("unused")
			Integer num = Integer.valueOf(str);
		} catch (Exception e) {
			logger.info("ProductServiceImpl.save() 保存失败!!!", e);
			throw new RuntimeException(e);
		}

		logger.debug("ProductServiceImpl.save() 执行成功 <===");

	}
	
/*	public static void main(String[] args) {
		String str = "123ccc";
		Integer.valueOf(str);
		
		System.out.println("fuck");
		
		String str = null;
		try {
			str = "123ccc";
			Integer.valueOf(str);
		} catch (Exception e) {
			System.out.println("报错了.");
			throw new RuntimeException("fuck!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		System.out.println("fuck");
	}*/

}
