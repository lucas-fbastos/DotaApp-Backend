package com.pt.dota.analyzer.domain.mappers

import com.pt.dota.analyzer.commons.opendota.OpenDotaItem
import com.pt.dota.analyzer.domain.Item

object ItemMapper {

    fun toItem(openDotaItem: OpenDotaItem):Item  = Item(
        id = openDotaItem.id.toInt(),
        name = openDotaItem.dname,
        cost = openDotaItem.cost,
        image = openDotaItem.img,
        attributes = listOf(),
    )
}