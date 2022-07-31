package com.andrey.susie.api.auth.music

import com.andrey.susie.data.Music
import com.andrey.susie.data.MusicRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

interface MusicService {

    @POST("GetMusic")
    suspend fun getMusic(@Body userData: MusicRequest): ArrayList<Music>
}

class MusicServiceRepository @Inject constructor
    (
    private val api: MusicService
)
{

    suspend fun getMusic(userData: MusicRequest): Flow<ArrayList<Music>> {
        return flow {
            emit(api.getMusic(userData))
        }.flowOn(Dispatchers.IO)
    }

}