package com.pt.dota.analyzer.domain

import com.pt.dota.analyzer.commons.opendota.ItemAttribute
import com.pt.dota.analyzer.repository.Identifiable

data class Item(
    override val id: Int,
    val name: String?,
    val cost: Int,
    val image: String,
    val attributes: List<ItemAttribute>
) : Identifiable

