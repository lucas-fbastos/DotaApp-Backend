package com.pt.dota.analyzer.service

import org.springframework.stereotype.Service


@Service
class SeedService(
    private val heroService: HeroService
) {

    suspend fun seedHeroes() = heroService.saveAll()
}