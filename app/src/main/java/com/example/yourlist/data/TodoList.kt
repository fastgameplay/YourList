package com.example.yourlist.data

data class TodoList(var name: String,val todoList : List<Todo>)
data class Todo(var text: String, var isDone: Boolean)
data class PackedData(var id:String,var jsonString: String)
