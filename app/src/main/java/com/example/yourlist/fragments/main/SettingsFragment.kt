package com.example.yourlist.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yourlist.R
import com.example.yourlist.data.DataHolder
import com.example.yourlist.databinding.FragmentSettingsBinding
import com.example.yourlist.fragments.authentication.LoginFragment
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment : Fragment() {
    private lateinit var binding : FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    fun OnClickListeners() {
        binding.btnLogout.setOnClickListener {
            binding.button.setOnClickListener {
                FirebaseAuth.getInstance().signOut()
                DataHolder.mainActivity.changeFragment(LoginFragment())
            }

        }


    }
}