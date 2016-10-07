package com.dragon.warIII.service.blog.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dragon.warIII.core.dao.SuperDAO;
import com.dragon.warIII.service.blog.dao.BlogDAO;
import com.dragon.warIII.service.blog.entity.Blog;

public class BlogDAOImpl implements BlogDAO{

	private final static String NAME_SPACE = "com.dragon.warIII.service.blog.dao.BlogDAO.";
	
	@Autowired
	@Qualifier("superDAO")
	private SuperDAO superDAO;
	
	@Override
	public List<Blog> findBlogList() {
		List<Blog> list = superDAO.getMyBatisFactory().getSqlSessionTemplate().selectList(NAME_SPACE.concat("findBlogList"));
		return list;
	}

	
}
