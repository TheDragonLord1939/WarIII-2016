package com.dragon.warIII.service.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.service.blog.dao.BlogDAO;
import com.dragon.warIII.service.blog.entity.Blog;
import com.dragon.warIII.service.blog.service.BlogService;

public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDAO blogDAO;
	
	@Override
	public List<Blog> findBlogList() {
		return blogDAO.findBlogList();
	}

	
}
