package com.pt.dota.analyzer.domain

import java.lang.IllegalStateException

enum class Rank(
    private val imageUrl: String,
    private val medalOrder: Int,
    private val medal: String,
    private val star: Int
) {
    UNRANKED("",0,"Not calibrated", 0),
    HAROLD("",1,"Harold",0),
    HAROLD_1("",1,"Harold",1),
    HAROLD_2("",1,"Harold",1),
    HAROLD_3("",1,"Harold",1),
    HAROLD_4("",1,"Harold",1),
    HAROLD_5("",1,"Harold",1),
    GUARDIAN("",2,"Guardian",0),
    GUARDIAN_1("",2,"Guardian",1),
    GUARDIAN_2("",2,"Guardian",2),
    GUARDIAN_3("",2,"Guardian",3),
    GUARDIAN_4("",2,"Guardian",4),
    GUARDIAN_5("",2,"Guardian",5),
    CRUSADER("",3,"Guardian",0),
    CRUSADER_1("",3,"Guardian",1),
    CRUSADER_2("",3,"Guardian",2),
    CRUSADER_3("",3,"Guardian",3),
    CRUSADER_4("",3,"Guardian",4),
    CRUSADER_5("",3,"Guardian",5),
    ARCHON("",4,"Archon",0),
    ARCHON_1("",4,"Archon",1),
    ARCHON_2("",4,"Archon",2),
    ARCHON_3("",4,"Archon",3),
    ARCHON_4("",4,"Archon",4),
    ARCHON_5("",4,"Archon",5),
    LEGEND("",5,"Legend",0),
    LEGEND_1("",5,"Legend",1),
    LEGEND_2("",5,"Legend",2),
    LEGEND_3("",5,"Legend",3),
    LEGEND_4("",5,"Legend",4),
    LEGEND_5("",5,"Legend",5),
    ANCIENT("",6,"Ancient",0),
    ANCIENT_1("",6,"Ancient",1),
    ANCIENT_2("",6,"Ancient",2),
    ANCIENT_3("",6,"Ancient",3),
    ANCIENT_4("",6,"Ancient",4),
    ANCIENT_5("",6,"Ancient",5),
    DIVINE("",7,"Divine",0),
    DIVINE_1("",7,"Divine",1),
    DIVINE_2("",7,"Divine",2),
    DIVINE_3("",7,"Divine",3),
    DIVINE_4("",7,"Divine",4),
    DIVINE_5("",7,"Divine",5),
    IMMORTAL("",8,"Immortal",0);

    fun convertFromApiModel(apiRank: Int): Rank =
         apiRank.toDigits()
             .let {digits ->
                 values()
                    .firstOrNull() { medalOrder == digits[0] && star == digits[1] }
                     ?: throw IllegalStateException()
             }

}

fun Int.toDigits(base: Int = 10): List<Int> =
    sequence {
        var n = this@toDigits
        require(n >= 0)
        while (n != 0) {
            yield(n % base)
            n /= base
        }
    }.toList().asReversed()
