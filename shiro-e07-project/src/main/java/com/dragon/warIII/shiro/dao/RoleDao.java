package com.dragon.warIII.shiro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dragon.warIII.shiro.common.BaseDao;
import com.dragon.warIII.shiro.model.Resource;
import com.dragon.warIII.shiro.model.Role;
import com.dragon.warIII.shiro.model.RoleResource;
import com.dragon.warIII.shiro.model.UserRole;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao{

	@Override
	public List<Role> listRole() {
		return super.find("from Role", null);
	}

	@Override
	public List<Role> listUserRole(int uid) {
		String hql = "select r from UserRole ur, Role r, User u where u.id=ur.userId and " +
				"r.id=ur.roleId and u.id=?";
		return super.find(hql, uid);
	}

	@Override
	public UserRole loadUserRole(int uid, int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserRole(int uid, int roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserRole(int uid, int roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserRole(int uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resource> listRoleResource(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoleResource(int roleId, int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoleResource(int roleId, int resId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleResource loadResourceRole(int roleId, int resId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
