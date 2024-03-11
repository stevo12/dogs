package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel

interface GetCurrentDogUseCase {

    fun getCurrentDog(): DogItemModel?
}