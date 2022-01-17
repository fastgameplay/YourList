package com.example.yourlist.fragments.data

object DataHolder {
    private var todos : MutableList<TodoList> = mutableListOf()
    var Todos: MutableList<TodoList> = todos
        get() = todos
    //todo check version according to server last version
    private var version:String = "0"



    fun checkVersion(_version: String):Boolean = version == _version

    fun updateData(_persons: MutableList<TodoList>, _version: String){
        todos = _persons
        version = _version
    }

    fun amount() : Int = todos.count()
}