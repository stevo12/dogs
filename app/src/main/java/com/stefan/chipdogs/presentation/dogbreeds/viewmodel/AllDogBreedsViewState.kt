package com.stefan.chipdogs.presentation.dogbreeds.viewmodel

import com.stefan.chipdogs.data.models.AppException
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel

data class AllDogBreedsViewState(
    val dogBreedModel: List<DogItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val appException: AppException? = null
)
