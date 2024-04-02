package com.pt.dota.analyzer.commons.opendota

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL

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

@JsonInclude(NON_NULL)
data class OpenDotaMatch(
    @JsonProperty("match_id")
    val matchId: Long,
    @JsonProperty("barracks_status_dire")
    val barracksStatusDire: Int,
    @JsonProperty("barracks_status_radiant")
    val barracksStatusRadiant: Int,
    val chat: List<Chat>?,
    val cluster: Int,
    @JsonProperty("dire_score")
    val direScore: Int,
    val duration: Int,
    val engine: Int,
    @JsonProperty("first_blood_time")
    val firstBloodTime: Int,
    @JsonProperty("game_mode")
    val gameMode: Int,
    @JsonProperty("human_players")
    val humanPlayers: Int,
    val leagueid: Int,
    @JsonProperty("lobby_type")
    val lobbyType: Int,
    @JsonProperty("match_seq_num")
    val matchSeqNum: Long,
    @JsonProperty("negative_votes")
    val negativeVotes: Int,
    val objectives: List<Any>?,
    @JsonProperty("picks_bans")
    val picksBans: List<PickBan>,
    @JsonProperty("positive_votes")
    val positiveVotes: Int,
    @JsonProperty("radiant_gold_adv")
    val radiantGoldAdv: List<Int>?,
    @JsonProperty("radiant_score")
    val radiantScore: Int,
    @JsonProperty("radiant_win")
    val radiantWin: Boolean,
    @JsonProperty("radiant_xp_adv")
    val radiantXpAdv: List<Int>?,
    @JsonProperty("start_time")
    val startTime: Int,
    @JsonProperty("tower_status_dire")
    val towerStatusDire: Int,
    @JsonProperty("tower_status_radiant")
    val towerStatusRadiant: Int,
    val version: Int,
    @JsonProperty("replay_salt")
    val replaySalt: Int,
    @JsonProperty("series_id")
    val seriesId: Int,
    @JsonProperty("series_type")
    val seriesType: Int,
    val league: Any?,
    val skill: Int,
    val players: List<OpenDotaMatchPlayer>,
    val patch: Int,
    val region: Int,
    @JsonProperty("throw")
    val maximumGoldThrow : Int,
    val comeback: Int,
    val loss: Int,
    val win: Int,
    @JsonProperty("replay_url")
    val replayUrl: String?
)

@JsonInclude(NON_NULL)
data class OpenDotaMatchPlayer(
    @JsonProperty("account_id")
    val accountId: Long?,
    @JsonProperty("personaname")
    val personaName: String?,
    val name: String?,
    @JsonProperty("player_slot")
    val playerSlot: Int,
    @JsonProperty("team_number")
    val teamNumber: Int,
    @JsonProperty("team_slot")
    val teamSlot: Int,
    @JsonProperty("hero_id")
    val heroId: Int,
    @JsonProperty("item_0")
    val item0: Int,
    @JsonProperty("item_1")
    val item1: Int,
    @JsonProperty("item_2")
    val item2: Int,
    @JsonProperty("item_3")
    val item3: Int,
    @JsonProperty("item_4")
    val item4: Int,
    @JsonProperty("item_5")
    val item5: Int,
    @JsonProperty("backpack_0")
    val backpack0: Int,
    @JsonProperty("backpack_1")
    val backpack1: Int,
    @JsonProperty("backpack_2")
    val backpack2: Int,
    @JsonProperty("item_neutral")
    val itemNeutral: Int,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    @JsonProperty("leaver_status")
    val leaverStatus: Int,
    @JsonProperty("last_hits")
    val lastHits: Int,
    val denies: Int,
    @JsonProperty("gold_per_min")
    val goldPerMin: Int,
    @JsonProperty("xp_per_min")
    val xpPerMin: Int,
    val level: Int,
    @JsonProperty("net_worth")
    val netWorth: Int,
    @JsonProperty("aghanims_scepter")
    val aghanimsScepter: Int,
    @JsonProperty("aghanims_shard")
    val aghanimsShard: Int,
    val moonshard: Int,
    @JsonProperty("hero_damage")
    val heroDamage: Int,
    @JsonProperty("tower_damage")
    val towerDamage: Int,
    @JsonProperty("hero_healing")
    val heroHealing: Int,
    val gold: Int,
    @JsonProperty("gold_spent")
    val goldSpent: Int,
    @JsonProperty("ability_upgrades_arr")
    val abilityUpgradesArr: List<Int>,
    @JsonProperty("radiant_win")
    val radiantWin: Boolean,
    @JsonProperty("start_time")
    val startTime: Long,
    val duration: Int,
    val cluster: Int,
    @JsonProperty("lobby_type")
    val lobbyType: Int,
    @JsonProperty("game_mode")
    val gameMode: Int,
    @JsonProperty("is_contributor")
    val isContributor: Boolean,
    val patch: Int,
    val region: Int,
    @JsonProperty("isRadiant")
    val isRadiant: Boolean,
    val win: Int,
    val lose: Int,
    @JsonProperty("total_gold")
    val totalGold: Int,
    @JsonProperty("total_xp")
    val totalXp: Int,
    @JsonProperty("kills_per_min")
    val killsPerMin: Double,
    val kda: Double,
    val abandons: Int,
    @JsonProperty("rank_tier")
    val rankTier: Int?,
    @JsonProperty("is_subscriber")
    val isSubscriber: Boolean,
    val benchmarks: PlayerBenchmarks
)

@JsonInclude(NON_NULL)
data class PlayerBenchmarks(
    @JsonProperty("gold_per_min")
    val goldPerMin: Benchmark,
    @JsonProperty("xp_per_min")
    val xpPerMin: Benchmark,
    @JsonProperty("kills_per_min")
    val killsPerMin: Benchmark,
    @JsonProperty("last_hits_per_min")
    val lastHitsPerMin: Benchmark,
    @JsonProperty("hero_damage_per_min")
    val heroDamagePerMin: Benchmark,
    @JsonProperty("hero_healing_per_min")
    val heroHealingPerMin: Benchmark,
    @JsonProperty("tower_damage")
    val towerDamage: Benchmark
)

@JsonInclude(NON_NULL)
data class Benchmark(
    val raw: Double,
    val pct: Double
)


@JsonInclude(NON_NULL)
data class PickBan(
    @JsonProperty("is_pick")
    val isPick: Boolean,
    @JsonProperty("hero_id")
    val heroId: Int,
    val team: Int,
    val order: Int
)

@JsonInclude(NON_NULL)
data class Chat(
    val time: Int,
    val unit: String,
    val key: String,
    val slot: Int,
    @JsonProperty("player_slot")
    val playerSlot: Int
)