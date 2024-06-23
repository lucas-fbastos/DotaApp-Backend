package com.pt.dota.analyzer.api.rest.handler

import com.pt.dota.analyzer.service.ItemService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ItemHandler(
    val itemService: ItemService,
) {
    suspend fun getAll(serverRequest: ServerRequest) =
        ServerResponse.ok().bodyValueAndAwait(
            itemService.getAll()
        )

    suspend fun getById(serverRequest: ServerRequest) =
        ServerResponse.ok().bodyValueAndAwait(
            itemService.getById(
                serverRequest
                    .pathVariable("itemId")
                    .toInt()
            )
        )

}