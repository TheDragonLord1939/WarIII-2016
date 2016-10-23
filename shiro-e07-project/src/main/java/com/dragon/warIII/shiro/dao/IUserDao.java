package com.dragon.warIII.shiro.dao;

import java.util.List;

import com.dragon.warIII.shiro.model.User;

public interface IUserDao{

	public List<User> listUser();
	
	public User loadByUserName(String name);
	
	public List<User> listByRole(int id);
	
}
