package com.example.yourlist.fragments.main

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.yourlist.MainActivity
import com.example.yourlist.R
import com.example.yourlist.data.Validate
import com.example.yourlist.databinding.FragmentCreateBinding
import com.example.yourlist.data.DataHolder
import com.example.yourlist.data.Todo
import com.example.yourlist.data.TodoList
import com.example.yourlist.fragments.MainFragment


class CreateFragment : Fragment() {
    private lateinit var binding : FragmentCreateBinding
    private var list : MutableList<Todo> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_create, container, false)
        binding = FragmentCreateBinding.bind(view)


        listeners()
        return view
    }

    private fun listeners(){
        binding.inputTaskField.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->

            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                hideSoftKeyboard((activity as MainActivity))
                return@OnKeyListener true
            }
            false
        })

        binding.inputTaskField.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->

            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                list.add(Todo(binding.inputTaskField.text.toString(),false))
                var tempText = ""
                for(i in 0 until list.count()){tempText += "${i+1})" + list[i].text + "\n"}
                binding.inputTaskField.text?.clear()
                binding.TodoHolder.text = tempText

                return@OnKeyListener true
            }
            false
        })

        binding.inputNameField.doOnTextChanged { text, _, _, _ ->
            when {
                text.toString().length < 4 -> binding.inputNameHolder.error = "Minimum 4 characters"
                text.toString().length > 20 -> binding.inputNameHolder.error = "Maximum 20 characters"
                else -> binding.inputNameHolder.error = ""
            }
        }

        binding.btnSubmit.setOnClickListener{
            if(Validate.listName(binding.inputNameField.text.toString())){
                if(list.count() > 0) {
                    DataHolder.addToData(TodoList(binding.inputNameField.text.toString(),list))
                    DataHolder.mainActivity.changeFragment(MainFragment())
                }
            }
        }
    }
    private fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        if (inputMethodManager.isAcceptingText) {
            inputMethodManager.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken,
                0
            )
        }
    }

}