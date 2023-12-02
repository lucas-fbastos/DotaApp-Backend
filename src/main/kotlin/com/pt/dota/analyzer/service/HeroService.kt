package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.domain.Hero
import com.pt.dota.analyzer.domain.mappers.HeroMapper
import com.pt.dota.analyzer.repository.HeroRepository
import org.springframework.stereotype.Service


@Service
class HeroService(
    private val openDotaHeroService: OpenDotaHeroService,
    private val heroRepository: HeroRepository
) {

    suspend fun saveAll() =
        heroRepository.saveAll(getAllFromOpenDota())


    suspend fun getAll() =
        heroRepository.getAll()

    suspend fun getById(id: Int) =
        heroRepository.getById(id)

    suspend fun getAllFromOpenDota(): List<Hero> =
        openDotaHeroService.getAll()
            .map { HeroMapper.toHero(it) }
}

