package com.dragon.warIII.core.dao;

import org.springframework.stereotype.Repository;

@Repository
public @interface MyBatisRepository {
	String value() default "";
}
