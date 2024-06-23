package com.pt.dota.analyzer.domain


import com.pt.dota.analyzer.repository.Identifiable
import java.time.OffsetDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

data class Hero (
    override val id: Int? = null,
    val name: String,
    var localizedName: String,
    var primaryAttribute: String,
    var attackType: String,
    var image: String,
    var icon: String,
    @CreatedDate
    var dateCreated: OffsetDateTime? = null,
    @LastModifiedDate
    var lastUpdated: OffsetDateTime? = null,
) : Identifiable
