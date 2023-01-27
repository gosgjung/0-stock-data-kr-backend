package io.kr.investment.ticker.config

import io.kr.investment.ticker.corpcode.dto.CorpCodeDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.RedisSerializationContext.RedisSerializationContextBuilder
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig (
    @Value("\${spring.redis.host}") val host: String,
    @Value("\${spring.redis.port}") val port: Int
){

    @Bean(name = ["reactiveRedisConnectionFactory"])
    fun reactiveRedisConnectionFactory(): ReactiveRedisConnectionFactory{
        return LettuceConnectionFactory(host, port)
    }

    @Bean(name = ["corpCodeTemplate"])
    fun corpCodeTemplate(
        reactiveRedisConnectionFactory: ReactiveRedisConnectionFactory
    ) : ReactiveRedisTemplate<String, CorpCodeDto>{
        val keySerializer = StringRedisSerializer()
        val valSerializer : Jackson2JsonRedisSerializer<CorpCodeDto> = Jackson2JsonRedisSerializer<CorpCodeDto>(CorpCodeDto::class.java)

        val builder: RedisSerializationContextBuilder<String, CorpCodeDto> =
            RedisSerializationContext.newSerializationContext<String, CorpCodeDto>(keySerializer)

        val context: RedisSerializationContext<String, CorpCodeDto> = builder
            .key(keySerializer).value(valSerializer)
            .hashKey(keySerializer).hashValue(valSerializer)
            .build()

        return ReactiveRedisTemplate(reactiveRedisConnectionFactory, context)
    }

}