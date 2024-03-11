package com.stefan.chipdogs.data.networking

import com.stefan.chipdogs.data.models.Resource

interface ApiRequestHandler {
    suspend fun <T : Any, R> handleRequest(
        apiCall: suspend () -> T,
        successMapper: (T) -> R
    ): Resource<R>
}