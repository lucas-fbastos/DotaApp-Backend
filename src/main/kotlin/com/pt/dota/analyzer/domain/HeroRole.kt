package com.pt.dota.analyzer.domain

import java.time.OffsetDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate

data class HeroRole(
    @Id
    var id: Int? = null,
    var roleName: String,
    val heroId: Int,
    @CreatedDate
    var dateCreated: OffsetDateTime? = null,
    @LastModifiedDate
    var lastUpdated: OffsetDateTime? = null,

)
