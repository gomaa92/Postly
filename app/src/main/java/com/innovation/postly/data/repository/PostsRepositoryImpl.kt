package com.innovation.postly.data.repository

import com.innovation.postly.common.networkmanager.InternetManager
import com.innovation.postly.data.local.PostsDao
import com.innovation.postly.data.mapper.toDomainModel
import com.innovation.postly.data.mapper.toEntity
import com.innovation.postly.data.remote.PostsService
import com.innovation.postly.domain.model.Post
import com.innovation.postly.domain.repository.PostsRepository
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val postsDao: PostsDao,
    private val internetManager: InternetManager
) : PostsRepository {
    override suspend fun getTopHeadlines(
        page: Int,
        pageSize: Int
    ): List<Post> {
        return if (internetManager.isNetworkAvailable()) {
            val entities = api.getTopHeadlines(
                page = page,
                perPage = pageSize
            ).posts
                ?.map { it.toEntity() }
                .orEmpty()

            if (entities.isNotEmpty()) {
                postsDao.insertOrUpdatePosts(entities)
            }

            entities.map { it.toDomainModel() }
        } else {
            postsDao.getAllPosts().map { it.toDomainModel() }
        }
    }

    override suspend fun getPostById(id: Int) = postsDao.findPostById(id).toDomainModel()
}
