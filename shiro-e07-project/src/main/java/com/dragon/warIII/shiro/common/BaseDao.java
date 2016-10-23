package com.dragon.warIII.shiro.common;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public class BaseDao<T> {

	@Autowired
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * Hibernate保存方法
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月13日下午4:05:42
	 * @param entity
	 * @return
	 */
	public <T>Serializable save(T entity){
		return hibernateTemplate.save(entity);
	}
	
	/**
	 * Hibernate更新方法
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月13日下午4:05:51
	 * @param entity
	 */
	public <T extends Serializable>void update(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	
	/**  
     * 根据hql查询,直接使用HibernateTemplate的find函数.  
     */  
    @SuppressWarnings("unchecked")   
    public <T> List<T> find(String hql, Object... values) {   
        return (List<T>) this.getHibernateTemplate().find(hql, values);   
    }   
       
    /**  
     * 创建Query对象.<br>  
     * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.  
     */  
    public Query createQuery(String hql,Object... values) { 
        //这里的false表示不创建session保证,当前操作在spring同一个事务的管理下   
        Query query = this.getHibernateTemplate().getSessionFactory().openSession().createQuery(hql);   
        if (values != null) {   
            for (int i = 0; i < values.length; i++) {   
                query.setParameter(i, values[i]);   
            }   
        }   
        return query;
    }   
       
       
    /** 执行一些必须的sql语句把内存中的对象同步到数据库中 */  
    public void flush() {   
        this.getHibernateTemplate().flush();   
    }   
       
    /** 清除对象缓存 */  
    public void clear() {   
        this.getHibernateTemplate().clear();   
    }   
       
    /** 返回iterator接口类型的结果 */  
    @SuppressWarnings("unchecked")   
    public <T> Iterator<T> iterator(String hql,Object...values){   
       return (Iterator<T>) this.getHibernateTemplate().iterate(hql, values);   
    }   

    /** 当前上下文的原生Hibernate session对象,依然受到spring事务管理不需要手动close */  
    public Session getNativeHibernateSession(){   
        return this.getHibernateTemplate().getSessionFactory().getCurrentSession();   
    }   
       
    /**  
     * 当前上下文的原生Hibernate StatelessSession对象<br>  
     * 此对象不级联关联实例,忽略集合不触发Hibernate事件模型和拦截器,没有一级缓存,没有持久化上下文,接近JDBC.  
     */  
    public StatelessSession getNativeStatelessHibernateSession(){   
        return this.getHibernateTemplate().getSessionFactory().openStatelessSession();   
    }   

    /**  
     * 执行本地查询获得SQLQuery对象<br>  
     * 可以调用addEntity(*.class).list();获得对应实体list集合<br>  
     * addEntity.add(*.class).addJoin(*.class).list();获得一对多代理对象<br>  
     */  
    public SQLQuery nativeSqlQuery(String sql){   
        return this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);   
    }   
}
