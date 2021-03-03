package com.yxyc.springbootrestful;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest/*(classes=SpringBootRestfulApplicationTests.class)*/
@RunWith(SpringRunner.class)
//@SpringBootApplication
public class SpringBootRestfulApplicationTests {
	/*public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulApplicationTests.class,args);
	}*/

	@Test
	void contextLoads() {
		System.out.println("111");
	}

	/*@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;*/
//	@Resource
//	private RedisTemplate<Object,Object> redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * redis常见五大数据类型：
	 * 	String , list , set , hash , zset
	 * 	StringRedisTemplate是简化操作字符串类型redis的类
	 * 		stringRedisTemplate.opsForValue();   简化操作string
	 * 		stringRedisTemplate.opsForHash();	 简化操作hash
	 * 		stringRedisTemplate.opsForSet();	 简化操作set
	 * 		简化方法后可以使用对应数据类型的操作命令
	 */
	@Test
	public void redisTest(){
		stringRedisTemplate.opsForValue().append("msg","hello");
		stringRedisTemplate.opsForHash().put("myhash","hashadd","valuehash");
		stringRedisTemplate.opsForSet().add("myset","mysetvalue");
		System.out.println("msg:  "+stringRedisTemplate.opsForValue().get("msg"));
		System.out.println("myhash:  "+stringRedisTemplate.opsForHash().get("myhash","hashadd"));
		System.out.println("myset:  "+stringRedisTemplate.opsForSet().members("myset"));
	}

	/*@Test
	public void testlinkdta() throws SQLException {
		System.out.println("================>");
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection.toString());
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("show tables;");
		System.out.println(maps.toString());
		System.out.println("================>");
	}*/
}
