package com.innovation.features.postdetails.domain.usecase;

import com.innovation.features.postdetails.domain.repository.PostDetailsRepository;
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
public final class GetPostDetailsUseCase_Factory implements Factory<GetPostDetailsUseCase> {
  private final Provider<PostDetailsRepository> postDetailsRepositoryProvider;

  public GetPostDetailsUseCase_Factory(
      Provider<PostDetailsRepository> postDetailsRepositoryProvider) {
    this.postDetailsRepositoryProvider = postDetailsRepositoryProvider;
  }

  @Override
  public GetPostDetailsUseCase get() {
    return newInstance(postDetailsRepositoryProvider.get());
  }

  public static GetPostDetailsUseCase_Factory create(
      Provider<PostDetailsRepository> postDetailsRepositoryProvider) {
    return new GetPostDetailsUseCase_Factory(postDetailsRepositoryProvider);
  }

  public static GetPostDetailsUseCase newInstance(PostDetailsRepository postDetailsRepository) {
    return new GetPostDetailsUseCase(postDetailsRepository);
  }
}
