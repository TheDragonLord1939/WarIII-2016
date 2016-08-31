package com.dragon.warIII.utils.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description 功能描述: Redis工具类(创建连接Jedis连接池，Jedis提供JedisPool对象，使用比较方便. JedisPool是基于Apache Common Pool实现的.)
 * @author 作 者: L.D
 * @createdate 建立日期：2016-5-17
 * @projectname 项目名称: warIII_utils
 * @packageclass 包及类名: com.dragon.warIII.redis   JedisPoolUtils.java
 */
public class JedisPoolUtils {

	private static JedisPool pool;
	
	static {
		pool = getJedisPool();
	}
	
	/**
	 * @description 功能描述：获取JedisPool(如果已经有了就直接返回，没有才创建JedisPool)
	 * @createdate 建立日期：2016-5-17 
	 */
	private static JedisPool getJedisPool() {
		if (pool == null || pool.isClosed()) {
			return pool = initJedisPool();
		}
		return pool;
	}
	
	private static JedisPool initJedisPool() {
		try {
			//1.读取properties文件信息
			InputStream input = JedisPoolUtils.class.getClassLoader().getResourceAsStream("conf/redis/redis.properties");
			Properties p = new Properties();
			p.load(input);
			
			String host = p.getProperty("redis.host");															//Redis服务器地址
			Integer port = Integer.valueOf(p.getProperty("redis.port").toString());								//服务端口
			Integer timeout = Integer.valueOf(p.getProperty("redis.timeout").toString());						//超时时间：单位ms
			String password = p.getProperty("redis.password");													//授权密码
			
			Integer maxActive = Integer.valueOf(p.getProperty("redis.pool.maxActive").toString());				//最大连接数：能够同时建立的"最大连接数"
			Integer maxIdle = Integer.valueOf(p.getProperty("redis.pool.maxIdle").toString());	 				//最大空闲数：空闲连接数大于maxIdle时，将进行回收
			Integer minIdle = Integer.valueOf(p.getProperty("redis.pool.minIdle").toString());					//最小空闲数：低于minIdle时，将创建新的连接
			Integer maxWait = Integer.valueOf(p.getProperty("redis.pool.maxWait").toString());					//最大等待时间：单位ms
			
			Boolean testOnBorrow =Boolean.valueOf( p.getProperty("redis.pool.testOnBorrow").toString());		//使用连接时，检测连接是否成功
			Boolean testOnReturn =Boolean.valueOf( p.getProperty("redis.pool.testOnReturn").toString());		//返回连接时，检测连接是否成功
			
			//2.创建JedisPool
			JedisPoolConfig config = new JedisPoolConfig();
			
			config.setMaxTotal(maxActive);
			config.setMaxIdle(maxIdle);
			config.setMinIdle(minIdle);
			config.setMaxWaitMillis(maxWait);
			
			config.setTestOnBorrow(testOnBorrow);
			config.setTestOnReturn(testOnReturn);
			
			pool = new JedisPool(config, host, port, timeout, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pool;
	}
	/**----------1.String类型----------*/
	//1.1. set(设置key对应的值为String类型的value):set name lili
	//1.2. setnx(设置key对应的值为String类型的value,如果key已经存在,返回0,nx是not exist的意思)：setnx name lili_new
	//1.3. setex(设置key对应的值为String类型的value,并指定此键值对应的有效期):setex haircolor 10 red
	//1.4. setrange(设置指定key的value值的子字符串):setrange name 6 gmail.com
	//1.5. mset(一次设置多个key的值,成功返回ok表示所有的值都设置了,失败返回0,表示没有任何值被设置):mset key1 lijie1 key2 lijie2
	//1.6. msetnx(一次设置多个key的值,成功返回ok表示所有的值都设置了,失败返回0,表示没有任何值被设置,但是不会覆盖已经存在的key):msetnx key3 lijie3 key2 30
	//1.7. get(获取key对应的String值,如果key不存在返回nil):get key4
	//1.8. getset(设置key的值,并返回key的旧值):getset key4 40
	//1.9. getrange(获取key的value值的子字符串):getrange email 0 4
	//1.10. mget(一次获取多个key的值,如果对应key不存在则对应返回nil):mget key1 key2 key3
	//1.11. incr(对key的值做加加操作,并返回新的值)：incr key4
	//1.12. incrby(同incr类似,加指定值,key不存在的时候设置key,并认为原来的value是0)
	//1.13. decr(对key的值做减减操作):decr key4 
	//1.14. decrby(同decr类似,减指定值):decrby key6 3
	//1.15. append(给指定key的字符串追加value,并返回新字符串值的长度):append name .net
	//1.16. strlen(取指定key的value值的长度):strlen name
	/**----------2.Hash类型----------*/
	//2.1. hset(设置hash field为指定值,如果key不存在,则先创建)：hset user:001 name lijie
	//2.2. hsetnx(设置hash field为指定值,如果key不存在,则先创建.如果存在返回0)：hsetnx  user:001 name lamp
	//2.3. hmset(同时设置hash的多个field)：hmset user:003 name lijie age 20 sex 1
	//2.4. hget(获取指定的hash field):hget user:003 name
	//2.5. hincrby(指定的hash field加上给定值):hincrby user:003 age 5
	//2.6. hexists(测试指定field是否存在,存在返回1,不存在返回0):hexists user:003 age
	//2.7. hlen(返回指定hash的field数量):hlen user:001
	//2.8. hdel(删除指定hash的field):hdel user:001 age
	//2.9. hkeys(返回hash的所有field):hkeys user:001
	//2.10. hvals(返回hash的所有value):hvals user:001
	//2.11. hgetall(获取某个hash中全部的field及value):hgetall user:001
	/**----------3.List类型----------*/
	//3.1. lpush(在key对应list头部添加字符串元素)：lpush mylist "world"
	//3.2. rpush(在key对应list的尾部添加字符串元素):rpush mylist "hello"
	//3.3. linsert(在key对应list的特定位置前或后添加字符串):linset mylist before "word" "hello"
	//3.4. lset(设置list中指定下标的元素值):lset mylist 0 "world"
	//3.5. lrem(从key对应list中删除n个和value相同的元素(n<0从尾部删除,n=0全部删除))：lrem mylist 1 "hello"
	//3.6. ltrim(保留指定key的值范围内的数据):ltrim mylist 1 -1
	//3.7. lpop(从list的头部删除元素,并返回删除元素):lpop mylist
	//3.8. rpop(从list的尾部删除元素,并返回删除元素):rpop mylist
	//3.9. rpoplpush(从第一个list的尾部移除元素并添加到第二个list的头部):rpoplpush mylist1 mylist2
	//3.10. lindex(返回名称为key的list中index位置的元素):lindex mylist 0
	//3.11. llen(返回key对应list长度):llen mylist 
	/**----------4.Sets类型----------*/
	//4.1. sadd(向名称为key的set中添加元素):sadd myset "hello"
	//4.2. srem(删除名称为key的set中的元素):srem myset "hello"
	//4.3. spop(随机返回并删除名称为key的set中一个元素):spop myset 
	//4.4. sdiff(返回所有给定key与第一个key的差集):sdiff myset1 myset2
	//4.5. sdiffstore(返回所有给定key与第一个key的差集,并将结果存为另一个key):sdiffstore myset4 myset2 myset3
	//4.6. sinter(返回所有给定key的交集):sinter myset1 myset2
	//4.7. sinterstore(返回所有给定key的交集,并将结果存为另一个key):sinterstore myset1 myset2 myset3
	//4.8. sunion(返回所有给定key的并集):sunion myset1 myset2
	//4.9. sunionstore(返回所有给定key的并集,并将结果存为另一个key):sunionstore myset1 myset2 myset3
	//4.10. smove(从第一个key对应的set中移除member并添加到第二个对应的set中):smove myset1 myset2 three
	//4.11. scard(返回名称为key的set的元素个数):scard myset1
	//4.12. sismember(测试member是否是名称为key的set的元素):sismember myset1 one
	//4.13. srandmember(随机返回名称为key的set的一个元素,但不删除元素):srandmember myset1
	/**----------5.Sorted Sets类型----------*/
	//5.1. zadd(向名称为key的zset中添加元素member,score用于排序.如果该元素存在,则更新其顺序):zadd myzset 1 "one"
	//5.2. zrem(删除名称为key的zset中的元素member):zrem myzset one
	//5.3. zincrby(如果在名称为key的zset中已经存在元素member,则该元素的score增加increment,否则向改集合中添加该元素,其score的值为increment):zincrby myset 13 "one"
	//5.4. zrank(返回名称为key的zset中member元素的排名(按score从小到大排序)即下标):zrank myzset two
	//5.5. zrevrank(返回名称为key的zset中member元素的排名(按score从大到小排序)):zrevrank myzset one
	//5.6. zrevrange(返回名称为key的zset(按score从大到小顺序)中的index从start到end的所有元素):zrevrange myzset 0 -1 withscores
	//5.7. zrangebyscore(返回集合中score在给定区间的元素):zrangebyscore myset 2 3 withscores
	//5.8. zcount(返回集合中score在给定区间的数量):zcount myzset 2 3
	//5.9. zcard(返回集合中的元素个数):zcard myzset1
	//5.10. zremrangebyrank(删除集合中排名在给定区间的元素):zremrangebyrank myzset 1 1
	//5.11. zremrangebyscore(删除集合中score在给定区间的元素):zremrangebyscore myzset 1 2
	/**----------6.Others-键值相关命令----------*/
	//6.1. keys(返回满足给定pattern的所有key):keys *
	//6.2. exists(确认一个key是否存在,存在返回1,不存在返回0):exists name
	//6.3. del(删除一个key):del age
	//6.4. expire(设置一个key的过期时间,时间单位是秒):expire addr 10
	//6.5. move(将当前数据库中的key转移到其它数据库中):move age 1
	//6.6. persist(移除给定key的过期时间):persist age
	//6.7. randomkey(随机返回key空间的一个key):randomkey
	//6.8. rename(重命名key):rename age age_new
	//6.9. type(返回值的类型):type mylist
	/**----------7.Others-服务器相关命令----------*/
	//7.1. ping(测试连接是否存活):ping
	//7.2. echo(在命令行打印一些内容):echo lamp
	//7.3. select(选择数据库,Redis数据库编号从0-15,我们可以选择任意一个数据库来进行数据的存取):select 0
	//7.4. quit(退出连接):quit
	//7.5. dbsize(返回当前数据库中key的数目):dbsize
	//7.6. info(获取服务器的信息和统计):info
	//7.7. config get(实时传储收到的请求):config get dir
	//7.8. flushbd(删除当前选择数据库中的所有key):flushdb
	//7.9. flushall(删除所有数据库中的所有key):flushall
	/**
	 *<p>1.向redis存入key和value,并释放连接资源<p>
	 *<p>如果key已经存在则覆盖<p>
	 *@param key
	 *@param value
	 *@return 成功返回OK,失败返回0
	 */
	private static String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			return jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
	
	/**
	 * <p>2.通过key获取存在redis中的value</p>
	 * <p>并释放连接</p>
	 * @param key
	 * @return 成功返回value，失败返回null
	 */
	public static String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getJedisPool().getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return value;
	}
	
	/**
	 * <p>3.通过key向指定的value值追加值</p>
	 * @param key
	 * @param str
	 * @return  成功返回添加后value的长度,失败返回0L
	 */
	public static Long append(String key, String str) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedisPool().getResource();
			res = jedis.append(key, str);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return res;
	}
	
	/**
	 * <p>4.删除指定的key,也可以传入一个包含key的数组</p>
	 * @param keys
	 * @return  
	 */
	public static Long del(String... keys) {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			return jedis.del(keys);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
	
	/**
	 * <p>5.设置key value,如果key已经存在则返回0,nx==>not exist</p>
	 * @param key 
	 * @param value
	 * @return 成功返回1,如果存在和发生异常返回0
	 */
	public static Long setnx(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			return jedis.setnx(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return 0L;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
	
	/**----------Others----------*/
	/**
	 * <p>判断key是否存在</p>
	 * @param key
	 * @return  存在返回true,不存在和异常返回false
	 */
	public static Boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			return jedis.exists(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		Jedis jedis = pool.getResource();
		Long l = setnx("sex","fuck");
		System.out.println(l);
	}
}
