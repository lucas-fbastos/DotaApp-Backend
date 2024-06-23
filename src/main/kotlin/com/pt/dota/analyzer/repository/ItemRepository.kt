package com.pt.dota.analyzer.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.pt.dota.analyzer.domain.Item
import org.springframework.stereotype.Repository

internal const val ITEMS_FILE_NAME = "items.json"
@Repository
class ItemRepository(
    override val fileName: String = ITEMS_FILE_NAME,
    override val mapper: ObjectMapper = jacksonObjectMapper(),
    override val items: MutableList<Item> = mutableListOf(),
) : JsonLocalRepository<Item>(
    fileName = fileName,
    items = items,
    mapper = jacksonObjectMapper(),
    type = object : TypeReference<List<Item>>() {}

)


