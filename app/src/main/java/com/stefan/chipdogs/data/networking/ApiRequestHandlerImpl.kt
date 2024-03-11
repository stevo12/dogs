package com.stefan.chipdogs.data.networking

import com.squareup.moshi.JsonDataException
import com.stefan.chipdogs.data.models.AppException
import com.stefan.chipdogs.data.models.Resource
import retrofit2.HttpException
import java.lang.Exception
import java.net.SocketTimeoutException
import javax.inject.Inject

class ApiRequestHandlerImpl @Inject constructor() : ApiRequestHandler {
    override suspend fun <T : Any, R> handleRequest(
        apiCall: suspend () -> T,
        successMapper: (T) -> R
    ): Resource<R> {
        return try {
            val response = apiCall.invoke()
            Resource.Success(data = successMapper(response))
        } catch (timeoutException: SocketTimeoutException) {
            Resource.Error(failure = AppException.NoServiceException)
        } catch (jsonDataException: JsonDataException) {
            Resource.Error(failure = AppException.UnknownException)
        } catch (httpException: HttpException) {
            Resource.Error(
                failure = AppException.RemoteException.ApiRemoteException(
                    httpException,
                    httpException.message.toString()
                )
            )
        }
        catch (e: Exception) {
            Resource.Error(failure = AppException.UnknownException)
        }
    }
}