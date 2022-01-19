package com.example.yourlist.data


import com.google.gson.reflect.TypeToken
import com.google.gson.Gson

class Json {
    companion object{
        fun toObject(string: String?) : List<TodoList>{
            val typeToken = object : TypeToken<List<TodoList>>() {}.type
            return Gson().fromJson(string,typeToken)
        }
        fun toJson(persons : List<TodoList>) : String{
            return Gson().toJson(persons)
        }

    }
}
