package com.innovation.features.posts.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.innovation.features.common.db.PostsDataBase
import com.innovation.features.common.db.entitiy.PostsEntity
import com.innovation.features.posts.MainDispatcherRule
import com.innovation.features.posts.data.local.PostsDao
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class PostsDaoTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private lateinit var database: PostsDataBase
    private lateinit var dao: PostsDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PostsDataBase::class.java
        ).allowMainThreadQueries().build()

        dao = database.postsDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertAndGetPostById_shouldReturnInsertedPost() = runTest {
        val post = PostsEntity(id = "1", title = "Test", description = "Desc", urlToImage = "url")
        dao.insertOrUpdatePosts(listOf(post))

        val loadedPost = dao.findPostById("1")

        assertEquals(post.id, loadedPost.id)
        assertEquals(post.title, loadedPost.title)
    }

    @Test
    fun insertAndGetAllPosts_shouldReturnAllPosts() = runTest {
        val post1 =
            PostsEntity(id = "1", title = "First", description = "First Desc", urlToImage = "url1")
        val post2 = PostsEntity(
            id = "2",
            title = "Second",
            description = "Second Desc",
            urlToImage = "url2"
        )

        dao.insertOrUpdatePosts(listOf(post1, post2))

        val posts = dao.getAllPosts()

        assertEquals(2, posts.size)
        assertTrue(posts.any { it.id == "1" })
        assertTrue(posts.any { it.id == "2" })
    }
}
