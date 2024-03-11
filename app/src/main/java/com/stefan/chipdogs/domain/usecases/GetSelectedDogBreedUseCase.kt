package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.data.models.AppException
import com.stefan.chipdogs.data.models.SelectedDogBreedModel

interface GetSelectedDogBreedUseCase {

    suspend operator fun invoke(
        dogName: String,
        onError: (AppException) -> Unit,
        onSuccess: (SelectedDogBreedModel) -> Unit
    )
}