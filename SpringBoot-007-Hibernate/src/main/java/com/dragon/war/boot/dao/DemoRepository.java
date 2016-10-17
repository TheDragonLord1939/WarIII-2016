package com.dragon.war.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.dragon.war.boot.entity.Demo;

//到这里保存数据的方法就写完了,CrudRepository类把一些常用的方法都已经进行定义和实现了.那么你现在就可以在别的类引入调用了.
//另外就是在Spring Data的核心接口里面Repository是最基本的接口了,Spring提供了很多实现了该接口的基本接口,如:CrudRepository,PagingAndSortingRepository,SimpleJpaRepository,QueryDslJpaRepository等大量查询接口
public interface DemoRepository extends CrudRepository<Demo, Long> {

}
