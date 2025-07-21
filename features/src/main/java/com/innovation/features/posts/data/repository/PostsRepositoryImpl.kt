package com.innovation.features.posts.data.repository

import com.innovation.features.posts.data.local.PostsDao
import com.innovation.features.common.model.toDomainModel
import com.innovation.features.common.model.toEntity
import com.innovation.features.posts.data.remote.PostsService
import com.innovation.features.common.model.Post
import com.innovation.features.posts.domain.repository.PostsRepository
import com.innovation.utils.networkmanager.IConnectivityManager
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val postsDao: PostsDao,
    private val connectivityManager: IConnectivityManager
) : PostsRepository {
    override suspend fun getTopHeadlines(
        page: Int,
        pageSize: Int
    ): List<Post> {
        return if (connectivityManager.isNetworkAvailable()) {
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
}
