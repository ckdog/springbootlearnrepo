package com.yxyc.springbootrestful.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ha.DataSourceCreator;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

	@ConfigurationProperties(prefix = "spring.datasource")//引入配置文件中datasource的所有数据库连接属性
	@Bean
	public DataSource druid() {
		return new DruidDataSource();
	}

	//配置druid的监控
	//1 配置一个管理后台的servlet
	@Bean
	public ServletRegistrationBean staticViewServlet(){
		//StatViewServlet  --> ResourceServlet 配置请求属性的用户名吗等
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String,String> map =new HashMap<>();
		map.put("loginUsername","root");
		map.put("loginPassword","root");
		map.put("allow","");//允许访问地址，不写就是默认允许所有
		map.put("deny","");//同allow
		bean.setInitParameters(map);

		return bean;
	}
	//2 配置web监控filter
	@Bean
	public FilterRegistrationBean webStateFilter(){
		FilterRegistrationBean bean =new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());

		Map<String,String> initParams =new HashMap<>();
		initParams.put("exclusions","*.js,*.css,/druid/*,/linkdb/*");

		bean.setInitParameters(initParams);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}

}
