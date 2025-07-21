package com.innovation.features.posts.data.repository;

import com.innovation.features.posts.data.local.PostsDao;
import com.innovation.features.posts.data.remote.PostsService;
import com.innovation.utils.networkmanager.IConnectivityManager;
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
public final class PostsRepositoryImpl_Factory implements Factory<PostsRepositoryImpl> {
  private final Provider<PostsService> apiProvider;

  private final Provider<PostsDao> postsDaoProvider;

  private final Provider<IConnectivityManager> connectivityManagerProvider;

  public PostsRepositoryImpl_Factory(Provider<PostsService> apiProvider,
      Provider<PostsDao> postsDaoProvider,
      Provider<IConnectivityManager> connectivityManagerProvider) {
    this.apiProvider = apiProvider;
    this.postsDaoProvider = postsDaoProvider;
    this.connectivityManagerProvider = connectivityManagerProvider;
  }

  @Override
  public PostsRepositoryImpl get() {
    return newInstance(apiProvider.get(), postsDaoProvider.get(), connectivityManagerProvider.get());
  }

  public static PostsRepositoryImpl_Factory create(Provider<PostsService> apiProvider,
      Provider<PostsDao> postsDaoProvider,
      Provider<IConnectivityManager> connectivityManagerProvider) {
    return new PostsRepositoryImpl_Factory(apiProvider, postsDaoProvider, connectivityManagerProvider);
  }

  public static PostsRepositoryImpl newInstance(PostsService api, PostsDao postsDao,
      IConnectivityManager connectivityManager) {
    return new PostsRepositoryImpl(api, postsDao, connectivityManager);
  }
}
