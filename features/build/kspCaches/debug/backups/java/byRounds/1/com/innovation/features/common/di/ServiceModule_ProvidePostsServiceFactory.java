package com.innovation.features.common.di;

import com.innovation.features.posts.data.remote.PostsService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ServiceModule_ProvidePostsServiceFactory implements Factory<PostsService> {
  private final Provider<Retrofit> retrofitProvider;

  public ServiceModule_ProvidePostsServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public PostsService get() {
    return providePostsService(retrofitProvider.get());
  }

  public static ServiceModule_ProvidePostsServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new ServiceModule_ProvidePostsServiceFactory(retrofitProvider);
  }

  public static PostsService providePostsService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.providePostsService(retrofit));
  }
}
