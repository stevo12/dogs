package com.stefan.chipdogs.data.services

import com.stefan.chipdogs.data.models.AllBreedsModel
import com.stefan.chipdogs.data.models.Resource
import com.stefan.chipdogs.data.models.SelectedDogBreedModel
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel

interface DogBreedsService {

    suspend fun getAllDogs(): Resource<AllBreedsModel>

    suspend fun getSelectedDogImages(dogName: String): Resource<SelectedDogBreedModel>

    fun selectDogBreed(dogItemModel: DogItemModel)

    fun getCurrentDog(): DogItemModel?
}