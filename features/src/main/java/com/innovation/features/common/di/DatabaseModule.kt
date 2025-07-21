package com.innovation.features.common.di

import android.app.Application
import androidx.room.Room
import com.innovation.features.common.db.PostsDataBase
import com.innovation.features.posts.data.local.PostsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Provides the [PostsDataBase] instance for the application.
     *
     * @param app The application context.
     * @return An instance of [PostsDataBase].
     */
    @Provides
    @Singleton
    fun provideDatabase(app: Application): PostsDataBase {
        return Room.databaseBuilder(
            app,
            klass = PostsDataBase::class.java,
            name = "posts_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    /**
     * Provides the [PostsDao] instance for accessing posts data.
     *
     * @param db The [PostsDataBase] instance.
     * @return An instance of [PostsDao].
     */

    @Provides
    fun providePostsDao(db: PostsDataBase): PostsDao {
        return db.postsDao()
    }
}
