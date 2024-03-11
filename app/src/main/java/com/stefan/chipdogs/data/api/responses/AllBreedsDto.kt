package com.stefan.chipdogs.data.api.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AllBreedsDto(
    @Json(name = "message")
    val message: Map<String, Any>?,
    @Json(name = "status")
    val status: String?
)