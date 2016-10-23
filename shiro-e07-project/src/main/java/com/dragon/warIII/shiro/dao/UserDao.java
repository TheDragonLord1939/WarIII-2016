package com.dragon.warIII.shiro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dragon.warIII.shiro.common.BaseDao;
import com.dragon.warIII.shiro.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao{

	@Override
	public List<User> listUser() {
		return super.find("from User", null);
	}

	@Override
	public User loadByUserName(String name) {
		return (User) super.find("from User where username = ?", name);
	}

	@Override
	public List<User> listByRole(int id) {
		String hql =  "select u from User u, Role r, UserRole ur where " +
					  "u.id = ur.userId and  r.id = ur.roleId " +
				      "and r.id = ?";
		return super.find(hql, id);
	}

	
}
