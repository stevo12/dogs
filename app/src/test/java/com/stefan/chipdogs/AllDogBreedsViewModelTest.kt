package com.stefan.chipdogs

import com.stefan.chipdogs.data.models.AppException
import com.stefan.chipdogs.domain.usecases.GetAllDogBreedsUseCase
import com.stefan.chipdogs.domain.usecases.SelectDogBreedUseCase
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel
import com.stefan.chipdogs.presentation.dogbreeds.viewmodel.AllDogBreedsSideEffects
import com.stefan.chipdogs.presentation.dogbreeds.viewmodel.AllDogBreedsViewModel
import com.stefan.chipdogs.presentation.dogbreeds.viewmodel.AllDogBreedsViewState
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.test.test
import javax.inject.Inject

class AllDogBreedsViewModelTest @Inject constructor() {
    @Mock
    private lateinit var getAllDogBreedsUseCase: GetAllDogBreedsUseCase

    @Mock
    private lateinit var selectDogBreedUseCase: SelectDogBreedUseCase

    @InjectMocks
    private lateinit var allDogBreedsViewModel: AllDogBreedsViewModel


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        allDogBreedsViewModel = AllDogBreedsViewModel(getAllDogBreedsUseCase, selectDogBreedUseCase)
    }


    @Test
    fun `tapping on item triggers side effect`() = runTest {

        val initialState = AllDogBreedsViewState()
        allDogBreedsViewModel.test(this, initialState,
            validate = {
                expectInitialState()
                runOnCreate()
                expectState { copy(isLoading = true) }
                containerHost.goToSelectedDogScreen()
                expectSideEffect(AllDogBreedsSideEffects.GoToSelectedDogSideEffect)
            })
    }

    @Test
    fun `dog list is updated`() = runTest {
        allDogBreedsViewModel.test(
            testScope = this,
            validate = {
                expectInitialState()
                runOnCreate()

                expectState { copy(isLoading = true) }

                val dummyData = listOf(DogItemModel(name = "Max"), DogItemModel(name = "Azorel"))

                containerHost.intent {
                    reduce {
                        state.copy(dogBreedModel = dummyData)
                    }
                }
                expectState {
                    copy(dogBreedModel = dummyData)
                }
            })
    }

    @Test
    fun `error state is updated`() = runTest {
        allDogBreedsViewModel.test(
            testScope = this,
            validate = {
                expectInitialState()
                runOnCreate()

                expectState { copy(isLoading = true) }

                containerHost.intent {
                    reduce {
                        state.copy(appException = AppException.UnknownException)
                    }
                }
                expectState { copy(appException = AppException.UnknownException) }
            }
        )
    }


    @Test
    fun `dismiss error state`() = runTest {
        allDogBreedsViewModel.test(
            this,
            validate = {
                expectInitialState()
                containerHost.intent {
                    reduce {
                        state.copy(appException = AppException.UnknownException, isLoading = false)
                    }
                }
                expectState {
                    copy(
                        appException = AppException.UnknownException,
                        isLoading = false
                    )
                }
                containerHost.dismissErrorDialog()

                expectState { copy(appException = null) }
            })
    }
}