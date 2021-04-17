package database

import database.dao.MovieDAO
import database.entity.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DbUtils {

    companion object {
        suspend fun prepareDatabaseWithData(database: MyMoviesDatabase?) {
            database?.let { db ->
                withContext(Dispatchers.IO){
                    val movieDAO: MovieDAO = db.movieDAO()

                    val movieOne = Movie(0L, "Movie1", "Genre1", "Director1", 2000)
                    val movieTwo = Movie(0L, "Movie2", "Genre2", "Director2", 2002)
                    val movieThree = Movie(0L, "Movie3", "Genre3", "Director3", 2003)

                    movieDAO.insertMovies(movieOne, movieTwo, movieThree)
                }
            }
        }
    }

}