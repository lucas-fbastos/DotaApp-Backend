package com.pt.dota.analyzer.api.rest

import com.pt.dota.analyzer.api.rest.handler.HeroHandler
import com.pt.dota.analyzer.api.rest.handler.MatchHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class AppRouter {

    @Bean
    fun router(
        heroHandler: HeroHandler
    ) = coRouter {
        "/heroes".nest {
            GET("", heroHandler::getAll)
            GET("/{id}", heroHandler::getById)
            GET("/seed/json", heroHandler::seedDb)
        }
        "/matches".nest {
           // GET("/{id}",MatchHandler::getByPlayer)
        }

    }
}