package com.example.yourlist.data

import com.example.yourlist.MainActivity

object DataHolder {
    var mainActivity: MainActivity = MainActivity()
    private var todos : MutableList<TodoList> = mutableListOf()
    val Todos: MutableList<TodoList>
        get() = todos

    private var position : Int = 0
    var Position : Int
        get() = position
        set(value) {
            position = value
        }
//    check version according to server last version
//    private var version:String = "0"



//    fun checkVersion(_version: String):Boolean = version == _version

    fun addToData(todoList: TodoList ){
        todos.add(todoList)
    }

    fun amount() : Int = todos.count()
}