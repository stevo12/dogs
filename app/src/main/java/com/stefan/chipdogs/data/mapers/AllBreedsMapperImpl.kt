package com.stefan.chipdogs.data.mapers

import com.stefan.chipdogs.data.models.AllBreedsModel
import com.stefan.chipdogs.data.api.responses.AllBreedsDto
import javax.inject.Inject

class AllBreedsMapperImpl @Inject constructor(): AllBreedsMapper {
    override fun mapFromResponseToDomain(allBreedsDto: AllBreedsDto): AllBreedsModel =
        AllBreedsModel(
            message = allBreedsDto.message,
            status = allBreedsDto.status ?: ""
        )
}