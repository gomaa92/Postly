package com.innovation.features.posts.data.mapper

import com.innovation.features.posts.data.local.entity.PostsEntity
import com.innovation.features.posts.data.remote.model.PostDto
import com.innovation.features.posts.domain.model.Post

fun PostDto.toEntity(): PostsEntity {
    val uniqueString = "${title.orEmpty()}_${description.orEmpty()}_${urlToImage.orEmpty()}"
    val id = uniqueString.hashCode().toString()

    return PostsEntity(
        id = id,
        title = title,
        description = description,
        urlToImage = urlToImage,
    )
}

fun PostsEntity.toDomainModel() = Post(
    id = id,
    title = title.orEmpty(),
    description = description.orEmpty(),
    imageURL = urlToImage.orEmpty()
)
