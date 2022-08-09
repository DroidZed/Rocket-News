package tech.droidzed.rocketnewsdatabase.repositories

import tech.droidzed.rocketnewsdatabase.entities.ArticleDao
import tech.droidzed.rocketnewsdatabase.entities.ArticleEntity
import javax.inject.Inject


class ArticleRepository @Inject constructor(private val articleDao: ArticleDao) {

	/**
	 * > The function `bookmarkArticle` takes an `ArticleEntity` as a parameter and calls the
	 * `create` function on the `articleDao` object
	 *
	 * @param article ArticleEntity - The article to be bookmarked
	 */
	suspend fun bookmarkArticle(article: ArticleEntity) {
		articleDao.create(article)
	}


	/**
	 * > The function removes an article from the bookmarks table
	 *
	 * @param article ArticleEntity - The article to be removed from the bookmarks.
	 */
	suspend fun removeFromBookmarks(article: ArticleEntity) {
		articleDao.delete(article)
	}
}
