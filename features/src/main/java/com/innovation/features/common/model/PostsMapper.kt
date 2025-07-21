package com.innovation.features.common.model

import com.innovation.features.common.db.entitiy.PostsEntity
import com.innovation.features.posts.data.remote.model.PostDto

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
