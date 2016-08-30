package com.dragon.warIII.fastjson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dragon.warIII.fastjson.entity.Group;
import com.dragon.warIII.fastjson.entity.User;
import com.dragon.warIII.fastjson.entity.Weibo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-springMVC.xml" })
@Ignore
public class FastjsonTest {
	
	/**
	 * json型的字符串 转换为 JsonObject
	 */
	@Test
	public void jsonStr2JsonObject() {
		String s = "{'name':'lili','age':'30'}";
		JSONObject object = JSON.parseObject(s);
		System.out.println(object.toString());
	}
	
	/**
	 * json型的字符串 转换为 JavaBean
	 */
	@Test
	public void jsonStr2JavaBean() {
		String s = "{\"id\":\"0375\", \"city\":\"沈阳\"}"; 
		Weibo weibo = JSON.parseObject(s, Weibo.class);
		System.out.println(weibo.getId());
		System.out.println(weibo.getCity());
	}
	
	/**
	 * 将Map类型的数据 转换为 JsonString, 然后转换 JsonObject
	 */
	@Test
	public void map2JsonStr() {
		Group group = new Group();
		group.setId(1);
		group.setName("group");
		
		User user1 = new User();
		user1.setId(1);
		user1.setName("lili");
		
		User user2 = new User();
		user2.setName("wangyang");
		user2.setId(2);
		
		group.getList().add(user1);
		group.getList().add(user2);
		
		Map<Integer,Object> map = new HashMap<Integer, Object>();
		map.put(1, "no.1");
		map.put(2, "no.2");
		map.put(3, group.getList());
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		
		JSONObject object = JSON.parseObject(jsonString);
		System.out.println(object.get("3"));
		
	}
	
	/**
	 * 由一个复杂的Object 转换为 JsonStr
	 */
	@Test
	public void object2JsonStr() {
		Group group = new Group();
		group.setId(1);
		group.setName("group");
		
		User user1 = new User();
		user1.setId(1);
		user1.setName("lili");
		
		User user2 = new User();
		user2.setName("wangyang");
		user2.setId(2);
		
		group.getList().add(user1);
		group.getList().add(user2);
		
		String jsonString = JSON.toJSONString(group);
		System.out.println(jsonString);
		
	}
	
	/**
	 * 一个相对复杂的例子：
	 * JSON文本数据：
	 * 		首先是JSONObject,转换为JSONArray
	 * 		然后将JSONArray转换为JavaBean
	 */
	@Test
	public void jsonArrayStr2JavaBean(){
		String s = "{\"js\":[{\"id\":\"1\", \"city\":\"沈阳1\"},{\"id\":\"2\", \"city\":\"沈阳1\"},{\"id\":\"0375\", \"city\":\"沈阳3\"}]}";
		JSONObject object = JSON.parseObject(s);
		String jsonArray = object.get("js").toString();
		List<Weibo> list = JSON.parseArray(jsonArray, Weibo.class);
		for (Weibo weibo : list) {
			System.out.println(weibo.getCity());
		}
	}
	
	/**
	 * 将JavaBean转换为JSON对象
	 */
	@Test
	public void javaBean2JsonObject() {
		Weibo weibo = new Weibo();
		weibo.setCity("dalian");
		weibo.setId("11");
		JSONObject json = (JSONObject) JSON.toJSON(weibo);
		System.out.println(json.get("id"));
	}
	
	/**
	 * 将JsonArrayStr 转换为 JavaBean集合
	 */
	@Test
	public void jsonArrayStr2ListJavaBean() {
		  String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";  
		  List<Weibo> list = JSON.parseArray(s, Weibo.class);
		  for(Weibo weibo : list) {
			  System.out.println(weibo.getCity());
		  }
		  
	}
	
	/**
	 * 将JavaBean转换为Json格式的数据
	 */
	@Test
	public void javaBean2JsonStr() {
		Weibo weibo = new Weibo("123456", "上海");
		String string = JSON.toJSONString(weibo);
		System.out.println(string);
	}
}














