package com.dragon.warIII.service.blog.dao;

import java.util.List;

import com.dragon.warIII.service.blog.entity.Blog;

public interface BlogDAO {

	List<Blog> findBlogList();
}
