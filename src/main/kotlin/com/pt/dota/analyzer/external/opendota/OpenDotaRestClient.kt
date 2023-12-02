package com.pt.dota.analyzer.external.opendota

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import reactor.core.publisher.Flux

interface OpenDotaRestClient {

   suspend fun getOpenDotaHeroes() : Flux<OpenDotaHero>
}