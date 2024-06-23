package com.pt.dota.analyzer.domain

data class MatchPlayer (
    val accountId: Long?,
    val nickname: String?,
    val name: String,
    val playerSlot: Int,
    val team: String,
    val hero: Hero,
    val items: PlayerItems,
    val score: PlayerScore,
    val actions: Map<PlayerAction,Int>? = null,
)

data class PlayerItems(
    val items: Map<Int, Item?>,
    val backpack: Map<Int, Item?>,
    val neutralItem: Item?,
    val aghsScepter: Boolean,
    val aghsShard: Boolean,
    val moonShard: Boolean,
)

data class PlayerScore(
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val lastHits: Int,
    val denies: Int,
    val gpm: Int,
    val xpm: Int,
    val heroDamage: Int,
    val towerDamage: Int,
    val heroHealing: Int,
    val level: Int
)

enum class PlayerAction( val actionId: Int){
    DOTA_UNIT_ORDER_NONE(0),
    DOTA_UNIT_ORDER_MOVE_TO_POSITION(1),
    DOTA_UNIT_ORDER_MOVE_TO_TARGET(2),
    DOTA_UNIT_ORDER_ATTACK_MOVE(3),
    DOTA_UNIT_ORDER_ATTACK_TARGET(4),
    DOTA_UNIT_ORDER_CAST_POSITION(5),
    DOTA_UNIT_ORDER_CAST_TARGET(6),
    DOTA_UNIT_ORDER_CAST_TARGET_TREE(7),
    DOTA_UNIT_ORDER_CAST_NO_TARGET(8),
    DOTA_UNIT_ORDER_CAST_TOGGLE(9),
    DOTA_UNIT_ORDER_HOLD_POSITION(10),
    DOTA_UNIT_ORDER_TRAIN_ABILITY(11),
    DOTA_UNIT_ORDER_DROP_ITEM(12),
    DOTA_UNIT_ORDER_GIVE_ITEM(13),
    DOTA_UNIT_ORDER_PICKUP_ITEM(14),
    DOTA_UNIT_ORDER_PICKUP_RUNE(15),
    DOTA_UNIT_ORDER_PURCHASE_ITEM(16),
    DOTA_UNIT_ORDER_SELL_ITEM(17),
    DOTA_UNIT_ORDER_DISASSEMBLE_ITEM(18),
    DOTA_UNIT_ORDER_MOVE_ITEM(19),
    DOTA_UNIT_ORDER_CAST_TOGGLE_AUTO(20),
    DOTA_UNIT_ORDER_STOP(21),
    DOTA_UNIT_ORDER_TAUNT(22),
    DOTA_UNIT_ORDER_BUYBACK(23),
    DOTA_UNIT_ORDER_GLYPH(24),
    DOTA_UNIT_ORDER_EJECT_ITEM_FROM_STASH(25),
    DOTA_UNIT_ORDER_CAST_RUNE(26),
    DOTA_UNIT_ORDER_PING_ABILITY(27),
    DOTA_UNIT_ORDER_MOVE_TO_DIRECTION(28),
    DOTA_UNIT_ORDER_PATROL(29),
    DOTA_UNIT_ORDER_VECTOR_TARGET_POSITION(30),
    DOTA_UNIT_ORDER_RADAR(31),
    DOTA_UNIT_ORDER_SET_ITEM_COMBINE_LOCK(32),
    DOTA_UNIT_ORDER_CONTINUE(33),
    DOTA_UNIT_ORDER_VECTOR_TARGET_CANCELED(34),
    DOTA_UNIT_ORDER_CAST_RIVER_PAINT(35),
    DOTA_UNIT_ORDER_PREGAME_ADJUST_ITEM_ASSIGNMENT(36),
    DOTA_UNIT_ORDER_DROP_ITEM_AT_FOUNTAIN(37),
    DOTA_UNIT_ORDER_TAKE_ITEM_FROM_NEUTRAL_ITEM_STASH(38),
    DOTA_UNIT_ORDER_MOVE_RELATIVE(39),
    DOTA_UNIT_ORDER_CAST_TOGGLE_ALT(40);

    companion object {
        fun fromId(id: Int): PlayerAction? = values().find { it.actionId == id }
    }
}
