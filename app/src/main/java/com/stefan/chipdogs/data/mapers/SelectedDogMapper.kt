package com.stefan.chipdogs.data.mapers

import com.stefan.chipdogs.data.models.SelectedDogBreedModel
import com.stefan.chipdogs.data.api.responses.SelectedDogBreedRandomImagesDto

interface SelectedDogMapper {

    fun mapFromResponseToDomain(selectedDogBreedRandomImagesDto: SelectedDogBreedRandomImagesDto): SelectedDogBreedModel
}