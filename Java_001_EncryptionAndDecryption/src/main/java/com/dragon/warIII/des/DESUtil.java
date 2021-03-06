/*
 *DES加密介绍:
 *DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 *后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 *24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法.
 *注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
package com.dragon.warIII.des;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.log4j.Logger;

/**
 * @description 功能描述: DES对称加密工具类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-1
 * @projectname 项目名称: Java_001_EncryptionAndDecryption
 * @packageclass 包及类名: com.dragon.warIII.des  DESUtil.java
 */
public class DESUtil {
	
	private static Logger log = Logger.getLogger(DESUtil.class);
	
	/**
	 * <p>
	 * 1.加密
	 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
	 * </p>
	 */
	public static byte[] encrypt(byte[] datasource, String password) {
		try {
			//1.DES算法要求有一个可信任的随机数源
			SecureRandom random = new SecureRandom();
			//2.创建一个DESKeySpec对象
			DESKeySpec desKey = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
			//3.创建一个秘钥工厂,然后用它把DESKeySpec转换成SecretKey
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			//4.将DESKeySpec对象转换成SecretKey对象
			SecretKey secretKey = keyFactory.generateSecret(desKey);
			//5.Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			//6.用秘钥初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, random);
			//7.正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Exception e) {
			log.error("DESUtil.encrypt() error, cause by " + e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>
	 * 2.解密
	 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
	 * </p>
	 */
	public static byte[] decrypt(byte[] src, String password) {
		try {
			//1.DES算法要求有一个可信任的随机数源
			SecureRandom random = new SecureRandom();
			//2.创建一个DESKeySpec对象
			DESKeySpec desKey = new DESKeySpec(password.getBytes(StandardCharsets.UTF_8));
			//3.创建一个秘钥工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			//4.将DESKeySpec对象转换成SecretKey对象
			SecretKey securekey = keyFactory.generateSecret(desKey);
			//5.Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance("DES");
			//6.用秘钥初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, securekey, random);
			//7.真正开始解密操作
			return cipher.doFinal(src);
		} catch (Exception e) {
			log.error("DESUtil.decrypt() error, cause by " + e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
}


















