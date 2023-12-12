package com.pt.dota.analyzer.repository

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.pt.dota.analyzer.domain.Hero
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Repository
import java.io.File

@Repository
class HeroRepository(
    val heroes : MutableList<Hero> = mutableListOf<Hero>()
) {

    private val mapper = jacksonObjectMapper()

    suspend fun getAll(): List<Hero> =
        heroes.ifEmpty {
            println("EMPTY")
            File(HERO_FILE_NAME).readBytes().let {
                heroes.addAll(mapper.readValue<List<Hero>>(it))
                heroes
            }
        }

    suspend fun getById(id: Int) =
        heroes.first(){ it.id == id }


    suspend fun saveAll(heroesToLoad: List<Hero>) =
        coroutineScope {
            val heroFile = File(HERO_FILE_NAME)
            heroFile.createNewFile()
            mapper.writeValue(heroFile,heroesToLoad)
            heroes.addAll(heroesToLoad)
        }
}
internal const val HERO_FILE_NAME = "heroes.json"