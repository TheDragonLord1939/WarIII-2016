package com.dragon.warIII.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class StaticRealm extends AuthorizingRealm {
	/**
	 * 用来判断授权的
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 用来判断认证的
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String username = token.getPrincipal().toString();
		String password =  new String((char[])token.getCredentials());
		if (!"kh".equals(username))
			throw new UnknownAccountException("用户名不存在!");
		if (!"123".equals(password)) 
			throw new IncorrectCredentialsException("用户密码错误!");
		
		return new SimpleAuthenticationInfo("yuelonghua@sina.cn", password, getName());
	}

}
