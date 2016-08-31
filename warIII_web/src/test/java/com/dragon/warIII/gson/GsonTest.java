package com.dragon.warIII.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dragon.warIII.gson.entity.Bank;
import com.dragon.warIII.gson.entity.User;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mvc.xml" })
@Ignore
public class GsonTest {

	/**
	 * @description 功能描述：Google Gson测试
	 */
	@Test
	public void toJson() {
		Gson gson = new Gson();
		
		Bank b1 = new Bank(1, "中国工商银行");
		Bank b2 = new Bank(2, "工行银行卡");
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(b1);
		banks.add(b2);
		Map map = new HashMap();
		map.put("10点", "出去卖萌");
		User user1 = new User(1, "张三", false
				, new String[]{"15929292929", "17878787878"}
				, banks
				, map);
		String toString = gson.toJson(user1);
		System.out.println(toString);
	}
//	{"id":1,"name":"张三","isAdmin":false,"tels":["15929292929","17878787878"],"banks":[{"id":1,"bankName":"中国工商银行"},{"id":2,"bankName":"工行银行卡"}],"doSome":{"10点":"出去卖萌"}}

	
	@Test
	public void toObject(){
		Gson gson = new Gson();
		String json = "{'id':1,'name':'张三','isAdmin':false,'tels':['15929292929','17878787878']" +
				",'banks':[{'id':1,'bankName':'中国工商银行'},{'id':2,'bankName':'工行银行卡'}],'doSome':{'10点':'出去卖萌'}}";
		User u = gson.fromJson(json, User.class);
		System.out.println(u);
	}
//	User [id=1, name=张三, isAdmin=false, tels=[15929292929, 17878787878], doSome={10点=出去卖萌}]
	
}












