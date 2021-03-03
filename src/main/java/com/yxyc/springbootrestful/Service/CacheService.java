package com.yxyc.springbootrestful.Service;

import com.yxyc.springbootrestful.mapper.SportsMapper;
import com.yxyc.springbootrestful.pojo.Sports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheService {

	@Autowired
	private SportsMapper sport;

	/**
	 * 开启缓存，对查询结果进行缓存
	 * CacheManager缓存管理器，对缓存的真正的crud操作在cache组建中，每一个组件都有一个自己唯一的名字
	 * 几个属性：
	 * 		value、cacheNames：指定缓存组件的名字
	 * 		key：缓存数据使用的key，可以用它来指定。默认使用方法参数的值。
	 * 			编写spEL表示：#id 参数id值
	 * 		keyGenerator：key的生成器，可以自己指定生成器的id
	 * 		cacheManager\cacheResolver:缓存管理器、缓存解析器指定缓存在哪个cache对象中，二选一
	 * 		condition：指定符合条件的情况下缓存，例如condition=“#id > 0”,指定参数id大于0才缓存
	 * 		unless：否定缓存，当unless为true，方法返回值就不缓存，可以对结果进行判断，例如unless = ”#result ==null“如果结果为null就不缓存
	 * 		sync:是否使用异步
	 *
	 * @return
	 */
	@Cacheable(cacheNames = {"sport"},key = "#id")
	public List<Sports> getSportsByid(int id){
		System.out.println("start query db by service method");
		return sport.getSportsById(id);
	}

}
