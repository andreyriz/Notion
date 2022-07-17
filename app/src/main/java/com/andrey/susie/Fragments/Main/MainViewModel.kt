package com.andrey.susie.Fragments.Main

import com.andrey.susie.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainUIEvent, MainUIEffect>() {
    // TODO: Implement the ViewModel

    override fun handleEvent(event: MainUIEvent) {
        TODO("Not yet implemented")
    }
}