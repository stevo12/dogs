package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.data.models.AppException
import com.stefan.chipdogs.data.models.Resource
import com.stefan.chipdogs.data.models.SelectedDogBreedModel
import com.stefan.chipdogs.data.services.DogBreedsService
import javax.inject.Inject

class GetSelectedDogBreedUseCaseImpl @Inject constructor(
    private val dogBreedsService: DogBreedsService
) : GetSelectedDogBreedUseCase {
    override suspend operator fun invoke(
        dogName: String,
        onError: (AppException) -> Unit,
        onSuccess: (SelectedDogBreedModel) -> Unit
    ) {
        when (val response = dogBreedsService.getSelectedDogImages(dogName = dogName)) {
            is Resource.Error -> {
                onError(response.failure)
            }

            is Resource.Success -> {
                onSuccess(response.data)
            }
        }
    }
}