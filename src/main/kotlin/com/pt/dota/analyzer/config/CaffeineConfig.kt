package com.pt.dota.analyzer.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
@EnableCaching
class CaffeineConfig {

    @Bean
    fun cacheManager(): CacheManager{
        val cacheManager: CaffeineCacheManager = CaffeineCacheManager()
        cacheManager.setCaffeine(caffeineCacheBuilder())
        return cacheManager
    }

    fun caffeineCacheBuilder() : Caffeine<Any,Any> =
        Caffeine.newBuilder()
            .initialCapacity(180)
            .maximumSize(500)
            .expireAfterAccess(10,TimeUnit.MINUTES)
            .weakKeys()
            .recordStats()
}