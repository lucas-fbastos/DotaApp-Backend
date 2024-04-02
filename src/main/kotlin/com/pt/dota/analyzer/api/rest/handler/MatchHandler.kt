package com.pt.dota.analyzer.api.rest.handler

import com.pt.dota.analyzer.service.MatchService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class MatchHandler(
    val matchService: MatchService
) {

    suspend fun recentMatches(serverRequest: ServerRequest) : ServerResponse
        = ServerResponse.ok().bodyValueAndAwait(
            matchService.getRecentPlayerMatches(
                serverRequest
                    .pathVariable("playerId")
            )
        )

    suspend fun matchDetails(serverRequest: ServerRequest) : ServerResponse
        = ServerResponse.ok().bodyValueAndAwait(
            matchService.getMatchDetails(
                serverRequest
                    .pathVariable("matchId")
            )
        )
}