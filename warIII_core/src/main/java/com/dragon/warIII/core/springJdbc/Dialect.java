package com.dragon.warIII.core.springJdbc;

/**
 * @description 功能描述: 数据库方言接口
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_core
 * @package 包及类名: com.dragon.warIII.springJdbc   Dialect.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public interface Dialect {
   
    /**
     * <p>获取分页sql</p>
     * @param sql 原始查询sql
     * @param offset 开始记录索引（从0开始计数）
     * @param limit 每页记录大小
     * @return 数据库相关的分页sql
     */
    public String getPaginationSql(String sql, int offset, int pageSize);
}