package com.andrey.susie.Fragments.Auth

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrey.susie.R
import com.andrey.susie.databinding.AuthFragmentBinding
import com.andrey.susie.BaseFragment
import com.andrey.susie.Fragments.Auth.AuthUIEffect
import com.andrey.susie.Fragments.Auth.AuthUIEvent
import com.andrey.susie.Fragments.Auth.AuthViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AuthFragment : BaseFragment<AuthUIEvent, AuthUIEffect>(R.layout.auth_fragment) {

    override val viewModel: AuthViewModel by viewModels()
    private val binding: AuthFragmentBinding by viewBinding()
    private lateinit var snackbar:Snackbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.auth.setOnClickListener {
            viewModel.addEvent(AuthUIEvent.OnLogin("","",""))
        }
    }

    override fun startSubscription() {
        super.startSubscription()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.accountResponse.collect {
                it?.let {
                    Timber.d(it.info)

                    if (it.info.contains("Confirm")) {
                        findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToMainFragment())
                    } else {
                        showError(it.info)
                    }
                }
            }
        }
    }

    private fun showError(error:String) {
        snackbar = Snackbar.make(binding.root,
//                            it.info,
            getString(R.string.error_text),
            Snackbar.LENGTH_LONG)

        snackbar.duration = 3000

        snackbar.view.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        (snackbar.view.layoutParams as FrameLayout.LayoutParams).gravity =
            Gravity.TOP
        snackbar.view.background = ContextCompat.getDrawable(
            requireContext().applicationContext,
            R.drawable.error_snackbar
        )

        (snackbar.view.findViewById(R.id.snackbar_text) as TextView).let { tv ->
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            tv.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            tv.gravity = Gravity.TOP
        }


        snackbar.show()
    }

    override fun handleEffect(effect: AuthUIEffect) {
        super.handleEffect(effect)
        when(effect){

        }
    }
}