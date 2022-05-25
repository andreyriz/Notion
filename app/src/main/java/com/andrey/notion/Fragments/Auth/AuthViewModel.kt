package com.andrey.notion.Fragments.Auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.andrey.notion.api.auth.AuthServiceRepository
import com.andrey.notion.api.auth.music.MusicServiceRepository
import com.andrey.notion.data.AccountRequest
import com.andrey.notion.data.AccountResponse
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val authServiceRepository: AuthServiceRepository
    )
    : ViewModel() {

    private val _accountResponse = MutableSharedFlow<AccountResponse?>()

    val accountResponse:SharedFlow<AccountResponse?> get() = _accountResponse//.asStateFlow()

    fun tryToAuth(username:String?, pass:String?, email:String?) {
        viewModelScope.launch {
            authServiceRepository.authUser(
                AccountRequest(
                    username,
                    pass,
                    email
                    //"andrey",
                    //"29091998",
                    //"andreyriz2909@gmail.com"
                )
            ).collect{
                _accountResponse.emit(it)
            }

        }
    }
}