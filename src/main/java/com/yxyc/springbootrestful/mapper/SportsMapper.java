package com.yxyc.springbootrestful.mapper;

import com.yxyc.springbootrestful.pojo.Sports;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SportsMapper {
	@Select("select * from sports where id=#{id}")
	public List<Sports> getSportsById(int id);
}
