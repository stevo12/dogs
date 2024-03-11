package com.stefan.chipdogs.presentation.selectedbreed.viewmodel

import androidx.lifecycle.ViewModel
import com.stefan.chipdogs.domain.usecases.GetCurrentDogUseCase
import com.stefan.chipdogs.domain.usecases.GetSelectedDogBreedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SelectedDogViewModel @Inject constructor(
    private val getSelectedDogBreedUseCase: GetSelectedDogBreedUseCase,
    private val getCurrentDogUseCase: GetCurrentDogUseCase

) : ContainerHost<SelectedDogViewState, Unit>, ViewModel() {
    override val container: Container<SelectedDogViewState, Unit> =
        container(SelectedDogViewState()) {
            initialize()
        }

    private fun initialize() = intent {
        reduce { state.copy(isLoading = true) }
        val currentDog = getCurrentDogUseCase.getCurrentDog()
        getSelectedDogBreedUseCase(
            dogName = currentDog?.name ?: "",
            onError = {
                intent {
                    reduce {
                        state.copy(isLoading = false, appException = it)
                    }
                }
            },
            onSuccess = {
                intent {
                    reduce {
                        state.copy(isLoading = false, images = it.images)
                    }
                }
            }

        )
    }

    fun dismissErrorDialog() = intent {
        reduce {
            state.copy(appException = null)
        }
    }
}