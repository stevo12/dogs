package com.stefan.chipdogs.data.services

import com.stefan.chipdogs.data.api.responses.AllBreedsDto
import com.stefan.chipdogs.data.api.responses.SelectedDogBreedRandomImagesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApiService {

    @GET("api/breeds/list/all")
    suspend fun getAllBreeds(): AllBreedsDto

    @GET("api/breed/{name}/images/random/{number}")
    suspend fun getSelectedDog(@Path("name") name: String, @Path("number") number: Int): SelectedDogBreedRandomImagesDto
}