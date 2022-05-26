package com.andrey.susie.Fragments.Home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrey.susie.BaseFragment
import com.andrey.susie.R
import com.andrey.susie.data.Music
import com.andrey.susie.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeUIEvent, HomeUIEffect>(R.layout.auth_fragment) {

    override val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()

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