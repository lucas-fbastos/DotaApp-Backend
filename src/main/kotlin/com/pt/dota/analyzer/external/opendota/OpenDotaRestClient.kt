package com.pt.dota.analyzer.external.opendota

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import com.pt.dota.analyzer.commons.opendota.OpenDotaItem
import com.pt.dota.analyzer.commons.opendota.OpenDotaItemResponse
import com.pt.dota.analyzer.commons.opendota.OpenDotaMatch
import com.pt.dota.analyzer.commons.opendota.OpenDotaRecentMatch
import com.pt.dota.analyzer.domain.Item
import reactor.core.publisher.Flux

interface OpenDotaRestClient {

   suspend fun getOpenDotaHeroes() : Flux<OpenDotaHero>

   suspend fun getOpenDotaItems() : Flux<Map<String, OpenDotaItem>>

   suspend fun getOpenDotaRecentMatchesByPlayer(playerId: String) : Flux<OpenDotaRecentMatch>

   suspend fun getMatchDetails(matchId: String) : Flux<OpenDotaMatch>
}