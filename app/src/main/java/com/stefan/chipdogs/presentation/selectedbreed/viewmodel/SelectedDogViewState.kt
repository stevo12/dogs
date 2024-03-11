package com.stefan.chipdogs.presentation.selectedbreed.viewmodel

import com.stefan.chipdogs.data.models.AppException

data class SelectedDogViewState(
    val images: List<String?> = emptyList(),
    val isLoading: Boolean = false,
    val appException: AppException? = null
)
