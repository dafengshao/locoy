package com.leisure.locoy.spider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class SpiderAppMain extends SpringBootServletInitializer{
	private static final Logger LOGGER_MEMBER = LoggerFactory.getLogger(SpiderAppMain.class);
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

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(SpiderAppMain.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpiderAppMain.class, args);
    }

}
