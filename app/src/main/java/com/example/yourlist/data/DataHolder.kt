package com.example.yourlist.data

import com.example.yourlist.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object DataHolder {
    var mainActivity: MainActivity = MainActivity()

    private var todos : MutableList<TodoList> = mutableListOf()
    var Todos: MutableList<TodoList> = mutableListOf()
        get() = todos

    private var position : Int = 0
    var Position : Int
        get() = position
        set(value) {position = value}
//    check version according to server last version
//    private var version:String = "0"



//    fun checkVersion(_version: String):Boolean = version == _version
//    fun updateDB(){
//
//    }
    fun setData(list : MutableList<TodoList>){
        todos = list
    }
    fun addToData(todoList: TodoList ){
        todos.add(todoList)
    }

    fun amount() : Int = todos.count()
}