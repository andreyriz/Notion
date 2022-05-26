package com.andrey.susie.Fragments.Auth

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrey.susie.R
import com.andrey.susie.databinding.AuthFragmentBinding
import com.andrey.susie.BaseFragment
import com.andrey.susie.Fragments.Auth.AuthUIEffect
import com.andrey.susie.Fragments.Auth.AuthUIEvent
import com.andrey.susie.Fragments.Auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : BaseFragment<AuthUIEvent, AuthUIEffect>(R.layout.auth_fragment) {

    override val viewModel: AuthViewModel by viewModels()
    private val binding: AuthFragmentBinding by viewBinding()
}