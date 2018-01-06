package com.leisure.locoy.provider.app;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.leisure.locoy")
@MapperScan(basePackages="com.leisure.locoy.provider.dao")
@EnableScheduling
public class LocoyProviderMain  extends SpringBootServletInitializer{
	private static final Logger LOGGER_MEMBER = LoggerFactory.getLogger(LocoyProviderMain.class);
    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                	LOGGER_MEMBER.info("JVM停服");
                } catch (Exception e) {
                	LOGGER_MEMBER.error("JVM 钩子关闭异常!");
                }
            }
        });
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(LocoyProviderMain.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LocoyProviderMain.class, args);
    }

}
