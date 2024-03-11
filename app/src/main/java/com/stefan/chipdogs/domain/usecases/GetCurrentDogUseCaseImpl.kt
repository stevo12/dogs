package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.data.services.DogBreedsService
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel
import javax.inject.Inject

class GetCurrentDogUseCaseImpl @Inject constructor(
    private val dogBreedsService: DogBreedsService
) : GetCurrentDogUseCase {

    override fun getCurrentDog(): DogItemModel? = dogBreedsService.getCurrentDog()

}