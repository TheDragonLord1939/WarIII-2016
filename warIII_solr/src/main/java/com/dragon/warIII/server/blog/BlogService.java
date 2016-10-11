package com.dragon.warIII.server.blog;

import java.util.List;
import java.util.Map;

import com.dragon.warIII.entity.SearchResult;

/**
 * @description 功能描述: 搜索业务层,提供增删改查操作.
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-11
 * @projectname 项目名称: warIII_solr
 * @packageclass 包及类名: com.dragon.warIII.server.blog  BlogService.java
 */
public interface BlogService {

	SearchResult<List<Map<String, Object>>> getSearchResult(Map<String, String> params, int pageNum, int pageSize);
	
}
