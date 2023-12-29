package com.pt.dota.analyzer.domain.mappers

import com.pt.dota.analyzer.commons.opendota.OpenDotaRecentMatch
import com.pt.dota.analyzer.domain.GameMode
import com.pt.dota.analyzer.domain.Rank
import com.pt.dota.analyzer.domain.RecentMatch
import kotlin.time.DurationUnit
import kotlin.time.toDuration


object RecentMatchMapper {

    fun toRecentMatch(openDotaRecentMatch: OpenDotaRecentMatch): RecentMatch
        = RecentMatch(
            matchId = openDotaRecentMatch.matchId,
            playerSlot = openDotaRecentMatch.playerSlot,
            duration = openDotaRecentMatch.duration.toDuration(unit = DurationUnit.SECONDS).inWholeMinutes,
            gameMode = GameMode.getById(openDotaRecentMatch.gameMode),
            kills = openDotaRecentMatch.kills,
            deaths = openDotaRecentMatch.deaths,
            assists = openDotaRecentMatch.assists,
            averageRank = Rank.convertFromApiModel(openDotaRecentMatch.averageRank),
            leaverStatus = openDotaRecentMatch.leaverStatusEnum,
            partySize = openDotaRecentMatch.partySize,
            radiantWon = openDotaRecentMatch.radiantWin
        )

}