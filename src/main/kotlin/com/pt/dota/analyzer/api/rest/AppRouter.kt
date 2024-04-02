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
        heroHandler: HeroHandler,
        matchHandler: MatchHandler,
    ) = coRouter {
        "/heroes".nest {
            GET("", heroHandler::getAll)
            GET("/{id}", heroHandler::getById)
            GET("/seed/json", heroHandler::seedDb)
        }
        "/player".nest {
            GET("/{playerId}/recentMatches", matchHandler::recentMatches)
        }
        "/match".nest {
            GET("/{matchId}", matchHandler::matchDetails)
        }

    }
}