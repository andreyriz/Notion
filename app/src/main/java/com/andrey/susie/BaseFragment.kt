package com.andrey.susie

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<Event : UIEvent, Effect : UIEffect>(
    @LayoutRes layoutRes: Int
) : Fragment(layoutRes) {

    abstract val viewModel: BaseViewModel<Event, Effect>

    protected open fun handleEffect(effect: Effect) = Unit

    protected open fun onBackPressed(): Boolean = false

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!onBackPressed()) {
                isEnabled = false
                activity?.onBackPressed()
            }else{
                findNavController().popBackStack()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, onBackPressedCallback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startSubscription()
    }

    override fun onStart() {
        super.onStart()
    }

    @CallSuper
    protected open fun startSubscription() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.effect.collect(::handleEffect)
        }
    }
}