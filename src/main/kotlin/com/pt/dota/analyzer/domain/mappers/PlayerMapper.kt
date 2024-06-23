package com.pt.dota.analyzer.domain.mappers

import com.pt.dota.analyzer.commons.opendota.OpenDotaMatchPlayer
import com.pt.dota.analyzer.domain.Hero
import com.pt.dota.analyzer.domain.Item
import com.pt.dota.analyzer.domain.MatchPlayer
import com.pt.dota.analyzer.domain.PlayerItems
import com.pt.dota.analyzer.domain.PlayerScore

object PlayerMapper {

    fun toPlayer(
        openDotaMatchPlayer: OpenDotaMatchPlayer,
        hero: Hero,
        items: Map<Int,Item>
    ) = MatchPlayer(
        accountId = openDotaMatchPlayer.accountId,
        nickname = openDotaMatchPlayer.personaName ?: "UNKNOWN",
        name = openDotaMatchPlayer.name ?: "",
        playerSlot = openDotaMatchPlayer.playerSlot,
        team = if (openDotaMatchPlayer.teamNumber == 0) "Radiant" else "Dire",
        score = PlayerScore(
            kills = openDotaMatchPlayer.kills,
            deaths = openDotaMatchPlayer.deaths,
            assists = openDotaMatchPlayer.assists,
            lastHits = openDotaMatchPlayer.lastHits,
            denies = openDotaMatchPlayer.denies,
            gpm = openDotaMatchPlayer.goldPerMin,
            xpm = openDotaMatchPlayer.xpPerMin,
            heroDamage = openDotaMatchPlayer.heroDamage,
            towerDamage = openDotaMatchPlayer.towerDamage,
            heroHealing = openDotaMatchPlayer.heroHealing,
            level = openDotaMatchPlayer.level
        ),
        hero = hero,
        items = PlayerItems(
            items = mapOf(
                0 to items[openDotaMatchPlayer.item0],
                1 to items[openDotaMatchPlayer.item1],
                2 to items[openDotaMatchPlayer.item2],
                3 to items[openDotaMatchPlayer.item3],
                4 to items[openDotaMatchPlayer.item4],
                5 to items[openDotaMatchPlayer.item5],
            ),
            backpack = mapOf(
                0 to items[openDotaMatchPlayer.backpack0],
                1 to items[openDotaMatchPlayer.backpack1],
                2 to items[openDotaMatchPlayer.backpack2],
            ),
            neutralItem = items[openDotaMatchPlayer.itemNeutral],
            aghsScepter = openDotaMatchPlayer.aghanimsScepter == 1,
            aghsShard = openDotaMatchPlayer.aghanimsShard == 1,
            moonShard = openDotaMatchPlayer.moonshard == 1,
        )
    )
}