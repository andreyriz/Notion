package com.andrey.Susie.Fragments.Home

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andrey.Susie.R
import com.andrey.Susie.databinding.HomeFragmentBinding
import com.andrey.notion.adapters.HomeRecyclerViewAdapter
import com.andrey.notion.data.Music
import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var binding: HomeFragmentBinding? = null

    private var homeAdapter: HomeRecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = HomeFragmentBinding.inflate(layoutInflater)
        return binding?.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recyclerView?.visibility = View.VISIBLE
        binding?.shimmerViewContainer?.visibility = View.GONE

        homeAdapter = HomeRecyclerViewAdapter(fillList())

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

        binding?.recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }


    private fun fillList(): List<Music> {
       return listOf(
           Music(0,"AAAAAA","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(1,"BBBBBB","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(2,"CCCCCC","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(3,"DDDDDD","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(4,"EEEEEE","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(5,"FFFFFF","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(6,"GGGGGG","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(7,"SSSSSS","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(8,"KKKKKK","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(9,"LLLLLL","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg",""),
           Music(10,"MMMMMM","https://musiclibrary-susie.herokuapp.com/static/musicimagesource/roket_monday.jpg","")
           )
    }

}