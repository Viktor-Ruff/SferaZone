package com.example.sferazone1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var userRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList: List<User> = listOf(
            User("Ivan"),
            User("Svetlana"),
            User("Andrey"),
            User("Andre"),
        )

        userRecyclerView = findViewById(R.id.user_image_recycler)
        userRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        userRecyclerView.adapter = UserAdapter(userList)
    }
}