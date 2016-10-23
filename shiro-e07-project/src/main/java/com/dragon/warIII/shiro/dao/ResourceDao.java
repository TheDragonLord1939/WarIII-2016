package com.dragon.warIII.shiro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dragon.warIII.shiro.common.BaseDao;
import com.dragon.warIII.shiro.model.Resource;
import com.stormpath.sdk.oauth.BaseOAuthToken;

@Repository("resourceDao")
public class ResourceDao extends BaseDao<Resource> implements IResourceDao{

	@Override
	public List<Resource> listResource() {
		return super.find("from Resource", null);
	}

	
}
