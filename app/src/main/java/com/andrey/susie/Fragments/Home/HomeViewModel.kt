package com.andrey.susie.Fragments.Home

import com.andrey.susie.BaseViewModel
import com.andrey.susie.Fragments.Home.HomeUIEffect
import com.andrey.susie.Fragments.Home.HomeUIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): BaseViewModel<HomeUIEvent, HomeUIEffect>() {

    override fun handleEvent(event: HomeUIEvent) {
        TODO("Not yet implemented")
    }

}