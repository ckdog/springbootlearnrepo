package com.yxyc.springbootrestful.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * 开启配置
 */
@Configuration
public class MybatisConfig {

	public ConfigurationCustomizer configurationCustomizer(){
		return new ConfigurationCustomizer() {
			@Override
			public void customize(org.apache.ibatis.session.Configuration configuration) {
				configuration.setMapUnderscoreToCamelCase(true);//开启驼峰命名
			}
		};
	}
}
