package com.example.testcity.model

data class Categories(
    val id: Int,
    val imageColor: Int,
    val image: Int,
    val itemName: String,
//    val itemCount: Int,
    val itemTypeName: String,
)
data class Popular(
    val id: Int,
    val image: Int,
    val itemName: String,
    val smallImage: Int,
    val itemWeight: String
)