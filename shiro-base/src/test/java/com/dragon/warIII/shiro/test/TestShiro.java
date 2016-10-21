package com.dragon.warIII.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class TestShiro {

	@Test
	public void testBase() {
		SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("kh", "123");
		
		try {
			subject.login(token);
			System.out.println(subject.getPrincipal());
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在.");
		} catch (IncorrectCredentialsException e) {
			System.out.println("用户密码不存在.");
		}
		
	}
}
