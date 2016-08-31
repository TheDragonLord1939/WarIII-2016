package com.dragon.warIII.cache.common;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:conf/applicationContext-springDangaMemcached.xml"})
@ContextConfiguration(locations = { "classpath:conf/applicationContext-springXMemcached.xml"})
public class SuperTest {

}
