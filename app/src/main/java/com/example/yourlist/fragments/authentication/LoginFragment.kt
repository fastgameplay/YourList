package com.example.yourlist.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yourlist.MainActivity
import com.example.yourlist.R
import com.example.yourlist.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)

        onClickListeners()

        return view
    }

    private fun onClickListeners(){
        binding.btnLogin.setOnClickListener{
//          TODO: sing in logic via firebase
            Toast.makeText(requireActivity(), "sing in logic is not implemented yet", Toast.LENGTH_SHORT).show()
        }
        binding.btnToRecovery.setOnClickListener{
            (activity as MainActivity).changeFragment(RecoveryFragment())
        }
        binding.btnToRegister.setOnClickListener{
            (activity as MainActivity).changeFragment(RegisterFragment())
        }
    }


}