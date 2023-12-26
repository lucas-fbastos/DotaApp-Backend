package com.pt.dota.analyzer.external.opendota

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import com.pt.dota.analyzer.commons.opendota.OpenDotaRecentMatch
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux

@Component
class OpenDotaReactiveClient(
    @Qualifier("OPEN_DOTA_CLIENT") val webClient: WebClient,
) : OpenDotaRestClient {

    override suspend fun getOpenDotaHeroes(): Flux<OpenDotaHero> =
        webClient
            .get()
            .uri(OPEN_DOTA_GET_HEROES_ENDPOINT)
            .retrieve()
            .bodyToFlux<OpenDotaHero>()

    override suspend fun getRecentMatchesByPlayer(playerId: String): Flux<OpenDotaRecentMatch> =
        webClient
            .get()
            .uri(OPEN_DOTA_GET_PLAYER_RECENT_MATCHES,playerId)
            .retrieve()
            .bodyToFlux<OpenDotaRecentMatch>()

}

internal const val OPEN_DOTA_GET_HEROES_ENDPOINT = "/heroes"
internal const val OPEN_DOTA_GET_PLAYER_RECENT_MATCHES = "players/{playerId}/matches"