package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.external.opendota.OpenDotaRestClient
import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import kotlinx.coroutines.reactive.awaitLast
import org.springframework.stereotype.Service

@Service
class OpenDotaHeroService(
    val openDotaRestClient: OpenDotaRestClient,
) {

     suspend fun getAll(): List<OpenDotaHero> =
        openDotaRestClient.getOpenDotaHeroes().collectList().awaitLast()


}