package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.data.models.AllBreedsModel
import com.stefan.chipdogs.data.models.AppException
import com.stefan.chipdogs.data.models.Resource
import com.stefan.chipdogs.data.services.DogBreedsService
import javax.inject.Inject

class GetAllDogBreedsUseCaseImpl @Inject constructor(
    private val dogBreedsService: DogBreedsService

) : GetAllDogBreedsUseCase {
    override suspend fun invoke(
        onError: suspend (AppException) -> Unit,
        onSuccess: (AllBreedsModel) -> Unit
    ) {
        when (val response = dogBreedsService.getAllDogs()) {
            is Resource.Error -> onError(response.failure)
            is Resource.Success -> onSuccess(response.data)
        }
    }
}