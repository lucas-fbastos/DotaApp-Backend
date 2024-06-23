package com.pt.dota.analyzer.service

import com.pt.dota.analyzer.domain.Item
import com.pt.dota.analyzer.domain.mappers.ItemMapper
import com.pt.dota.analyzer.external.opendota.OpenDotaRestClient
import com.pt.dota.analyzer.repository.ITEMS_FILE_NAME
import com.pt.dota.analyzer.repository.ItemRepository
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.io.File


@Service
class ItemService(
    private val openDotaRestClient: OpenDotaRestClient,
    private val itemRepository: ItemRepository,
) {

    @PostConstruct
    fun verifyLocalRepository() {
        runBlocking {
            if (!File(ITEMS_FILE_NAME).exists())
                saveAll()
        }
    }

    suspend fun saveAll() =
        itemRepository.saveAll(getAllFromOpenDota())

    fun getAll() =
        itemRepository.getAll()

    suspend fun getById(id: Int) =
        itemRepository.getById(id) ?: throw Exception("Item not found")

    suspend fun getById(ids: List<Int>) =
        itemRepository.getById(ids)

    suspend fun getAllFromOpenDota(): List<Item> =
        openDotaRestClient.getOpenDotaItems()
            .awaitSingle()
            ?.values
            ?.map { ItemMapper.toItem(it) } ?: emptyList()
}

