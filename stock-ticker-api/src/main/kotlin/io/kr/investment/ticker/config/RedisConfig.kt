package io.kr.investment.ticker.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisConfig (
    @Value("\${spring.redis.host}") val host: String,
    @Value("\${spring.redis.port}") val port: Int
){

    @Bean(name = ["reactiveRedisConnectionFactory"])
    fun reactiveRedisConnectionFactory(): ReactiveRedisConnectionFactory{
        return LettuceConnectionFactory(host, port)
    }
}