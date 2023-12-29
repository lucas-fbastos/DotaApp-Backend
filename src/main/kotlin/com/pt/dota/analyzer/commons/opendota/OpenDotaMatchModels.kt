package com.pt.dota.analyzer.commons.opendota

import com.fasterxml.jackson.annotation.JsonProperty

data class OpenDotaRecentMatch(
    @JsonProperty("match_id")
    val matchId: String,
    @JsonProperty("player_slot")
    val playerSlot: Int?,
    @JsonProperty("radiant_win")
    val radiantWin: Boolean?,
    val duration: Long,
    @JsonProperty("game_mode")
    val gameMode: Int,
    @JsonProperty("lobby_type")
    val lobbyType: Int,
    @JsonProperty("hero_id")
    val heroId: Int,
    @JsonProperty("start_time")
    val startTime: Long,
    val version: Int?,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val skill: Int?,
    @JsonProperty("average_rank")
    val averageRank: Int?,
    @JsonProperty("leaver_status")
    val leaverStatus: Int,
    @JsonProperty("party_size")
    val partySize: Int?,
){

    val leaverStatusEnum : LeaverStatus
       get() {
           return if(leaverStatus>2) LeaverStatus.ABANDONED else LeaverStatus.values()[this.leaverStatus]
       }
}

enum class LeaverStatus{
    DIDNT_LEAVE,
    LEFT_SAFELY,
    ABANDONED;
}