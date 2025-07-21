package com.innovation.features.postdetails.data.repository;

import com.innovation.features.posts.data.local.PostsDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PostDetailsRepositoryImpl_Factory implements Factory<PostDetailsRepositoryImpl> {
  private final Provider<PostsDao> postsDaoProvider;

  public PostDetailsRepositoryImpl_Factory(Provider<PostsDao> postsDaoProvider) {
    this.postsDaoProvider = postsDaoProvider;
  }

  @Override
  public PostDetailsRepositoryImpl get() {
    return newInstance(postsDaoProvider.get());
  }

  public static PostDetailsRepositoryImpl_Factory create(Provider<PostsDao> postsDaoProvider) {
    return new PostDetailsRepositoryImpl_Factory(postsDaoProvider);
  }

  public static PostDetailsRepositoryImpl newInstance(PostsDao postsDao) {
    return new PostDetailsRepositoryImpl(postsDao);
  }
}
