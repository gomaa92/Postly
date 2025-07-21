package com.innovation.features.common.di;

import com.innovation.features.common.db.PostsDataBase;
import com.innovation.features.posts.data.local.PostsDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvidePostsDaoFactory implements Factory<PostsDao> {
  private final Provider<PostsDataBase> dbProvider;

  public DatabaseModule_ProvidePostsDaoFactory(Provider<PostsDataBase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public PostsDao get() {
    return providePostsDao(dbProvider.get());
  }

  public static DatabaseModule_ProvidePostsDaoFactory create(Provider<PostsDataBase> dbProvider) {
    return new DatabaseModule_ProvidePostsDaoFactory(dbProvider);
  }

  public static PostsDao providePostsDao(PostsDataBase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePostsDao(db));
  }
}
