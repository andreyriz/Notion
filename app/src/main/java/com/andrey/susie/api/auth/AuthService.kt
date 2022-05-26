package com.andrey.susie.api.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

//interface AuthService {
//
//    @POST("Auth")
//    suspend fun authUser(@Body userData: AccountRequest): AccountResponse
//
//}
//
//class AuthServiceRepository @Inject constructor
//    (
//    private val api: AuthService
//    )
//{
//
//    suspend fun authUser(userData: AccountRequest): Flow<AccountResponse> {
//        return flow {
//            emit(api.authUser(userData))
//        }.flowOn(Dispatchers.IO)
//    }
//
//}

