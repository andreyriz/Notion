package com.andrey.susie.Fragments.Auth

import com.andrey.susie.UIEffect
import com.andrey.susie.UIEvent

sealed class AuthUIEvent : UIEvent {
    class OnLogin(val username:String?, val  pass:String?, val  email:String?) : AuthUIEvent()
}

sealed class AuthUIEffect : UIEffect {

}