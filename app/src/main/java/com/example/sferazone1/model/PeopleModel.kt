package com.example.sferazone1.model

/**
 * Created by Viktor-Ruff
 * Date: 01.11.2022
 * Time: 17:15
 */
data class PeopleModel(

    val id: Int,
    val name: String,
    val profileImage: String,
    var subscription: Boolean,
    var subscriber: Boolean
)