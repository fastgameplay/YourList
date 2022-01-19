package com.example.yourlist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.yourlist.data.DataHolder
import com.example.yourlist.data.Json
import com.example.yourlist.fragments.MainFragment
import com.example.yourlist.fragments.authentication.LoginFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class MainActivity : AppCompatActivity() {

    private val aut = FirebaseAuth.getInstance()
    private val db: DatabaseReference = FirebaseDatabase.getInstance().getReference("DataBase")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        downloadAndStart()
        setContentView(R.layout.activity_main)



    }

    fun UploadData(){
        db.child(aut.currentUser?.uid!!).setValue(Json.toJson(DataHolder.Todos))

    }

    fun downloadAndStart(){
        db.child(aut.currentUser?.uid!!).addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue<String>()
                DataHolder.setData( (Json.toObject(value)).toMutableList() )
                changeFragment(LoginFragment())

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(baseContext,"failed to download data", Toast.LENGTH_SHORT).show()
            }

        })

    }
    override fun onStop() {
        db.child(aut.currentUser?.uid!!).setValue(Json.toJson(DataHolder.Todos))
        super.onStop()


    }
    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }
    }

}