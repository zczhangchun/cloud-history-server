package com.zhangchun.history.server;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @author zhangchun
 */

@SpringBootApplication
@EnableScheduling
@MapperScan("com.zhangchun.history.server.dao")
@EnableAsync
@EnableApolloConfig
@EnableEurekaClient
public class HistoryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HistoryServerApplication.class, args);
    }


    @Bean
    public DefaultRedisScript<Boolean> defaultRedisScript() {
        DefaultRedisScript<Boolean> defaultRedisScript = new DefaultRedisScript<Boolean>();
        defaultRedisScript.setResultType(Boolean.class);
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("redis/setIfAbsent.lua")));
        return defaultRedisScript;
    }

}
