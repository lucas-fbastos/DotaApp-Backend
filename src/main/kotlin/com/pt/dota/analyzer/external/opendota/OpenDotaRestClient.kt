package com.pt.dota.analyzer.external.opendota

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import com.pt.dota.analyzer.commons.opendota.OpenDotaMatch
import com.pt.dota.analyzer.commons.opendota.OpenDotaRecentMatch
import reactor.core.publisher.Flux

interface OpenDotaRestClient {

   suspend fun getOpenDotaHeroes() : Flux<OpenDotaHero>

   suspend fun getOpenDotaRecentMatchesByPlayer(playerId: String) : Flux<OpenDotaRecentMatch>

   suspend fun getMatchDetails(matchId: String) : Flux<OpenDotaMatch>
}