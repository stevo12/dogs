package com.stefan.chipdogs.data.mapers

import com.stefan.chipdogs.data.models.SelectedDogBreedModel
import com.stefan.chipdogs.data.api.responses.SelectedDogBreedRandomImagesDto
import javax.inject.Inject

class SelectedDogMapperImpl @Inject constructor(

): SelectedDogMapper {
    override fun mapFromResponseToDomain(selectedDogBreedRandomImagesDto: SelectedDogBreedRandomImagesDto): SelectedDogBreedModel =
        SelectedDogBreedModel(
            images = selectedDogBreedRandomImagesDto.message ?: emptyList(),
            status = selectedDogBreedRandomImagesDto.status ?: ""
        )
}