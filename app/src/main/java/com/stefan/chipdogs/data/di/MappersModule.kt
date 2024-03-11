package com.stefan.chipdogs.data.di

import com.stefan.chipdogs.data.mapers.AllBreedsMapper
import com.stefan.chipdogs.data.mapers.AllBreedsMapperImpl
import com.stefan.chipdogs.data.mapers.SelectedDogMapper
import com.stefan.chipdogs.data.mapers.SelectedDogMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    @Singleton
    abstract fun bindsAllBreedsMapper(allBreedsMapperImpl: AllBreedsMapperImpl): AllBreedsMapper

    @Binds
    @Singleton
    abstract fun bindsSelectedDogMapper(selectedDogMapperImpl: SelectedDogMapperImpl): SelectedDogMapper
}