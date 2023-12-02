package com.pt.dota.analyzer.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.core.io.Resource
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@Component
class DbConfig(
    @Value("classpath:schema.sql")
    private val initSql : Resource,
    private val entityTemplate: R2dbcEntityTemplate
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val query = StreamUtils.copyToString(initSql.inputStream, StandardCharsets.UTF_8)
        println(query)
        entityTemplate
            .databaseClient
            .sql(query)
            .then()
            .subscribe()
    }


}
