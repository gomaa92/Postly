package com.innovation.postly.data.mapper

import com.innovation.postly.data.local.entity.PostsEntity
import com.innovation.postly.data.remote.model.PostDto
import com.innovation.postly.domain.model.Post

fun PostDto.toEntity(): PostsEntity {
    val uniqueString = "${urlToImage.orEmpty()}"
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
