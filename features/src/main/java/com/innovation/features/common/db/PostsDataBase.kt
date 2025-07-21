package com.innovation.features.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.innovation.features.posts.data.local.PostsDao
import com.innovation.features.posts.data.local.entity.PostsEntity

@Database(entities = [PostsEntity::class], version = 1, exportSchema = false)
abstract class PostsDataBase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}
// This code defines a Room database for storing posts in the Postly application.