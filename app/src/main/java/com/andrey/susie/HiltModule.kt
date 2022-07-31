package com.andrey.susie

import com.andrey.susie.api.auth.AuthService
import com.andrey.susie.api.auth.AuthServiceRepository
import com.andrey.susie.api.auth.music.MusicService
import com.andrey.susie.api.auth.music.MusicServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://musiclibrary-susie.herokuapp.com/")
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideAuthService(retrofit : Retrofit) : AuthService = retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun provideAuthServiceRemoteData(authService : AuthService) : AuthServiceRepository = AuthServiceRepository(authService)


    @Provides
    @Singleton
    fun provideMusicService(retrofit:Retrofit):MusicService = retrofit.create(MusicService::class.java)

    @Provides
    @Singleton
    fun provideMusicServiceRemoteData(musicService:MusicService) : MusicServiceRepository = MusicServiceRepository(musicService)
}