package com.andrey.susie.Fragments.Main

import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

//    private var binding: MainFragmentBinding? = null
//    private lateinit var viewModel: MainViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        binding = MainFragmentBinding.inflate(layoutInflater)
//        return binding?.root;
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        binding?.topAppBar?.setNavigationIcon(R.drawable.ic_back)
////
////        supportActionBar?.setDisplayHomeAsUpEnabled(false)
////        supportActionBar?.setHomeButtonEnabled(false)
//
////        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
//
//        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.search -> {
//                    // Handle favorite icon press
//                    true
//                }
//
////                R.id.share -> {
////                    // Handle favorite icon press
////                    true
////                }
//                else -> false
//            }
//        }
//
//        binding?.tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                // Handle tab select
//                Timber.e("${tab}")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                // Handle tab reselect
//                Timber.e("${tab}")
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                // Handle tab unselect
//                Timber.e("${tab}")
//
//            }
//        })
//
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
//            false
//        }
//    }
}