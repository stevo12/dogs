package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.data.services.DogBreedsService
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel
import javax.inject.Inject

class SelectDogBreedUseCaseImpl @Inject constructor(
    private val dogBreedsService: DogBreedsService
) : SelectDogBreedUseCase {
    override fun selectDogBreed(dogItemModel: DogItemModel) {
        dogBreedsService.selectDogBreed(dogItemModel)
    }
}