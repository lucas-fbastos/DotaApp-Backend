package com.pt.dota.analyzer.config

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCaching
class CaffeineConfig {

    @Bean
    fun cacheManager(): CacheManager{
        val cacheManager: CaffeineCacheManager = CaffeineCacheManager()
        cacheManager.setCaffeine(caffeineCacheBuilder())
        return cacheManager
    }
}