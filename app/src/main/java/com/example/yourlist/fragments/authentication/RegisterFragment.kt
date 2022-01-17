package com.example.yourlist.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yourlist.MainActivity
import com.example.yourlist.R
import com.example.yourlist.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.bind(view)

        onClickListeners()

        return view
    }

    private fun onClickListeners(){
        binding.btnRegister.setOnClickListener{
//          TODO: Register via firebase
            Toast.makeText(requireActivity(), "Register logic is not implemented yet", Toast.LENGTH_SHORT).show()
        }
        binding.btnToLogin.setOnClickListener{
            (activity as MainActivity).changeFragment(LoginFragment())
        }
    }


}