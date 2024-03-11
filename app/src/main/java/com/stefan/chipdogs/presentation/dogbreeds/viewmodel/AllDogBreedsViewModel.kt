package com.stefan.chipdogs.presentation.dogbreeds.viewmodel

import androidx.lifecycle.ViewModel
import com.stefan.chipdogs.domain.usecases.GetAllDogBreedsUseCase
import com.stefan.chipdogs.domain.usecases.SelectDogBreedUseCase
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class AllDogBreedsViewModel @Inject constructor(
    private val getAllDogBreedsUseCase: GetAllDogBreedsUseCase,
    private val selectedDogBreedUseCase: SelectDogBreedUseCase,

    ) : ContainerHost<AllDogBreedsViewState, AllDogBreedsSideEffects>, ViewModel() {
    override val container: Container<AllDogBreedsViewState, AllDogBreedsSideEffects> =
        container(AllDogBreedsViewState()) {
            initialize()
        }

    private fun initialize() = intent {
        reduce { state.copy(isLoading = true) }

        getAllDogBreedsUseCase.invoke(
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
                        state.copy(
                            isLoading = false,
                            dogBreedModel = it.message?.map { map ->
                                DogItemModel(
                                    name = map.key,
                                )
                            } ?: emptyList(),
                        )
                    }
                }
            }
        )

    }

    fun selectCurrentDogBreed(dogBreedModel: DogItemModel) = intent {
        selectedDogBreedUseCase.selectDogBreed(dogBreedModel)
    }

    fun goToSelectedDogScreen() = intent {
        postSideEffect(AllDogBreedsSideEffects.GoToSelectedDogSideEffect)
    }

    fun dismissErrorDialog() = intent {
        reduce { state.copy(appException = null) }
    }
}