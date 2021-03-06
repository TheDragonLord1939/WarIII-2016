package com.dragon.warIII.utils.http;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dragon.warIII.utils.json.JsonUtils;
import com.dragon.warIII.utils.string.StringUtils;
import com.sun.jndi.url.dns.dnsURLContext;

/**
 * HttpClient工具类
 * @author July july_sky@foxmail.com
 * @date 2015年4月10日下午1:41:13
 * @Copyright ©2003-2015 瀧腾科技. All Rights Reserved.
 * @version 1.0
 */
public class HttpClient {
	
	private static final Logger log = LoggerFactory.getLogger(HttpClient.class);
	
	private static int error = 0;//请求失败时,重试次数
	private static int _sleep = 5000;//请求失败时,重试的时间间隔

	private static final String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8"; //发送给接收方的媒体类型和字符集
	private static final String ACCEPT = "Accept";//客户端指出响应可以接受的媒体类型,并设置字符集
	
	/**
	 * <p>
	 * 1.发送Post请求,参数为 Map类型,返回结果为String类型
	 * 1.1.自动关闭资源
	 * 1.2.重试机制5次(每隔5秒重试一次)
	 * </p>
	 */
	public static String httpPostWithMap(final String url, Map<String, ?> params) throws Exception {
		
		HttpPost post = new HttpPost(url);
		
		if (!StringUtils.isEmpty(params)) {
			List<NameValuePair> valuePairs = new ArrayList<>();
			for (String key : params.keySet()) {
				valuePairs.add(new BasicNameValuePair(key,
						params.get(key) == null ? null : params.get(key)
								.toString()));
			}
			post.setEntity(new UrlEncodedFormEntity(valuePairs, StandardCharsets.UTF_8));
		}
		
		String _url = formatParams(url, params);
		
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(post);) {
			log.info("返回结果:【" + _url + "】" + response);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				log.info("请求异常...:【" + _url + "】"
						+ response.getStatusLine().getStatusCode());
				throw new Exception("请求异常...");
			}
			
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
			log.info("转移之后的数据：【" + _url + "】" + result);
			
			EntityUtils.consume(entity);
			error = 0;
			return result;
		} catch (Exception e) {
			error++;
			log.error("请求超时[" + error + "]：【" + _url + "】\t\n");
			if (error >= 5) {
				error = 0;
				throw e;
			}
			Thread.sleep(_sleep);
			return httpPostWithMap(url, params);
		}
	}
	
	/**
	 * <p>
	 * 2.发送Post请求,参数为 Map类型,返回结果为Map类型
	 * 2.1.自动关闭资源
	 * 2.2.重试机制5次(每隔5秒重试一次)
	 * </p>
	 */
	public static Map<String, Object> httpPostWithMapp(final String url,
			Map<String, ?> params) throws Exception {
		return JsonUtils.parseMap(httpPostWithMap(url, params));
	}
	
	/**
	 * <p>
	 * 3.发送Get请求,参数为Map类型,返回结果为String类型
	 * 3.1.自动关闭资源
	 * 3.2.重试机制5次(每隔5秒重试一次)
	 * 3.3.charSet不可为null或空字符串
	 * </p>
	 */								
	public static String httpGet(final String url, Map<String, ?> params,
			String charSet) throws Exception {
		boolean start = url.indexOf("?") != -1;
		String getUrl = url;
		if (!StringUtils.isEmpty(params)) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				if (!start) {
					getUrl += "?";
					start = true;
				} else {
					getUrl += "&";
				}
				getUrl += entry
						.getKey()
						.concat("=")
						.concat(URLEncoder.encode(entry.getValue().toString(),
								charSet));
			}
		}
		
		HttpGet get = new HttpGet(getUrl);
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(get);) {
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				log.info("请求异常...:【" + getUrl + "】"
						+ response.getStatusLine().getStatusCode());
				throw new Exception("请求异常...");
			}
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
			EntityUtils.consume(entity);
			error = 0;
			return result;
		} catch (Exception e) {
			error++;
			log.error("请求超时[" + error + "]：【" + getUrl + "】\t\n");
			if (error >= 5) {
				error = 0;
				throw e;
			}
			Thread.sleep(_sleep);
			return httpGet(url, params, charSet);
		}
	}
	/**
	 * <p>
	 * 4.发送String数据(JSON字符串、XML字符串)
	 * 4.1.自动关闭资源
	 * 4.2.重试机制5次(每隔5秒重试一次)
	 * </p>
	 */
	public static String httpPostWithString(final String url, String dataStr)
			throws Exception {
		String result = null;//请求返回的响应结果
		
		HttpPost httpPost = new HttpPost(url);
//		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON_UTF8);//指出发送给接收方的实体body的媒体类型,并设置字符集
		httpPost.setHeader(ACCEPT, APPLICATION_JSON_UTF8);//客户端指出响应可以接受的媒体类型,并设置字符集
		httpPost.setEntity(new StringEntity(dataStr, StandardCharsets.UTF_8));

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				CloseableHttpResponse response = httpClient.execute(httpPost)) {
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				log.info("请求异常...:【" + url + "】"
						+ response.getStatusLine().getStatusCode());
				throw new Exception("请求异常...");
			}
			
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
			log.info("转移之后的数据：【" + url + "】" + result);
			
			EntityUtils.consume(entity);
			error = 0;
			return result;
		} catch (Exception e) {
			error++;
			log.error("请求超时[" + error + "]：【" + url + "】\t\n");
			if (error >= 5) {
				error = 0;
				throw e;
			}
			Thread.sleep(_sleep);
			return httpPostWithString(url, dataStr);
		}
	}
	
	/**
	 * <p>5.格式化POST参数</p>
	 */
	public static String formatParams(String url, Map<String, ?> params) {
		boolean start = url.indexOf("?") != -1;
		String getUrl = url;
		if (!StringUtils.isEmpty(params)) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				if (!start) {
					getUrl += "?";
					start = true;
				} else {
					getUrl += "&";
				}
				getUrl += entry
						.getKey()
						.concat("=")
						.concat(entry.getValue() == null ? "" : entry
								.getValue().toString());
			}
		}
		return getUrl;
	}

	public static void main(String[] args) {
		//1.测试发送POST请求,请求参数为Map类型
//		Map<String, Object> postMap = new HashMap<String, Object>();
//		postMap.put("name", "瀧爷");
//		postMap.put("age", 18);
//		postMap.put("city", "");
//		
//		try {
//			Map resultMap = httpPostWithMapp("http://localhost:8080/warIII_web/message/sendMap.jhtml", postMap);
//			System.out.println("111");
//			System.out.println("resultStr=" + resultMap.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		//3.测试发送String类型数据
//		String dataJSONStr = "{\"id\":64236068,\"title\":\"仝依依库存机制测试--勿动勿动勿动勿动勿动勿动勿动勿动\",\"shorttitle\":\"仝依依库存机制测试--勿动勿动勿动勿动勿动勿动勿动勿动\",\"pubdate\":1439534184000,\"status\":3,\"bigpic\":\"/upload/2015/08/14/AfterTreatment/1439534183937_u3k3-0.jpg\",\"litpic\":\"/upload/2015/08/14/AfterTreatment/1439534183937_u3k3-1.jpg\",\"vname\":\"朝阳1919小剧场\",\"begindate\":1443801600000,\"enddate\":1443888000000,\"lasttime\":1441612458000,\"lastuser\":\"admin\"}";
//		String dataXMLStr = "<xml><URL><![CDATA[http://211.99.231.89/ylphone-web/wechat/api]]></URL><ToUserName><![CDATA[ylpw]]></ToUserName><FromUserName><![CDATA[dragon]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content><MsgId>1348831860</MsgId></xml>";
//		String dataStr = "你好,有什么事情?";
//		try {
//			String resultStr = httpPostWithString("http://localhost:8081/warIII_web/message/send.jhtml", dataXMLStr);
//			System.out.println("resultStr=" + resultStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// String st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
		// Date());
		// try {
		// Map<String,Object> params = Maps.newHashMap();
		// String s =
		// "{\"id\":64236068,\"title\":\"仝依依库存机制测试--勿动勿动勿动勿动勿动勿动勿动勿动\",\"shorttitle\":\"仝依依库存机制测试--勿动勿动勿动勿动勿动勿动勿动勿动\",\"pubdate\":1439534184000,\"status\":3,\"bigpic\":\"/upload/2015/08/14/AfterTreatment/1439534183937_u3k3-0.jpg\",\"litpic\":\"/upload/2015/08/14/AfterTreatment/1439534183937_u3k3-1.jpg\",\"vname\":\"朝阳1919小剧场\",\"begindate\":1443801600000,\"enddate\":1443888000000,\"lasttime\":1441612458000,\"lastuser\":\"admin\"}";
		// params.put("data", s);
		//
		// System.out.println("String-------------->"+HttpClient.execString("http://localhost:8090/warIII_web/user/testInfo.jhtml",
		// params));
		//
		// } catch (Exception e) {
		// System.out.println("开始时间："+st+"\t结束时间："+new
		// SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		// e.printStackTrace();
		// }
	}
}
