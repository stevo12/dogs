package com.stefan.chipdogs.data.services

import com.stefan.chipdogs.data.models.AllBreedsModel
import com.stefan.chipdogs.data.models.Resource
import com.stefan.chipdogs.data.models.SelectedDogBreedModel
import com.stefan.chipdogs.data.mapers.AllBreedsMapper
import com.stefan.chipdogs.data.mapers.SelectedDogMapper
import com.stefan.chipdogs.data.networking.ApiRequestHandler
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel
import javax.inject.Inject

class DogBreedsServiceImpl @Inject constructor(
    private val apiRequestHandler: ApiRequestHandler,
    private val dogsApiService: DogsApiService,
    private val allBreedsMapper: AllBreedsMapper,
    private val selectedDogMapper: SelectedDogMapper
) : DogBreedsService {

    private var currentSelectedDogBreed: DogItemModel? = null

    override suspend fun getAllDogs(): Resource<AllBreedsModel> {
        val response = apiRequestHandler.handleRequest(
            apiCall = {
                dogsApiService.getAllBreeds()
            },
            successMapper = { response ->
                allBreedsMapper.mapFromResponseToDomain(response)
            }
        )

        return when (response) {
            is Resource.Error -> {
                Resource.Error(response.failure)
            }

            is Resource.Success -> {
                Resource.Success(response.data)
            }
        }
    }

    override suspend fun getSelectedDogImages(dogName: String): Resource<SelectedDogBreedModel> {
        val response = apiRequestHandler.handleRequest(
            apiCall = {
                dogsApiService.getSelectedDog(name = dogName, number = NUMBER_OF_IMAGES)
            },
            successMapper = {
                selectedDogMapper.mapFromResponseToDomain(it)
            }
        )

        return when (response) {
            is Resource.Error -> {
                Resource.Error(response.failure)
            }

            is Resource.Success -> {
                Resource.Success(response.data)
            }
        }
    }

    override fun selectDogBreed(dogItemModel: DogItemModel) {
        currentSelectedDogBreed = dogItemModel
    }

    override fun getCurrentDog(): DogItemModel? = currentSelectedDogBreed
}

const val NUMBER_OF_IMAGES = 10