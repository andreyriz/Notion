package com.andrey.susie.Fragments.Auth

import androidx.lifecycle.viewModelScope
import com.andrey.susie.BaseViewModel
import com.andrey.susie.api.auth.AuthServiceRepository
import com.andrey.susie.data.AccountRequest
import com.andrey.susie.data.AccountResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authServiceRepository: AuthServiceRepository
    )
    : BaseViewModel<AuthUIEvent, AuthUIEffect>() {

    private val _accountResponse = MutableSharedFlow<AccountResponse?>()

    val accountResponse: SharedFlow<AccountResponse?> get() = _accountResponse//.asStateFlow()

    private fun tryToAuth(username:String?, pass:String?, email:String?) {
        viewModelScope.launch {
            authServiceRepository.authUser(
                AccountRequest(
//                    username,
//                    pass,
//                    email
                    "andrey",
                    "29091998",
                    "andreyriz2909@gmail.com"
                )
            ).collect{
                _accountResponse.emit(it)
            }

        }
    }

    override fun handleEvent(event: AuthUIEvent) {
        when (event) {
            is AuthUIEvent.OnLogin -> tryToAuth(event.username, event.pass, event.email)
        }
    }
}