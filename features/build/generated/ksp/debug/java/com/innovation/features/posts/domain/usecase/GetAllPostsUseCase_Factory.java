package com.innovation.features.posts.domain.usecase;

import com.innovation.features.posts.domain.repository.PostsRepository;
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
public final class GetAllPostsUseCase_Factory implements Factory<GetAllPostsUseCase> {
  private final Provider<PostsRepository> postsRepositoryProvider;

  public GetAllPostsUseCase_Factory(Provider<PostsRepository> postsRepositoryProvider) {
    this.postsRepositoryProvider = postsRepositoryProvider;
  }

  @Override
  public GetAllPostsUseCase get() {
    return newInstance(postsRepositoryProvider.get());
  }

  public static GetAllPostsUseCase_Factory create(
      Provider<PostsRepository> postsRepositoryProvider) {
    return new GetAllPostsUseCase_Factory(postsRepositoryProvider);
  }

  public static GetAllPostsUseCase newInstance(PostsRepository postsRepository) {
    return new GetAllPostsUseCase(postsRepository);
  }
}
