package com.dragon.warIII.certificate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import javax.crypto.Cipher;
import org.apache.log4j.Logger;
import com.dragon.warIII.base64.Base64Util;

/**
 * @description 功能描述: 证书加密工具类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-9-7
 * @projectname 项目名称: Java_001_EncryptionAndDecryption
 * @packageclass 包及类名: com.dragon.warIII.certificate  CertificateUtil.java
 */
public class CertificateUtil {
	
	private static Logger logger = Logger.getLogger(CertificateUtil.class);
	
	private static String KEYALIAS = "test1";				 //秘钥对别名
	private static String CERTIFICATE_PATH;					 //证书路径
	private static String KEYSTORE_PATH;					 //仓库路径
	private static String KEYSTORE_PASSWORD = "123456789";   //别名为test1的秘钥对的口令
	
	static {
		CERTIFICATE_PATH = Thread.currentThread().getContextClassLoader()
				.getResource("certificate/M007.crt").getPath();
		KEYSTORE_PATH = Thread.currentThread().getContextClassLoader()
				.getResource("certificate/M007.jks").getPath();
	}
	
	/**
	 * <p>1.加密</p>
	 */
	public static String encode(String source) {
		 try {
			//1.加载证书(证书格式为X509)
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			//2.读取证书文件的输入流
			InputStream certin = new FileInputStream(CERTIFICATE_PATH);
			Certificate certificate = certificateFactory.generateCertificate(certin);
			//3.从证书中得到公钥
			PublicKey publicKey = certificate.getPublicKey();
			//4.加密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] cipherByte = cipher.doFinal(source.getBytes(StandardCharsets.UTF_8));
			
			String encodeSource = Base64Util.encode(cipherByte);
			return encodeSource;
		} catch (Exception e) {
			logger.error("CertificateUtil.encode() error, cause by " + e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>2.解密</p>
	 */
	public static String decrypt(String source) {
		
		try {
			//1.根据秘钥库类型JKS得到秘钥库实例
			KeyStore keyStore = KeyStore.getInstance("JKS", "SUN");
			InputStream is = new FileInputStream(KEYSTORE_PATH);
			keyStore.load(is, KEYSTORE_PASSWORD.toCharArray());
			
			//2.根据alias从keystore中读取秘钥对
			PrivateKey privateKey = null;
			if (keyStore.isKeyEntry(KEYALIAS)) {
				privateKey = (PrivateKey) keyStore.getKey(KEYALIAS, KEYSTORE_PASSWORD.toCharArray());
			}
			
			//3.解密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decryptByte = cipher.doFinal(Base64Util.decodee(source
					.getBytes(StandardCharsets.UTF_8)));
			
			return new String(decryptByte, StandardCharsets.UTF_8);
		} catch (Exception e) {
			logger.error("CertificateUtil.decrypt() error, cause by " + e.getMessage(), e);
			e.printStackTrace();
		} 
		return null;
	}
	
}
















