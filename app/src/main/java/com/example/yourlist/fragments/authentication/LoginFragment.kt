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
import com.example.yourlist.databinding.FragmentLoginBinding
import com.example.yourlist.fragments.MainFragment
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //isAuthorised check
        if (FirebaseAuth.getInstance().currentUser != null) (activity as MainActivity).changeFragment(MainFragment())

    }
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
            if(!Validate.email(binding.inputLoginField.text.toString())){
                binding.inputLoginHolder.error = "Invalid Email address"
                return@setOnClickListener
            }
            //Sign In
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(binding.inputLoginField.text.toString(),binding.inputPasswordField.text.toString())
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        (activity as MainActivity).changeFragment(MainFragment())
                    }else{
                        Toast.makeText(requireContext(), "Incorrect Email or Password", Toast.LENGTH_SHORT).show()
                        binding.inputPasswordHolder.error = "Invalid Password"
                    }
                }

        }
        binding.btnToRecovery.setOnClickListener{
            (activity as MainActivity).changeFragment(RecoveryFragment())
        }
        binding.btnToRegister.setOnClickListener{
            (activity as MainActivity).changeFragment(RegisterFragment())
        }
    }


}