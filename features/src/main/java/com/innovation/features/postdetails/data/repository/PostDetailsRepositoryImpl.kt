package com.innovation.features.postdetails.data.repository

import com.innovation.features.postdetails.domain.repository.PostDetailsRepository
import com.innovation.features.posts.data.local.PostsDao
import com.innovation.features.posts.data.mapper.toDomainModel
import javax.inject.Inject

class PostDetailsRepositoryImpl @Inject constructor(
    private val postsDao: PostsDao,
) : PostDetailsRepository {
    override suspend fun getPostById(id: String) = postsDao.findPostById(id).toDomainModel()
}