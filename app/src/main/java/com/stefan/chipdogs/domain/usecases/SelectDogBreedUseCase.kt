package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel

interface SelectDogBreedUseCase {

    fun selectDogBreed(dogItemModel: DogItemModel)
}