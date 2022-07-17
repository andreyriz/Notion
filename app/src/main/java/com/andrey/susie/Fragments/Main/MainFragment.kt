package com.andrey.susie.Fragments.Main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrey.susie.BaseFragment
import com.andrey.susie.R
import com.andrey.susie.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainFragment : BaseFragment<MainUIEvent, MainUIEffect>(R.layout.main_fragment) {

    override val viewModel: MainViewModel by viewModels()
    private val binding: MainFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.topAppBar.setNavigationIcon(R.drawable.ic_back)

//        supportActionBar?.setDisplayHomeAsUpEnabled(false)
//        supportActionBar?.setHomeButtonEnabled(false)
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle favorite icon press
                    true
                }

//                R.id.share -> {
//                    // Handle favorite icon press
//                    true
//                }
                else -> false
            }
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Handle tab select
                Timber.e("${tab}")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
                Timber.e("${tab}")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
                Timber.e("${tab}")

            }
        })

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
//            false
//        }
//    }
}