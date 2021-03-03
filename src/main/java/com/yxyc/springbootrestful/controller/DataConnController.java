package com.yxyc.springbootrestful.controller;

import com.yxyc.springbootrestful.Service.CacheService;
import com.yxyc.springbootrestful.mapper.SportsMapper;
import com.yxyc.springbootrestful.pojo.Sports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@EnableCaching  //开启缓存注解
public class DataConnController {
	@Autowired
	private SportsMapper sports;
	@Autowired
	private CacheService service;

	@GetMapping("/linkdb/{id}")
	@ResponseBody
	public String link(@PathVariable("id")int id){
		String s = sports.getSportsById(id).get(0).toString();
		System.out.println("===>"+s);

		return s;
	}
		@GetMapping("/linkurl")
	public void link2(HttpServletRequest request){
		System.out.println(request.getRequestURL());
	}
	@GetMapping("/cachedata")
	@ResponseBody
	public String cacheResult(){
		System.out.println("cachedata--->");
		return service.getSportsByid(1).get(0).toString();
	}
}
