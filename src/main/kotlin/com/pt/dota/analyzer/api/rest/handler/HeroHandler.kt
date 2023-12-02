package com.pt.dota.analyzer.api.rest.handler

import com.pt.dota.analyzer.service.HeroService
import com.pt.dota.analyzer.service.SeedService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait


@Component
class HeroHandler(
    val heroService: HeroService,
    val seedService: SeedService,
) {
    suspend fun getAll(serverRequest: ServerRequest) =
        ServerResponse.ok().bodyValueAndAwait(
            heroService.getAll()
        )

    suspend fun getById(serverRequest: ServerRequest) =
        ServerResponse.ok().bodyValueAndAwait(
            heroService.getById(
                serverRequest
                    .pathVariable("id")
                    .toInt()
            )
        )


    suspend fun seedDb(serverRequest: ServerRequest): ServerResponse {
        seedService.seedHeroes()
        return ServerResponse.ok().bodyValueAndAwait("seed heroes")
    }
}