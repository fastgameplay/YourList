package com.example.yourlist.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.yourlist.MainActivity
import com.example.yourlist.R
import com.example.yourlist.data.DataHolder
import com.example.yourlist.data.Validate
import com.example.yourlist.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.bind(view)

        onTextChangeListeners()
        onClickListeners()

        return view
    }

    private fun onClickListeners(){

        binding.btnRegister.setOnClickListener(){
            //region input checker
            if(!Validate.email(binding.inputMailField.text.toString())
                || !Validate.password(binding.inputPasswordField.text.toString())
                || !Validate.username(binding.inputUsernameField.text.toString())
                || binding.inputPasswordField.text.toString() != binding.inputCPasswordField.text.toString() ){
                return@setOnClickListener
            }
            //endregion

            //region Registration
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(binding.inputMailField.text.toString(),binding.inputPasswordField.text.toString())
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        DataHolder.mainActivity.changeFragment(LoginFragment())
                    } else {
                        binding.inputMailHolder.error = "This Email address already registered"
                        Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
                    }
                }
            //endregion
        }


        binding.btnToLogin.setOnClickListener{
            DataHolder.mainActivity.changeFragment(LoginFragment())
        }
    }
    private fun onTextChangeListeners() {
        //region Email
        binding.inputMailField.doOnTextChanged { text, _, _, _ ->
            if (Validate.email(text.toString())) {
                binding.inputMailHolder.error = null
            } else binding.inputMailHolder.error = "Not Valid Email"
        }
        //endregion

        //region Username
        binding.inputUsernameField.doOnTextChanged() { text, _, _, _ ->
            if (!Validate.username(text.toString())) binding.inputUsernameHolder.error =
                "Max Character Limit"
            else binding.inputUsernameHolder.error = null
        }
        //endregion

        //region password
        binding.inputPasswordField.doOnTextChanged { text, _, _, _ ->
            var passErrorText = ""
            if (text.toString().length < 9) {
                passErrorText = "At least 9 characters \n"
            }
            // Validate.password(input : String, id:Int) {0 : [a-z]; 1 : [A-Z]; 2: [0-9]; 3:[\W] }
            if (!Validate.password(text.toString(), 0)) {
                passErrorText += "At least one lowercase character \n"
            }
            if (!Validate.password(text.toString(), 1)) {
                passErrorText += "At least one uppercase character \n"
            }
            if (!Validate.password(text.toString(), 2)) {
                passErrorText += "At least one numeric character \n"
            }
            if (!Validate.password(text.toString(), 3)) {
                passErrorText += "At least one special character \n"
            }

            binding.inputPasswordHolder.error = passErrorText
        }
        //endregion

        //region confirm password
        binding.inputCPasswordField.doOnTextChanged { text, _, _, _ ->
            if (text.toString() != binding.inputPasswordField.text.toString()) {
                binding.inputCPasswordHolder.error = "Password did not match"
            } else binding.inputCPasswordHolder.error = null
        }
        //endregion
    }

}


