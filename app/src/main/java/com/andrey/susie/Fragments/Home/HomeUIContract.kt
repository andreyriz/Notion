package com.andrey.susie.Fragments.Home

import com.andrey.susie.UIEffect
import com.andrey.susie.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel

sealed class HomeUIEvent : UIEvent {
    class OnViewCreated() : HomeUIEvent()
}

sealed class HomeUIEffect : UIEffect {

}