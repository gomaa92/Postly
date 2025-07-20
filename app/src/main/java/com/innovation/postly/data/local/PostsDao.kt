package com.innovation.postly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.innovation.postly.data.local.entity.PostsEntity

@Dao
interface PostsDao {
    @Query("SELECT * FROM post WHERE id = :id")
    suspend fun findPostById(id: Int): PostsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdatePosts(posts: List<PostsEntity>?)

    @Query("SELECT * FROM post")
    suspend fun getAllPosts(): List<PostsEntity>
}
