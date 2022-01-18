package com.example.yourlist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yourlist.R
import com.example.yourlist.databinding.FragmentMainBinding
import com.example.yourlist.fragments.main.CreateFragment
import com.example.yourlist.fragments.main.ListFragment
import com.example.yourlist.fragments.main.SettingsFragment


class MainFragment : Fragment() {



    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)


        changeFragment(ListFragment())
        listeners()
//        binding.button.setOnClickListener{
//            FirebaseAuth.getInstance().signOut()
//            DataHolder.mainActivity.changeFragment(LoginFragment())
//        }

        return view
    }


    private fun listeners(){
        binding.bottomNavigation.setOnItemSelectedListener  {
            when(it.itemId){
                R.id.nav_create -> {
//                    DataHolder.updateDB()
                    changeFragment(CreateFragment())
                    true
                }
                R.id.nav_main -> {
//                    DataHolder.uploadDB()
                    changeFragment(ListFragment())
                    true
                }
                R.id.nav_settings -> {
                    changeFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment){
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.content_holder,fragment)
            commit()
        }
    }
}