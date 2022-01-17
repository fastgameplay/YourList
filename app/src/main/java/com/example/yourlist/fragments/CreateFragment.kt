package com.example.yourlist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.TextView
import com.example.yourlist.R
import com.example.yourlist.databinding.FragmentCreateBinding
import android.app.Activity
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import com.example.yourlist.MainActivity
import com.example.yourlist.fragments.data.Todo
import java.security.Key


class CreateFragment : Fragment() {
    private lateinit var binding : FragmentCreateBinding
    var list : MutableList<Todo> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_create, container, false)
        binding = FragmentCreateBinding.bind(view)


        listeners()
        return view
    }

    fun listeners(){
        binding.inputTaskField.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->

            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {

                binding.inputTaskField.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        binding.inputTaskField.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->

            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                list.add(Todo(binding.inputTaskField.text.toString(),false))
                var tempText = ""
                for(i in 0..list.count()-1){tempText += "${i})" + list[i].text + "\n"}
                binding.inputTaskField.text?.clear()
                binding.TodoHolder.text = tempText

                return@OnKeyListener true
            }
            false
        })
    }

}