package com.innovation.features.common.db.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostsEntity(
    @PrimaryKey
    val id: String,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
)
