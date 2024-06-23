package com.pt.dota.analyzer.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.pt.dota.analyzer.domain.Hero
import org.springframework.stereotype.Repository

internal const val HERO_FILE_NAME = "heroes.json"
@Repository
class HeroRepository(
    override val fileName: String = HERO_FILE_NAME,
    override val mapper: ObjectMapper = jacksonObjectMapper(),
    override val items: MutableList<Hero> = mutableListOf(),
) : JsonLocalRepository<Hero>(
    fileName = fileName,
    items = items,
    mapper = mapper,
    type = object : TypeReference<List<Hero>>() {}
)

