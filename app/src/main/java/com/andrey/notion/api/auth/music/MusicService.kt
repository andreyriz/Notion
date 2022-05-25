package com.andrey.notion.api.auth.music

import com.andrey.notion.api.auth.AuthService
import com.andrey.notion.data.AccountRequest
import com.andrey.notion.data.AccountResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject


interface MusicService {

    @POST("GetMusic")
    suspend fun getMusic(@Body userData: AccountRequest): AccountResponse

}

class MusicServiceRepository @Inject constructor
    (
    private val api: MusicService
){

    suspend fun authUser(userData: AccountRequest): Flow<AccountResponse> {
        return flow {
            emit(api.getMusic(userData))
        }.flowOn(Dispatchers.IO)
    }
}