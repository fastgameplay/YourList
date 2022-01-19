package com.example.yourlist.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yourlist.MainActivity
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
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.bind(view)
        OnClickListeners()
        return view
    }

    fun OnClickListeners() {
        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            DataHolder.mainActivity.changeFragment(LoginFragment())


        }
        binding.btnUpload.setOnClickListener(){
            (activity as MainActivity).UploadData()
            Toast.makeText(requireContext(), "Uploaded", Toast.LENGTH_SHORT).show()
        }

        binding.btnDownload.setOnClickListener(){
//            (activity as MainActivity).downloadData()
        }

    }
}