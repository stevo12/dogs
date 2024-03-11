package com.stefan.chipdogs.data.api.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SelectedDogBreedRandomImagesDto(
    @Json(name = "message")
    val message: List<String?>?,
    @Json(name = "status")
    val status: String?
)