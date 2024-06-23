package com.pt.dota.analyzer.domain.mappers

import com.pt.dota.analyzer.commons.opendota.OpenDotaMatch
import com.pt.dota.analyzer.domain.GameMode
import com.pt.dota.analyzer.domain.Hero
import com.pt.dota.analyzer.domain.Item
import com.pt.dota.analyzer.domain.Match
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object MatchMapper {

    fun toMatch(
        openDotaMatch: OpenDotaMatch,
        heroes: List<Hero>,
        items: List<Item>
    ): Match = Match(
        matchId = openDotaMatch.matchId,
        radiantWin = openDotaMatch.radiantWin,
        duration = openDotaMatch.duration
            .toDuration(DurationUnit.MILLISECONDS),
        gameMode = GameMode.getById(openDotaMatch.gameMode),
        cluster = openDotaMatch.cluster,
        direScore = openDotaMatch.direScore,
        radiantScore = openDotaMatch.radiantScore,
        humanPlayers = openDotaMatch.humanPlayers,
        positiveVotes = openDotaMatch.positiveVotes,
        negativeVotes = openDotaMatch.negativeVotes,
        winner =  if (openDotaMatch.radiantWin)  "Radiant" else "Dire",
        version = openDotaMatch.version,
        players = openDotaMatch.players.map {
            PlayerMapper.toPlayer(
                openDotaMatchPlayer = it,
                hero = heroes.first{ hero -> hero.id == it.heroId },
                items = items.filter{ item -> item.id in it.itemIds() }
                    .associateBy { item -> item.id  }
            )
        }
    )
}
