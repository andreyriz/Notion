package com.andrey.susie.Fragments.Auth

import com.andrey.susie.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    //private val authServiceRepository: AuthServiceRepository
    )
    : BaseViewModel<AuthUIEvent, AuthUIEffect>() {

//    private val _accountResponse = MutableSharedFlow<AccountResponse?>()
//
//    val accountResponse:SharedFlow<AccountResponse?> get() = _accountResponse//.asStateFlow()
//
//    fun tryToAuth(username:String?, pass:String?, email:String?) {
//        viewModelScope.launch {
//            authServiceRepository.authUser(
//                AccountRequest(
//                    username,
//                    pass,
//                    email
//                    //"andrey",
//                    //"29091998",
//                    //"andreyriz2909@gmail.com"
//                )
//            ).collect{
//                _accountResponse.emit(it)
//            }
//
//        }
//    }

    override fun handleEvent(event: AuthUIEvent) {

    }
}