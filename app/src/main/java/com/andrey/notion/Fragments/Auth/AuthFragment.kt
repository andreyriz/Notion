package com.andrey.notion.Fragments.Auth

import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andrey.Susie.R
import com.andrey.Susie.databinding.AuthFragmentBinding
import com.andrey.notion.dagger.getAppComponent
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

class AuthFragment : Fragment() {

    private var binding: AuthFragmentBinding? = null

    val viewModel: AuthViewModel by viewModels {
        getAppComponent().viewModelsFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AuthFragmentBinding.inflate(layoutInflater)

        binding?.auth?.setOnClickListener {
            viewModel.tryToAuth(
                null,
                binding?.pass?.text?.toString(),
                binding?.email?.text?.toString()
            )
        }

        lifecycleScope.launchWhenStarted {
            viewModel.accountResponse.collect {
                it?.let {
                    Timber.d(it.info)

                    if (it.info.contains("Confirm")){
                        findNavController().navigate(R.id.action_authFragment_to_mainFragment)
                    }else{
                        val snackbar = Snackbar.make(binding!!.root, it.info, Snackbar.LENGTH_LONG)

                        snackbar.setDuration()

                        snackbar.view.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
                        (snackbar.view.layoutParams as FrameLayout.LayoutParams).gravity = Gravity.TOP
                        snackbar.view.background = ContextCompat.getDrawable(requireContext().applicationContext, R.drawable.error_snackbar)

                        (snackbar.view.findViewById(R.id.snackbar_text) as TextView).let{tv ->
                            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                            tv.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
                            tv.gravity = Gravity.TOP
                        }


                        snackbar.show()
                    }
                }

            }
        }
        return binding?.root;
    }
}