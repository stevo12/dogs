package com.stefan.chipdogs.domain.usecases

import com.stefan.chipdogs.data.models.AllBreedsModel
import com.stefan.chipdogs.data.models.AppException

interface GetAllDogBreedsUseCase {

   suspend operator fun invoke(
       onError: suspend (AppException) -> Unit,
       onSuccess: (AllBreedsModel) -> Unit
   )
}