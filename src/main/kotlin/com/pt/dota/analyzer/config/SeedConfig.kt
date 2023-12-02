package com.pt.dota.analyzer.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = SEED_CONFIG_PREFIX )
data class SeedConfig (
    val type: SeedType
)

enum class SeedType{
    JSON,
    SQL
}
const val SEED_CONFIG_PREFIX = "seed-mode"