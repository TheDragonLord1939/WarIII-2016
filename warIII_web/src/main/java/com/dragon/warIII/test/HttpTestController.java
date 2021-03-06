package com.dragon.warIII.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dragon.warIII.controller.BaseController;
import com.dragon.warIII.utils.http.HttpUtil;
import com.dragon.warIII.utils.json.JsonUtils;


@Controller
@RequestMapping("/message")
public class HttpTestController extends BaseController{

	/**
	 * <p>1.测试发送POST请求,参数类型为String.</p>
	 */
	@RequestMapping("/send")
	@ResponseBody
	public String testPostStr(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			InputStream inputStream = request.getInputStream();
			String message = HttpUtil.inputStream2String(inputStream);
			System.out.println("message=" + message);//{"id":64236068,"title":"仝依依库存机制测试--勿动勿动勿动勿动勿动勿动勿动勿动","shorttitle":"仝依依库存机制测试--勿动勿动勿动勿动勿动勿动勿动勿动","pubdate":1439534184000,"status":3,"bigpic":"/upload/2015/08/14/AfterTreatment/1439534183937_u3k3-0.jpg","litpic":"/upload/2015/08/14/AfterTreatment/1439534183937_u3k3-1.jpg","vname":"朝阳1919小剧场","begindate":1443801600000,"enddate":1443888000000,"lasttime":1441612458000,"lastuser":"admin"}
													 //<xml><URL><![CDATA[http://211.99.231.89/ylphone-web/wechat/api]]></URL><ToUserName><![CDATA[ylpw]]></ToUserName><FromUserName><![CDATA[dragon]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content><MsgId>1348831860</MsgId></xml>
		} catch (IOException e) {
			logger.error(e);
		}
		
		resultMap.put("code", 200);
		resultMap.put("message", "success");
		return resultMap.toString();
	}
	
	/**
	 *<p>测试发送POST请求,参数类型为Map</p>
	 * @throws Exception 
	 */
	@RequestMapping("/sendMap")
	@ResponseBody
	public String testPostMap(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("params=" + params);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("code", 200);
		resultMap.put("message", "success");
		
		return JSON.toJSONString(resultMap);
	}
	
}










