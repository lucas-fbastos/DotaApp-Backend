package com.pt.dota.analyzer.external.opendota

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import com.pt.dota.analyzer.commons.opendota.OpenDotaItem
import com.pt.dota.analyzer.commons.opendota.OpenDotaItemResponse
import com.pt.dota.analyzer.commons.opendota.OpenDotaMatch
import com.pt.dota.analyzer.commons.opendota.OpenDotaRecentMatch
import com.pt.dota.analyzer.domain.Item
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

    override suspend fun getOpenDotaItems(): Flux<Map<String, OpenDotaItem>> =
        webClient
            .get()
            .uri(OPEN_DOTA_GET_ITEMS_ENDPOINT)
            .retrieve()
            .bodyToFlux<Map<String, OpenDotaItem>>()


    override suspend fun getOpenDotaRecentMatchesByPlayer(playerId: String): Flux<OpenDotaRecentMatch> =
        webClient
            .get()
            .uri(OPEN_DOTA_GET_PLAYER_RECENT_MATCHES,playerId)
            .retrieve()
            .bodyToFlux<OpenDotaRecentMatch>()

    override suspend fun getMatchDetails(matchId: String): Flux<OpenDotaMatch> =
        webClient
            .get()
            .uri(OPEN_DOTA_GET_MATCH_DETAILS,matchId)
            .retrieve()
            .bodyToFlux<OpenDotaMatch>()

}

private const val OPEN_DOTA_GET_HEROES_ENDPOINT = "/heroes"
private const val OPEN_DOTA_GET_ITEMS_ENDPOINT = "/constants/items"
private const val OPEN_DOTA_GET_PLAYER_RECENT_MATCHES = "/players/{playerId}/recentMatches"
private const val OPEN_DOTA_GET_MATCH_DETAILS = "/matches/{matchId}"