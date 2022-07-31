package com.andrey.susie.Fragments.Home

import androidx.lifecycle.viewModelScope
import com.andrey.susie.BaseViewModel
import com.andrey.susie.Fragments.Home.HomeUIEffect
import com.andrey.susie.Fragments.Home.HomeUIEvent
import com.andrey.susie.api.auth.AuthServiceRepository
import com.andrey.susie.api.auth.music.MusicServiceRepository
import com.andrey.susie.data.AccountRequest
import com.andrey.susie.data.AccountResponse
import com.andrey.susie.data.Music
import com.andrey.susie.data.MusicRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authServiceRepository: MusicServiceRepository
) : BaseViewModel<HomeUIEvent, HomeUIEffect>() {

    private val _musicResponse = MutableSharedFlow<ArrayList<Music>?>()

    val musicResponse: SharedFlow<ArrayList<Music>?> get() = _musicResponse

    override fun handleEvent(event: HomeUIEvent) {
        when (event) {
                is HomeUIEvent.OnViewCreated -> getMusics()
        }
    }


    private fun getMusics() {
        viewModelScope.launch {
            authServiceRepository.getMusic(
                MusicRequest(0)
            ).collect {
                _musicResponse.emit(it)
            }

        }
    }
}