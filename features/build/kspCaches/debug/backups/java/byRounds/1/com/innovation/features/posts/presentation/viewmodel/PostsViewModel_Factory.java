package com.innovation.features.posts.presentation.viewmodel;

import com.innovation.features.posts.domain.usecase.GetAllPostsUseCase;
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
public final class PostsViewModel_Factory implements Factory<PostsViewModel> {
  private final Provider<GetAllPostsUseCase> getPostsUseCaseProvider;

  private final Provider<IConnectivityManager> connectivityManagerProvider;

  public PostsViewModel_Factory(Provider<GetAllPostsUseCase> getPostsUseCaseProvider,
      Provider<IConnectivityManager> connectivityManagerProvider) {
    this.getPostsUseCaseProvider = getPostsUseCaseProvider;
    this.connectivityManagerProvider = connectivityManagerProvider;
  }

  @Override
  public PostsViewModel get() {
    return newInstance(getPostsUseCaseProvider.get(), connectivityManagerProvider.get());
  }

  public static PostsViewModel_Factory create(Provider<GetAllPostsUseCase> getPostsUseCaseProvider,
      Provider<IConnectivityManager> connectivityManagerProvider) {
    return new PostsViewModel_Factory(getPostsUseCaseProvider, connectivityManagerProvider);
  }

  public static PostsViewModel newInstance(GetAllPostsUseCase getPostsUseCase,
      IConnectivityManager connectivityManager) {
    return new PostsViewModel(getPostsUseCase, connectivityManager);
  }
}
