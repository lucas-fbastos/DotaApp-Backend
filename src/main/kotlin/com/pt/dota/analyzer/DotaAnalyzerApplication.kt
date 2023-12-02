package com.pt.dota.analyzer

import com.pt.dota.analyzer.config.SeedConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [SeedConfig::class])
class DotaAnalyzerApplication

fun main(args: Array<String>) {
    runApplication<DotaAnalyzerApplication>(*args)
}
