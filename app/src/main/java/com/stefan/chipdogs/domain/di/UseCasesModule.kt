package com.stefan.chipdogs.domain.di

import com.stefan.chipdogs.domain.usecases.GetAllDogBreedsUseCase
import com.stefan.chipdogs.domain.usecases.GetAllDogBreedsUseCaseImpl
import com.stefan.chipdogs.domain.usecases.GetCurrentDogUseCase
import com.stefan.chipdogs.domain.usecases.GetCurrentDogUseCaseImpl
import com.stefan.chipdogs.domain.usecases.GetSelectedDogBreedUseCase
import com.stefan.chipdogs.domain.usecases.GetSelectedDogBreedUseCaseImpl
import com.stefan.chipdogs.domain.usecases.SelectDogBreedUseCase
import com.stefan.chipdogs.domain.usecases.SelectDogBreedUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesModule {


    @Binds
    @Singleton
    abstract fun bindsGetAllDogBreedsUseCase(getAllDogBreedsUseCaseImpl: GetAllDogBreedsUseCaseImpl): GetAllDogBreedsUseCase

    @Binds
    @Singleton
    abstract fun bindsSelectDogBreedUseCase(selectDogBreedUseCaseImpl: SelectDogBreedUseCaseImpl): SelectDogBreedUseCase

    @Binds
    @Singleton
    abstract fun bindsGetSelectedDogBreedUseCase(getSelectedDogBreedUseCaseImpl: GetSelectedDogBreedUseCaseImpl): GetSelectedDogBreedUseCase

    @Binds
    @Singleton
    abstract fun bindsGetCurrentDogUseCase(getCurrentDogUseCaseImpl: GetCurrentDogUseCaseImpl) : GetCurrentDogUseCase
}