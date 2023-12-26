package com.pt.dota.analyzer.api.rest.handler

import com.pt.dota.analyzer.service.MatchService
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Server.ServerRequest

class MatchHandler(
    val matchService: MatchService
) {

    fun getByPlayer(serverRequest: ServerRequest){

    }
}