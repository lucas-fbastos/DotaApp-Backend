package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.domain.mappers.RecentMatchMapper
import com.pt.dota.analyzer.external.opendota.OpenDotaRestClient
import kotlinx.coroutines.reactive.awaitLast
import org.springframework.stereotype.Service

@Service
class MatchService(
    val openDotaRestClient: OpenDotaRestClient
) {

    suspend fun getRecentPlayerMatches(playerId: String)
    = openDotaRestClient.getOpenDotaRecentMatchesByPlayer(playerId)
        .collectList()
        .awaitLast()
        .map {
            RecentMatchMapper.toRecentMatch(it)
        }


}