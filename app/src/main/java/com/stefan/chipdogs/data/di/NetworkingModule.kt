package com.stefan.chipdogs.data.di

import com.stefan.chipdogs.data.networking.ApiRequestHandler
import com.stefan.chipdogs.data.networking.ApiRequestHandlerImpl
import com.stefan.chipdogs.data.services.DogBreedsService
import com.stefan.chipdogs.data.services.DogBreedsServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkingModule {

    @Binds
    @Singleton
    abstract fun bindsApiRequestHandler(apiRequestHandlerImpl: ApiRequestHandlerImpl): ApiRequestHandler

    @Binds
    @Singleton
    abstract fun bindsDogBreedsService(dogBreedsServiceImpl: DogBreedsServiceImpl): DogBreedsService
}