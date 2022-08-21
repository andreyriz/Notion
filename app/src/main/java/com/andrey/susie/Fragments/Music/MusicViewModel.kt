package com.andrey.susie.Fragments.Music

import com.andrey.susie.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(): BaseViewModel<MusicUIEvent, MusicUIEffect>() {

    override fun handleEvent(event: MusicUIEvent) {

    }

}