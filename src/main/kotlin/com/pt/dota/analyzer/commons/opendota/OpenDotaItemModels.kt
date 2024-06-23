package com.pt.dota.analyzer.commons.opendota

import com.fasterxml.jackson.annotation.JsonInclude

data class OpenDotaItemResponse(
    val items: Map<String,OpenDotaItem>
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OpenDotaItem(
    val hint: List<String>? = emptyList(),
    val id: String,
    val img: String,
    val dname: String?,
    val qual: String?,
    val cost: Int,
    val behaviour: String?,
    val notes: String,
    val attrib: List<ItemAttribute>,
    val mc: Boolean,
    val hc: Boolean,
    val cd: Any?,
    val lore: String,
    val components: List<String>? = emptyList(),
    val created: Boolean,
)

data class ItemAttribute(
    val key: String,
    val header: String,
    val value: String
)