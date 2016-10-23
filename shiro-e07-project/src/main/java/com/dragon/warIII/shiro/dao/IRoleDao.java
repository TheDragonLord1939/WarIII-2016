package com.dragon.warIII.shiro.dao;

import java.util.List;

import com.dragon.warIII.shiro.model.Resource;
import com.dragon.warIII.shiro.model.Role;
import com.dragon.warIII.shiro.model.RoleResource;
import com.dragon.warIII.shiro.model.UserRole;

public interface IRoleDao {

	public List<Role> listRole();
	
	public List<Role> listUserRole(int uid);
	
	public UserRole loadUserRole(int uid, int roleId);
	
	public void addUserRole(int uid, int roleId);
	
	public void deleteUserRole(int uid, int roleId);
	
	/**
	 * 删除某个用户的所有角色
	 */
	public void deleteUserRole(int uid);
	
	/**
	 * 根据角色Id获取可以访问的所有资源
	 */
	public List<Resource> listRoleResource(int roleId);
	
	public void addRoleResource(int roleId, int resId);
	
	public void deleteRoleResource(int roleId, int resId);
	
	public RoleResource loadResourceRole(int roleId, int resId);
}
