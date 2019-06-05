package com.vedeng.template.web.cache;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Wyatt
 * @Date: 2019-06-03 15:44
 */
@Configuration
@ComponentScan
@EnableCaching
public class RedissionCacheConfig {

    @Bean(destroyMethod="shutdown")
    RedissonClient client() {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec()).setKeepPubSubOrder(true);
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setConnectTimeout(100)
                .setTimeout(200)
                .setConnectionPoolSize(8)
                .setConnectionMinimumIdleSize(5)
                .setTcpNoDelay(true)
                .setPingConnectionInterval(30000)
                .setKeepAlive(true)
                .setRetryInterval(50);

        RedissonClient client = Redisson.create(config);

        return client;
    }

    @Bean
    CacheManager cacheManager(RedissonClient redissonClient) {
        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
        // 创建一个名称为"testMap"的缓存，过期时间ttl为24分钟，同时最长空闲时maxIdleTime为12分钟。
        config.put("vedeng", new CacheConfig(24*60*60*1000, 12*60*1000));
        return new RedissonSpringCacheManager(redissonClient, config);
    }
}

