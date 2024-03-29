package com.andrey.susie.Fragments.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrey.susie.BaseFragment
import com.andrey.susie.R
import com.andrey.susie.adapters.HomeRecyclerViewAdapter
import com.andrey.susie.data.Music
import com.andrey.susie.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeUIEvent, HomeUIEffect>(R.layout.home_fragment) {

    override val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()

    private var homeAdapter: HomeRecyclerViewAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter?.addLoadStateListener { loadState ->

            if (loadState.refresh is LoadState.Loading) {
                //progressBar.visibility = View.VISIBLE
            } else {
                //progressBar.visibility = View.GONE

                // getting the error
                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
//                errorState?.let {
//                    Toast.makeText(this, it.error.message, Toast.LENGTH_LONG).show()
//                }
            }
        }

        viewModel.addEvent(HomeUIEvent.OnViewCreated())
    }

    override fun startSubscription() {
        super.startSubscription()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.musicResponse.collect {
                it?.let {
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.shimmerViewContainer.visibility = View.GONE
                    Timber.d(it.size.toString())
                    homeAdapter = HomeRecyclerViewAdapter(it){
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMusicFragment(it))
                    }
                    binding.recyclerView.apply {
                        layoutManager = GridLayoutManager(context, 3)
                        setHasFixedSize(true)
                        adapter = homeAdapter
                    }
                }
            }
        }
    }

}