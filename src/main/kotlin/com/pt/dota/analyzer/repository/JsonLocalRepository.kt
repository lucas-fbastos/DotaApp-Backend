package com.pt.dota.analyzer.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.coroutineScope
import org.springframework.data.annotation.Id
import java.io.File

abstract class JsonLocalRepository<T: Identifiable>(
    open val mapper: ObjectMapper,
    open val items : MutableList<T>,
    open val fileName: String,
    open val type: TypeReference<List<T>>
) {
    fun getAll() =
        items.ifEmpty {
            println("EMPTY")
            File(fileName).readBytes().let {
                items.addAll(mapper.readValue(it,type))
                items
            }
        }

    fun getById(id: Int) =
        items.firstOrNull{ it.id == id }

    fun getById(ids: List<Int>) =
        items.filter { it.id in ids }


    suspend fun saveAll(itemsToLoad: List<T>) {
        return coroutineScope {
            val file = File(fileName)
            file.createNewFile()
            mapper.writeValue(file, itemsToLoad)
            items.addAll(itemsToLoad)
        }
    }
}

interface Identifiable {
    @get:Id
    val id: Int?
}