package edu.eam.sistemasdistribuidos.integrationhttp.configs;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    private RedisCacheConfiguration redisCacheConfiguration() {
        RedisSerializationContext.SerializationPair<Object> serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(
                new JdkSerializationRedisSerializer()
        );

        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(serializationPair)
                .disableCachingNullValues();
    }

    private RedisCacheManager getCacheManagerByTtl(Long ttl) {
        RedisCacheConfiguration configuration = this.redisCacheConfiguration().entryTtl(Duration.ofSeconds(ttl));

        return RedisCacheManager.builder(this.jedisConnectionFactory())
                .cacheDefaults(configuration)
                .build();
    }

    @Primary
    @Bean("expire30Secs")
    public CacheManager cacheManager30Segs() {
        return getCacheManagerByTtl(30l);
    }

    @Bean("expire5mins")
    public CacheManager cacheManager5Minutes() {
        return getCacheManagerByTtl(300l);
    }

    @Bean("expireOneDay")
    public CacheManager cacheManagerOneDay() {
        return getCacheManagerByTtl(60l * 60l * 24l);
    }

}