package com.pt.dota.analyzer.domain.mappers

import com.pt.dota.analyzer.commons.opendota.OpenDotaHero
import com.pt.dota.analyzer.domain.Hero

object HeroMapper {

    fun toHero(openDotaHeroes: List<OpenDotaHero>) : List<Hero>
            = openDotaHeroes.map { toHero(it) }

    fun toHero(openDotaHero: OpenDotaHero) : Hero
        = Hero(
            id = openDotaHero.id,
            name = openDotaHero.name,
            localizedName = openDotaHero.localizedName,
            attackType = openDotaHero.attackType,
            primaryAttribute = openDotaHero.primaryAttribute,
            image = openDotaHero.image.orEmpty(),
            icon = openDotaHero.icon.orEmpty(),
        )


}