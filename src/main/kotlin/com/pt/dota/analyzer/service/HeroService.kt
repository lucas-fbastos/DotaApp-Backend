package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import com.pt.dota.analyzer.domain.Hero
import com.pt.dota.analyzer.domain.mappers.HeroMapper
import com.pt.dota.analyzer.external.opendota.OpenDotaRestClient
import com.pt.dota.analyzer.repository.HERO_FILE_NAME
import com.pt.dota.analyzer.repository.HeroRepository
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.reactive.awaitLast
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.io.File


@Service
class HeroService(
    private val openDotaRestClient: OpenDotaRestClient,
    private val heroRepository: HeroRepository
) {

    @PostConstruct
    fun verifyLocalRepository() {
        runBlocking {
            if (!File(HERO_FILE_NAME).exists())
                saveAll()
        }
    }

    suspend fun saveAll() =
        heroRepository.saveAll(getAllFromOpenDota())

    suspend fun getAll() =
        heroRepository.getAll()

    suspend fun getById(id: Int) =
        heroRepository.getById(id)

    suspend fun getAllFromOpenDota(): List<Hero> =
        openDotaRestClient.getOpenDotaHeroes().collectList().awaitLast()
            .map { HeroMapper.toHero(it) }
}

