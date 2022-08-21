package com.andrey.susie.Fragments.Music

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.andrey.susie.BaseFragment
import com.andrey.susie.R
import com.andrey.susie.databinding.MusicFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MusicFragment : BaseFragment<MusicUIEvent, MusicUIEffect>(R.layout.music_fragment) {

    override val viewModel: MusicViewModel by viewModels()
    override fun onBackPressed() = true

    private val binding: MusicFragmentBinding by viewBinding()
    private val args by navArgs<MusicFragmentArgs>()

    private val music by lazy { args.music }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d(music.toString())
    }

}