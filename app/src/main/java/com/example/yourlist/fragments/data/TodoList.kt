package com.example.yourlist.fragments.data

data class TodoList(var name: String,val todoList : List<Todo>)
data class Todo(var text: String, var isDone: Boolean)
