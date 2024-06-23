package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.commons.opendota.OpenDotaMatch
import com.pt.dota.analyzer.domain.mappers.MatchMapper
import com.pt.dota.analyzer.domain.mappers.RecentMatchMapper
import com.pt.dota.analyzer.external.opendota.OpenDotaRestClient
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.awaitLast
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service

@Service
class MatchService(
    val openDotaRestClient: OpenDotaRestClient,
    val heroService: HeroService,
    val itemService: ItemService,
) {

    suspend fun getRecentPlayerMatches(playerId: String)
        = openDotaRestClient.getOpenDotaRecentMatchesByPlayer(playerId)
            .collectList()
            .awaitLast()
            .map {
                RecentMatchMapper.toRecentMatch(it)
            }

    suspend fun getMatchDetails(matchId: String): OpenDotaMatch {
        return coroutineScope {
            val openDotaMatch = openDotaRestClient.getMatchDetails(matchId)
                .awaitSingle()
            val heroes = heroService.getById(
                openDotaMatch.players
                    .map { it.heroId }
            )
            val items = itemService.getById(
                openDotaMatch.players
                    .flatMap { it.itemIds() }
            )
            MatchMapper.toMatch(
                openDotaMatch = openDotaMatch,
                heroes = heroes,
                items = items,
            )
            openDotaRestClient.getMatchDetails(matchId).awaitSingle()
        }

    }
}