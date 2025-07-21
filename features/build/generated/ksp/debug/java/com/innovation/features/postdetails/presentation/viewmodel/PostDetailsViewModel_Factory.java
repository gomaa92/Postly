package com.innovation.features.postdetails.presentation.viewmodel;

import com.innovation.features.postdetails.domain.usecase.GetPostDetailsUseCase;
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
public final class PostDetailsViewModel_Factory implements Factory<PostDetailsViewModel> {
  private final Provider<GetPostDetailsUseCase> getPostDetailsUseCaseProvider;

  public PostDetailsViewModel_Factory(
      Provider<GetPostDetailsUseCase> getPostDetailsUseCaseProvider) {
    this.getPostDetailsUseCaseProvider = getPostDetailsUseCaseProvider;
  }

  @Override
  public PostDetailsViewModel get() {
    return newInstance(getPostDetailsUseCaseProvider.get());
  }

  public static PostDetailsViewModel_Factory create(
      Provider<GetPostDetailsUseCase> getPostDetailsUseCaseProvider) {
    return new PostDetailsViewModel_Factory(getPostDetailsUseCaseProvider);
  }

  public static PostDetailsViewModel newInstance(GetPostDetailsUseCase getPostDetailsUseCase) {
    return new PostDetailsViewModel(getPostDetailsUseCase);
  }
}
