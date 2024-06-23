package com.pt.dota.analyzer.domain

import kotlin.time.Duration

data class Match(
    val matchId: Long,
    val radiantWin: Boolean?,
    val duration: Duration,
    val gameMode: GameMode,
    val cluster: Int,
    val direScore: Int,
    val radiantScore: Int,
    val humanPlayers: Int,
    val positiveVotes: Int,
    val negativeVotes: Int,
    val winner: String,
    val version: Int,
    val players: List<MatchPlayer>
)