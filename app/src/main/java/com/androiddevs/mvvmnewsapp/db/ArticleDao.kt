package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertArticle(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}