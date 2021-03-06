package com.dragon.warIII.test.rsa;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;
import com.dragon.warIII.rsa.RSAUtil;

public class RSAUtilTest {

	@Ignore
	@Test
	public void rsaTest() {
		HashMap<String, Object> map = RSAUtil.getKeys();
		//生成公钥和私钥(私钥保存,公钥公布出去)
		RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
		RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
		
		//模
		String modulus = publicKey.getModulus().toString();
		//公钥指数
		String public_exponent = publicKey.getPublicExponent().toString();
		//私钥指数
		String private_exponent = privateKey.getPrivateExponent().toString();
		
		//使用模和指数生成公钥和私钥
		RSAPublicKey pubKey = RSAUtil.getPublicKey(modulus, public_exponent);
		System.out.println("公钥：" + pubKey);
		RSAPrivateKey priKey = RSAUtil.getPrivateKey(modulus, private_exponent);
		System.out.println("私钥：" + pubKey);
		
		//明文
		String ming = "你好,接头暗号是什么？";
		
		//加密后的密文
		String mi = RSAUtil.encryptByPublicKey(ming, pubKey);
		System.err.println("密文：" + mi);
		
		//解密后的明文
		ming = RSAUtil.decryptByPrivateKey(mi, priKey);
		System.err.println("明文：" + ming);
		
		/*		
 		私钥：Sun RSA public key, 1024 bits
		  modulus: 139165824049206376458618947619311587113180491601150041758027126218903599897898687887086043584459118461789911804294045546113913266750276305853175116499843336907893861176368474179555118555804570194861216973828381632083809347677692027512975316663790260600231249635295978821917742325549954124752098694214462217251
		  public exponent: 65537
		密文：6A6A8B72165BE3A2504FD7568B3FB8246C4830DDA640963313420ACF429E9923AFE67A97BF68F3A31A1DECEA01BFE7D7ACF87988E5FF82DE1C90F6ADECB010A8467845E6AADB5F60E6901122F655CC74E00E6A11C13A400E5C6AAEFC2BE55AEE070CB6DFD483F70EF9700B462EC90D8685E45ECBB5FBDBBCDF195D4FBEDB477E128
		明文：你好,接头暗号是什么？
		*/
	}
	
	@Ignore
	@Test
	public void testBank() {
		//银行
		//1.产生公钥和私钥(私钥保存,公钥发给银行)
		HashMap<String, Object> map = RSAUtil.getKeys();
		RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
		RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
		
		//模
		String modulus = publicKey.getModulus().toString();
		//公钥指数
		String public_exponent = publicKey.getPublicExponent().toString();
		//公钥指数
		String private_exponent = privateKey.getPrivateExponent().toString();
		
		//使用模和指数生成公钥和私钥
		RSAPublicKey pubKey = RSAUtil.getPublicKey(modulus, public_exponent);
		System.out.println("公钥：" + pubKey);
		RSAPrivateKey priKey = RSAUtil.getPrivateKey(modulus, private_exponent);
		System.out.println("私钥：" + pubKey);
		
		String publicKeyStr = RSAUtil.getKeyString(pubKey);
		System.out.println("公钥字符窜：" + publicKeyStr);
		String privateKeyStr = RSAUtil.getKeyString(priKey);
		System.out.println("私钥字符窜：" + privateKeyStr);
		/*
		公钥字符窜：MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6nUy2MhufqFa4jY/qLkk8lBGvYQOpcszJhhuocSLXoCUI/DUEx9Ml4RwQIddviUfiUdiqtukucIBS/2nEEv84E1fR6REB9hFRe58GoGVyfnp2Df5BQXu9Ytm7fnOYE34hD3DxjOZQFOKadMBlbWj1B+AQt8ZGF85DzB2INe5YFQIDAQAB
		私钥字符窜：MIIBNgIBADANBgkqhkiG9w0BAQEFAASCASAwggEcAgEAAoGBALqdTLYyG5+oVriNj+ouSTyUEa9hA6lyzMmGG6hxItegJQj8NQTH0yXhHBAh12+JR+JR2Kq26S5wgFL/acQS/zgTV9HpEQH2EVF7nwagZXJ+enYN/kFBe71i2bt+c5gTfiEPcPGM5lAU4pp0wGVtaPUH4BC3xkYXzkPMHYg17lgVAgEAAoGAIEx/bX1ouI57S//8a6zNMjXyhadF6fsbpLmYaeQDAs0N++sjBgvL6N94avZggkaBcZN2670yyL3iB/t7A9vB3lfMZZ2BJYdRR5gvnxKEd8cpCY7yfNsnLOJqfvaqQHL1B1FdvwyRVm99vZ2bmXe6cgtrazCzfYRiRU2ZXskI2DUCAQACAQACAQACAQACAQA=
		length = 216
		*/
		
	}
	
	@Ignore
	@Test
	public void testMerchant() {
		//商户
		//2.将加密的数据用公钥加密,发送给银行
		//公钥字符窜：MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6nUy2MhufqFa4jY/qLkk8lBGvYQOpcszJhhuocSLXoCUI/DUEx9Ml4RwQIddviUfiUdiqtukucIBS/2nEEv84E1fR6REB9hFRe58GoGVyfnp2Df5BQXu9Ytm7fnOYE34hD3DxjOZQFOKadMBlbWj1B+AQt8ZGF85DzB2INe5YFQIDAQAB
		String content = "草泥马，日了狗了!!!";
		String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6nUy2MhufqFa4jY/qLkk8lBGvYQOpcszJhhuocSLXoCUI/DUEx9Ml4RwQIddviUfiUdiqtukucIBS/2nEEv84E1fR6REB9hFRe58GoGVyfnp2Df5BQXu9Ytm7fnOYE34hD3DxjOZQFOKadMBlbWj1B+AQt8ZGF85DzB2INe5YFQIDAQAB";
		
		RSAPublicKey publicKey = (RSAPublicKey) RSAUtil.getPublicKey(publicKeyStr);
		
		String contentEnc = RSAUtil.encryptByPublicKey(content, publicKey);
		
		System.out.println("contentEnc=" + contentEnc);
	}
	
	@Ignore
	@Test 
	public void testVerify() {
		//3.获取银行传过来的数据,用私钥解密,获取商户数据明文
		//8C069E980DBAD353E7D091A3DDDC5016D9BAD0F3BE8AC24045183DB63F72A231A5F32AD5D8382E57F484DE993672B0B2C334113A8762A239DEF06AE6BE8BA4FD8E76AC34A0505AB9BA41A85D0EA4677B5BAAE8ED4555613BD04D570A5182892C862D05E504DD1F9CCF4AC7A383B469DBD479524052D78211A60B5999C8FE4264
		String contentEnc = "8C069E980DBAD353E7D091A3DDDC5016D9BAD0F3BE8AC24045183DB63F72A231A5F32AD5D8382E57F484DE993672B0B2C334113A8762A239DEF06AE6BE8BA4FD8E76AC34A0505AB9BA41A85D0EA4677B5BAAE8ED4555613BD04D570A5182892C862D05E504DD1F9CCF4AC7A383B469DBD479524052D78211A60B5999C8FE4264";
		String privateKeyStr = "MIIBNgIBADANBgkqhkiG9w0BAQEFAASCASAwggEcAgEAAoGBALqdTLYyG5+oVriNj+ouSTyUEa9hA6lyzMmGG6hxItegJQj8NQTH0yXhHBAh12+JR+JR2Kq26S5wgFL/acQS/zgTV9HpEQH2EVF7nwagZXJ+enYN/kFBe71i2bt+c5gTfiEPcPGM5lAU4pp0wGVtaPUH4BC3xkYXzkPMHYg17lgVAgEAAoGAIEx/bX1ouI57S//8a6zNMjXyhadF6fsbpLmYaeQDAs0N++sjBgvL6N94avZggkaBcZN2670yyL3iB/t7A9vB3lfMZZ2BJYdRR5gvnxKEd8cpCY7yfNsnLOJqfvaqQHL1B1FdvwyRVm99vZ2bmXe6cgtrazCzfYRiRU2ZXskI2DUCAQACAQACAQACAQACAQA=";
		RSAPrivateKey rpk = (RSAPrivateKey) RSAUtil.getPrivateKey(privateKeyStr);
		System.out.println("rpk=" + rpk);
		
		String content = RSAUtil.decryptByPrivateKey(contentEnc, rpk);
		System.out.println("Content=" + content);
		/*
		 rpk=sun.security.rsa.RSAPrivateKeyImpl@50fe8
		 128
		 Content=草泥马，日了狗了!!!
		 */
	}
	
	
	/**
	 * 签名
	 */
	@Ignore
	@Test
	public void testSign() {
		String privateKeyStr = "MIIBNgIBADANBgkqhkiG9w0BAQEFAASCASAwggEcAgEAAoGBALRk4/LfKrLw4D4pWjNbMJQmVMlar0MOC3Q0EM1IxRUtpvAsU4gQCIdiPB8UuunnlZJTSVsgZyBasEXl2UWl02BE3R6qZfJsO+6UZk+rv7AvwtSMuc0esZ0gh+5g+LAqlm7OJvqGvs4KycAMkzmWTzrOGeWwCvyRtsEOFOfXPNQnAgEAAoGAIUaPCckCvllSdAT6v4htsJZVg4L3212m3TuRcdyfhiWSqrDyg6G5gQes4WrYg7cVTxWP7YBPpZc09t/MMV3CXKtAXbeFFcCOhfsFYQJMuvuaU5HfVL5M1LK/BSO+JemvZdYnj2JXDMfwqhYfuL+LYHd2vVS5CU3N5yiN7pizy1kCAQACAQACAQACAQACAQA=";
		String source = "草泥马，日了狗了!!!";
		String signStr = RSAUtil.sign(RSAUtil.getPrivateKey(privateKeyStr), source);
		System.out.println("signStr=" + signStr);
		//signStr=QvFaZ2J70QryV3Djrd6CPTtV3vIkvjAqGlykNG5AAImy0czgI0axZwUZyjTrFzsGpSAUMuVwMQENDE/vQodVFyFzMwGEZxB9u/2Rd+z9Tywtb4Rnk8symjHr2IclyteMXT5qdvZ7KN/n4iQPOYZ+J4OLnrVHF+ylzJmLIqLafAw=
	}
	
	/**
	 * 验签
	 */
	@Ignore
	@Test 
	public void testVerifyy() {
		String signStr = "QvFaZ2J70QryV3Djrd6CPTtV3vIkvjAqGlykNG5AAImy0czgI0axZwUZyjTrFzsGpSAUMuVwMQENDE/vQodVFyFzMwGEZxB9u/2Rd+z9Tywtb4Rnk8symjHr2IclyteMXT5qdvZ7KN/n4iQPOYZ+J4OLnrVHF+ylzJmLIqLafAw=";
		String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0ZOPy3yqy8OA+KVozWzCUJlTJWq9DDgt0NBDNSMUVLabwLFOIEAiHYjwfFLrp55WSU0lbIGcgWrBF5dlFpdNgRN0eqmXybDvulGZPq7+wL8LUjLnNHrGdIIfuYPiwKpZuzib6hr7OCsnADJM5lk86zhnlsAr8kbbBDhTn1zzUJwIDAQAB";
		String source = "草泥马，日了狗了!!!";
		boolean flag = RSAUtil.verify(RSAUtil.getPublicKey(publicKeyStr), source, signStr);
		System.out.println("flag= " + flag);
	}
}








