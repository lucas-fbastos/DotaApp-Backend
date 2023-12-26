package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.external.opendota.OpenDotaRestClient
import org.springframework.stereotype.Service

@Service
class MatchService(
    val openDotaRestClient: OpenDotaRestClient
) {

    suspend fun getRecentPlayerMatches(playerId: String){
        openDotaRestClient
            .getRecentMatchesByPlayer(playerId)
            .map{

            }
    }

}