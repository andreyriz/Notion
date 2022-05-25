package com.andrey.Susie

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.andrey.Susie.databinding.ActivityMainBinding
import com.andrey.notion.Fragments.Auth.AuthFragment
import com.andrey.notion.Fragments.Main.MainViewModel
import com.google.android.material.tabs.TabLayout
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)

        //navController = Navigation.findNavController(this, R.id.nav_host_fragment1)
        //navController?.navigate(R.id.authFragment)
        //Timber.d("111")


    }

    override fun onStart() {
        super.onStart()
        //navController = Navigation.findNavController(this, R.id.nav_host_fragment1)
        //navController?.navigate(R.id.authFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}