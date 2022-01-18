package com.example.yourlist.data

import android.content.Context
import java.io.*

class File {
    companion object{

        fun writeFile(context: Context, string: String, fileName: String){
            val file = File(context.filesDir, fileName)
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(string)
            bufferedWriter.close()
        }

        fun readFile(context: Context, fileName: String): String{
            val file = File(context.filesDir,fileName)
            val bufferedReader = BufferedReader(FileReader(file))
            val stringBuilder = StringBuilder()
            var line = bufferedReader.readLine()
            while(line != null){
                stringBuilder.append(line)
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            return  stringBuilder.toString()
        }
    }
}
