package com.example.sferazone1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.adapters.ChroniclesAdapter
import com.example.sferazone1.adapters.MomentsAdapter
import com.example.sferazone1.adapters.UserImagesAdapter
import com.example.sferazone1.imageModel.Chronicles
import com.example.sferazone1.imageModel.Moments
import com.example.sferazone1.imageModel.UserImages

class MainActivity : AppCompatActivity() {

    private lateinit var userImagesRecyclerView: RecyclerView
    private lateinit var momentsRecyclerView: RecyclerView
    private lateinit var chroniclesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userImagesList: List<UserImages> = listOf(
            UserImages(R.drawable.im_user_1),
            UserImages(R.drawable.im_user_2),
            UserImages(R.drawable.im_user_3),
            UserImages(R.drawable.im_user_4)
        )

        val momentsList: List<Moments> = listOf(
            Moments(R.drawable.im_moments_1),
            Moments(R.drawable.im_moments_2),
            Moments(R.drawable.im_moments_3),
            Moments(R.drawable.im_moments_4),
            Moments(R.drawable.im_moments_5),
            Moments(R.drawable.im_moments_6),
        )

        val chroniclesList: List<Chronicles> = listOf(
            Chronicles(R.drawable.im_chronicles_1),
            Chronicles(R.drawable.im_chronicles_2),
            Chronicles(R.drawable.im_chronicles_3),
            Chronicles(R.drawable.im_chronicles_4),
            Chronicles(R.drawable.im_chronicles_5),
            Chronicles(R.drawable.im_chronicles_6),
            Chronicles(R.drawable.im_chronicles_7),
            Chronicles(R.drawable.im_chronicles_8),
            Chronicles(R.drawable.im_chronicles_9),
            Chronicles(R.drawable.im_chronicles_10),
            Chronicles(R.drawable.im_chronicles_11),
            Chronicles(R.drawable.im_chronicles_12)
        )

        userImagesRecyclerView = findViewById(R.id.user_images_recycler)

        userImagesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        userImagesRecyclerView.adapter = UserImagesAdapter(userImagesList)


        momentsRecyclerView = findViewById(R.id.user_moments_recycler)

        momentsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        momentsRecyclerView.adapter = MomentsAdapter(momentsList)


        chroniclesRecyclerView = findViewById(R.id.user_chronicles_recycler)


        chroniclesRecyclerView.layoutManager =
            GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)

        chroniclesRecyclerView.adapter = ChroniclesAdapter(chroniclesList)

        chroniclesRecyclerView.stopScroll()

    }
}