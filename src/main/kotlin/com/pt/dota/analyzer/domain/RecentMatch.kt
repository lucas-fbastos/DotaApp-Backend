package com.pt.dota.analyzer.domain

import com.pt.dota.analyzer.commons.opendota.LeaverStatus
import kotlin.time.Duration


data class RecentMatch(
    val matchId: String,
    val playerSlot: Int?,
    val duration: Long,
    val gameMode: GameMode,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val averageRank: Rank?,
    val leaverStatus: LeaverStatus,
    val partySize: Int?,
    val radiantWon: Boolean?,

) {
     val playerTeam: String ?
        get() = playerSlot?.let { if (playerSlot <= 127) "Radiant" else "Dire" }

    val playerWon: Boolean?
        get() = playerTeam?.let { (it == "Radiant" && radiantWon == true) || (it == "Dire" && radiantWon == false) }
}

enum class GameMode(
    val id: Int,
    val description: String
) {
    UNKNOWN(0,"Unknown"),
    ALL_PICK(1,"All Pick"),
    CAPTAINS_MODE(2,"Captains Mode"),
    RANDOM_DRAFT(3,"Random Draft"),
    SINGLE_DRAFT(4, "Single Draft"),
    ALL_RANDOM(5, "All Random"),
    INTRO(6, "Intro"),
    DIRETIDE(7,"Diretide"),
    REVERSE_CAPTAINS_MODE(8,"Reverse Captains Mode"),
    GREEVELING(9, "Greeveling"),
    TUTORIAL(10,"Tutorial"),
    MID_ONLY(11, "Mid Only"),
    LEAST_PLAYED(12,"Least Played"),
    LIMITED_HEROES(13, "Limited Heroes"),
    COMPENDIUM_MATCHMAKING(14, "Compendium Matchmaking"),
    CUSTOM(15,"Custom"),
    CAPTAINS_DRAFT(16, "Captains Draft"),
    BALANCED_DRAFT(17, "Balanced Draft"),
    ABILITY_DRAFT(18, "Ability Draft"),
    EVENT(19, "Event"),
    ALL_RANDOM_DEATH_MATCH(20, "All Random Death Match"),
    MID1V1(21, "1v1 MID"),
    ALL_DRAFT(22, "All Draft"),
    TURBO(23,"Turbo"),
    MUTATION(24, "Mutation"),
    COACHES_CHALLENGE(25,"Coaches Challenge");

    companion object {
        fun getById(id: Int) : GameMode = values().firstOrNull{ gameMode -> gameMode.id == id } ?: UNKNOWN
    }



}