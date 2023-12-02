package com.pt.dota.analyzer.domain


import java.time.OffsetDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate

data class Hero (
    @Id
    val id: Int? = null,
    val name: String ,
    var localizedName: String,
    var primaryAttribute: String,
    var attackType: String,
    var image: String,
    var icon: String,
    @CreatedDate
    var dateCreated: OffsetDateTime? = null,
    @LastModifiedDate
    var lastUpdated: OffsetDateTime? = null,
)
