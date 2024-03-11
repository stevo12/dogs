package com.stefan.chipdogs.data.models

import retrofit2.HttpException

sealed class AppException(open val causedByException: Exception) : Exception(causedByException) {

    object NoServiceException : AppException(causedByException = Exception("No service"))

    object UnknownException : AppException(causedByException = Exception("Unknown Exception"))

    sealed class RemoteException(override val causedByException: Exception) :
        AppException(causedByException = Exception(causedByException)) {

        class ApiRemoteException(
            override val causedByException: HttpException,
            val errorMessage: String
        ) : RemoteException(causedByException)
    }
}