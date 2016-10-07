package com.dragon.warIII.timer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.dragon.warIII.service.blog.entity.Blog;
import com.dragon.warIII.service.blog.service.BlogService;
import com.dragon.warIII.util.SolrTool;

public class BlogIndexTimer {

	private static Logger log = LoggerFactory.getLogger(BlogIndexTimer.class);
	
	@Autowired
	private BlogService blogService;
	
	@Scheduled(cron="0 30 20 * * ?")
	public synchronized void updateBlogIndexAll() {
		try {
			//1.删除全部索引
			SolrTool.deleteAll();
			//2.获取要添加索引的实体集合
			List<Blog> blogList = blogService.findBlogList();
			//3.将实体集合添加到索引中
			SolrTool.add(blogList);
		} catch (Exception e) {
			log.error("全量更新索引失败,失败原因:{}", e.getMessage(), e);
		}
	}
	
}
