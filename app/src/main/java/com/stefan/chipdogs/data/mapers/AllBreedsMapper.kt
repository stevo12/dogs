package com.stefan.chipdogs.data.mapers

import com.stefan.chipdogs.data.models.AllBreedsModel
import com.stefan.chipdogs.data.api.responses.AllBreedsDto

interface AllBreedsMapper {

    fun mapFromResponseToDomain(allBreedsDto: AllBreedsDto): AllBreedsModel
}