package com.example.sferazone1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.adapters.ChroniclesAdapter
import com.example.sferazone1.adapters.MomentsAdapter
import com.example.sferazone1.adapters.UserImagesAdapter
import com.example.sferazone1.imageModel.ImageModel

class MainActivity : AppCompatActivity() {

    private lateinit var userImagesRecyclerView: RecyclerView
    private lateinit var momentsRecyclerView: RecyclerView
    private lateinit var chroniclesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userImagesList: List<ImageModel> = listOf(
            ImageModel(R.drawable.im_user_1),
            ImageModel(R.drawable.im_user_2),
            ImageModel(R.drawable.im_user_3),
            ImageModel(R.drawable.im_user_4)
        )

        val momentsList: List<ImageModel> = listOf(
            ImageModel(R.drawable.im_moments_1),
            ImageModel(R.drawable.im_moments_2),
            ImageModel(R.drawable.im_moments_3),
            ImageModel(R.drawable.im_moments_1),
            ImageModel(R.drawable.im_moments_2),
            ImageModel(R.drawable.im_moments_3),
        )

        val chroniclesList: List<ImageModel> = listOf(
            ImageModel(R.drawable.im_chronicles_1),
            ImageModel(R.drawable.im_chronicles_2),
            ImageModel(R.drawable.im_chronicles_3),
            ImageModel(R.drawable.im_chronicles_4),
            ImageModel(R.drawable.im_chronicles_5),
            ImageModel(R.drawable.im_chronicles_6),
            ImageModel(R.drawable.im_chronicles_7),
            ImageModel(R.drawable.im_chronicles_8),
            ImageModel(R.drawable.im_chronicles_9),
            ImageModel(R.drawable.im_chronicles_10),
            ImageModel(R.drawable.im_chronicles_11),
            ImageModel(R.drawable.im_chronicles_12)
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