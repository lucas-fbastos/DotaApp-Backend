package com.pt.dota.analyzer.external.opendota.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class OpenDotaConfiguration {

    @Bean(name = ["OPEN_DOTA_CLIENT"])
    fun webClient() : WebClient {
        val size = 16 * 1024 * 1024
        val exchangeStrategies = ExchangeStrategies
            .builder()
            .codecs { codecs ->
                codecs.defaultCodecs().maxInMemorySize(size)
            }
        return WebClient.builder()
            .baseUrl(OPEN_DOTA_BASE_URL)
            .exchangeStrategies(exchangeStrategies.build())
            .build()
    }
}

private const val OPEN_DOTA_BASE_URL = "https://www.opendota.com/api"