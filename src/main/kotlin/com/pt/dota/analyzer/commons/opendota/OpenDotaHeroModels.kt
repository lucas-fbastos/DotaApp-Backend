package com.pt.dota.analyzer.commons.opendota

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class OpenDotaHero(
    val id: Int,
    val name: String,
    @JsonProperty("localized_name")
    val localizedName: String,
    @JsonProperty("primary_attr")
    val primaryAttribute: String,
    @JsonProperty("attack_type")
    val attackType: String,
    val image: String?,
    val icon: String?,
    val roles: List<HeroRole>
)

enum class HeroRole(val value: String){
    CARRY(value="Carry"),
    NUKER(value="Nuker"),
    INITIATOR(value="Initiator"),
    DISABLER(value="Disabler"),
    SUPPORT(value="Support"),
    ESCAPE(value="Escape"),
    DURABLE(value="Durable"),
    PUSHER(value="Pusher");

    private companion object {
        @JvmStatic
        @JsonCreator
        fun create(input: String) = enumValues<HeroRole>().find { it.value == input }
    }
}

