package com.example.yourlist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yourlist.MainActivity
import com.example.yourlist.R
import com.example.yourlist.databinding.FragmentMainBinding
import com.example.yourlist.databinding.FragmentRecoveryBinding
import com.example.yourlist.fragments.authentication.LoginFragment
import com.google.firebase.auth.FirebaseAuth


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)

        binding.button.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            (activity as MainActivity).changeFragment(LoginFragment())
        }

        return view
    }


}