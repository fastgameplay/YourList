package com.example.yourlist.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.yourlist.MainActivity
import com.example.yourlist.R
import com.example.yourlist.Validate
import com.example.yourlist.databinding.FragmentRecoveryBinding
import com.example.yourlist.fragments.MainFragment
import com.google.firebase.auth.FirebaseAuth


class RecoveryFragment : Fragment() {

    private lateinit var binding: FragmentRecoveryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recovery, container, false)
        binding = FragmentRecoveryBinding.bind(view)

        onClickListeners()

        return view
    }

    private fun onClickListeners(){
        binding.btnSendRecovery.setOnClickListener{
            if (!Validate.email(binding.inputRecoveryField.text.toString())){
                binding.inputRecoveryHolder.error="Invalid Email"
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(binding.inputRecoveryField.text.toString())
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        Toast.makeText(requireContext(), "Recovery instructions sent successfully \n Please check your Email inbox", Toast.LENGTH_LONG).show()
                        (activity as MainActivity).changeFragment(LoginFragment())
                    } else {
                        binding.inputRecoveryHolder.error="Invalid Email"
                    }

                }
            Toast.makeText(requireActivity(), "Recovery logic is not implemented yet", Toast.LENGTH_SHORT).show()
        }
        binding.btnToLogin.setOnClickListener{
            (activity as MainActivity).changeFragment(LoginFragment())
        }
        binding.btnToRegister.setOnClickListener{
            (activity as MainActivity).changeFragment(RegisterFragment())
        }
    }

}