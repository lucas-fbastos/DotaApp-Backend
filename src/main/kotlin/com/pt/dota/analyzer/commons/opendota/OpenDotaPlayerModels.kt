package com.pt.dota.analyzer.commons.opendota

data class OpenDotaPlayer(
    val soloCompetitiveRank: Int?,
    val competitiveRank: Int?,
    val rankTier: Int,
    val leaderboardRank: Long,
    val mmrEstimate: MmrEstimate?,
    val profile: Profile?,
)

data class MmrEstimate(
    val estimate: Int?,
)

data class Profile(
    val accountId: Long,
    val personaName: String,
    val name: String,
    val plus: Boolean,
    val cheese: Int,
    val steamId: String,
    val avatar: String,
    val avatarMedium: String,
    val avatarFull: String,
    val profileUrl: String,
    val lastLogin: String,
    val locCountryCode: String,
    val isContributor: Boolean,
    val isSubscriber: Boolean,
)
