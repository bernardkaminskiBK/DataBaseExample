package com.example.databaseexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.databaseexample.database.dao.MovieDAO
import com.example.databaseexample.database.entity.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Movie::class), version = 1)
abstract class MyMoviesDatabase : RoomDatabase() {

    abstract fun movieDAO(): MovieDAO

    companion object {
        private var DATABASE: MyMoviesDatabase? = null

        fun getDataBase(context: Context): MyMoviesDatabase {
            return DATABASE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    MyMoviesDatabase::class.java,
                    "my_movie_db"
                ).fallbackToDestructiveMigration()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            GlobalScope.launch(Dispatchers.IO) {
                                DbUtils.prepareDatabaseWithData(DATABASE)
                            }
                        }
                    })
                    .build()
                DATABASE = database
                return database
            }
        }

    }

}