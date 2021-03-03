package com.yxyc.springbootrestful.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class FitnessRecord {

	private int id;
	private String sportsId;
	private int times;
	private Date dates;
	private int groupscount;
}
