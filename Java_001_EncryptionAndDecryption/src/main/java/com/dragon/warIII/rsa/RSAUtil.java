package com.dragon.warIII.rsa;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.log4j.Logger;

import com.dragon.warIII.base64.Base64Util;


/**
 * @description 功能描述: RSA工具类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-1
 * @projectname 项目名称: Java_001_EncryptionAndDecryption
 * @packageclass 包及类名: com.dragon.warIII.rsa RSAUtil.java
 */
public class RSAUtil {

	private static final Logger log = Logger.getLogger(RSAUtil.class);
	
	private static String SignAlg = "SHA1WithRSA";

	/**
	 * <p>1.生成公钥和私钥</p>
	 */
	public static HashMap<String, Object> getKeys() {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(1024);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
			map.put("public", publicKey);
			map.put("private", privateKey);
			return map;
		} catch (Exception e) {
			log.error("RSAUtil.getKeys() error, cause by " + e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <p>
	 * 2.使用模和指数生成RSA公钥
	 * 注意:此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
	 * /None/NoPadding
	 * 
	 * @param modulus
	 *            模
	 * @param exponent
	 *            指数
	 * </p>
	 */
	public static RSAPublicKey getPublicKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus);
			BigInteger b2 = new BigInteger(exponent);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			log.error(
					"RSAUtil.getPublicKey() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <p>
	 * 3.使用模和指数生成RSA私钥
	 * 注意:此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
	 * /None/NoPadding
	 * 
	 * @param modulus
	 *            模
	 * @param exponent
	 *            指数
	 * </p>
	 */
	public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus);
			BigInteger b2 = new BigInteger(exponent);

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			log.error(
					"RSAUtil.getPublicKey() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>4.公钥加密</p>
	 */
	public static String encryptByPublicKey(String data, RSAPublicKey publicKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			//模长
			int key_len = publicKey.getModulus().bitLength() / 8;
			//加密数据长度 <= 模长 - 11
			String[] datas = splitString(data, key_len - 11);
			String mi = "";
			//如果明文长度大于模长-11则要分组加密
			for(String s: datas) {
				mi += bcd2Str(cipher.doFinal(s.getBytes()));
			}
			return mi;
		} catch (Exception e) {
			log.error(
					"RSAUtil.encryptByPublicKey() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>5.私钥解密</p>
	 */
	public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			//模长
			int key_len = privateKey.getModulus().bitLength() / 8;
			byte[] bytes = data.getBytes();
			byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
			System.err.println(bcd.length);
			//如果密文长度大于模长则要分组解密
			String ming = "";
			byte[][] arrays = splitArray(bcd, key_len);
			for(byte[] arr: arrays) {
				ming += new String(cipher.doFinal(arr));
			}
			return ming;
		} catch (Exception e) {
			log.error(
					"RSAUtil.decryptByPrivateKey() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>a.拆分字符串</p>
	 */
	public static String[] splitString(String string, int len) {
		int x = string.length() / len;
		int y = string.length() % len;
		int z = 0;
		if (y != 0) {
			z = 1;
		}
		String[] strings = new String[x + z];
		String str = "";
		for(int i = 0; i < x + z; i++) {
			if (i == x + z - 1 && y !=0 ) {
				str = string.substring(i * len, i * len + y);
			} else {
				str = string.substring(i * len, i * len + len);
			}
			strings[i] = str;
		}
		return strings;
	}

	/**
	 * <p>b.BCD转字符串</p>
	 */
	public static String bcd2Str(byte[] bytes) {
		char temp[] = new char[bytes.length * 2], val;
		
		for(int i = 0; i < bytes.length; i++) {
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
			
			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}
	
    /** 
     * <p>c.ASCII码转BCD码 </p>
     *  
     */  
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {  
        byte[] bcd = new byte[asc_len / 2];  
        int j = 0;  
        for (int i = 0; i < (asc_len + 1) / 2; i++) {  
            bcd[i] = asc_to_bcd(ascii[j++]);  
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));  
        }  
        return bcd;  
    }
    
    /**
     *<p>c.in</p>
     */
    public static byte asc_to_bcd(byte asc) {  
        byte bcd;  
  
        if ((asc >= '0') && (asc <= '9'))  
            bcd = (byte) (asc - '0');  
        else if ((asc >= 'A') && (asc <= 'F'))  
            bcd = (byte) (asc - 'A' + 10);  
        else if ((asc >= 'a') && (asc <= 'f'))  
            bcd = (byte) (asc - 'a' + 10);  
        else  
            bcd = (byte) (asc - 48);  
        return bcd;  
    }  
    
    /** 
     * <p>d.拆分数组</p>
     */  
    public static byte[][] splitArray(byte[] data,int len){  
        int x = data.length / len;  
        int y = data.length % len;  
        int z = 0;  
        if(y!=0){  
            z = 1;  
        }  
        byte[][] arrays = new byte[x+z][];  
        byte[] arr;  
        for(int i=0; i<x+z; i++){  
            arr = new byte[len];  
            if(i==x+z-1 && y!=0){  
                System.arraycopy(data, i*len, arr, 0, y);  
            }else{  
                System.arraycopy(data, i*len, arr, 0, len);  
            }  
            arrays[i] = arr;  
        }  
        return arrays;  
    }  
    
    /**
     * <p>6.字符串类型的公钥转换对象类型的公钥</p>
     */
    public static PublicKey getPublicKey(String key) {
    	try {
			byte[] keyBytes;
			keyBytes = Base64Util.decodee(key.getBytes(StandardCharsets.UTF_8));
			
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (Exception e) {
			log.error(
					"RSAUtil.getPublicKey() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * <p>7.字符串类型的私钥转换为对象类型的私钥</p>
     */
    public static PrivateKey getPrivateKey(String key) {
    	try {
			byte[] keyBytes;
			keyBytes = Base64Util.decodee(key.getBytes(StandardCharsets.UTF_8));
			
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
			return privateKey;
		} catch (Exception e) {
			log.error(
					"RSAUtil.getPublicKey() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * <p>8.得到秘钥字符串(经过Base64编码)</p>
     */
    public static String getKeyString(Key key) {
    	byte[] keyBytes = key.getEncoded();
    	String s = Base64Util.encode(keyBytes);
    	return s;
    }
    
    /**
     * <p>
     * 9.RSA签名
     * @param key 私钥
     * @param source 签名数据
     * @return
     * </p>
     */
    public static String sign(PrivateKey privateKey, String source) {
    	try {
    		Signature signature = Signature.getInstance(SignAlg);
    		signature.initSign(privateKey);
    		signature.update(source.getBytes(StandardCharsets.UTF_8));
    		byte[] signByte = signature.sign();
    		return Base64Util.encode(signByte);
		} catch (Exception e) {
			log.error(
					"RSAUtil.sign() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * <p>
     * 10.验签
     * @param publicKey 公钥
     * @param source 待签名数据
     * @param sign 签名值
     * </p>
     */
    public static boolean verify(PublicKey publicKey, String source, String sign) {
    	try {
			Signature signature = Signature.getInstance(SignAlg);
			signature.initVerify(publicKey);
			signature.update(source.getBytes(StandardCharsets.UTF_8));
			boolean verified = signature.verify(Base64Util.decodee(sign.getBytes(StandardCharsets.UTF_8)));
			return verified;
		} catch (Exception e) {
			log.error(
					"RSAUtil.verify() error, cause by " + e.getMessage(),
					e);
			e.printStackTrace();
		}
    	return false;
    }
    
}














