package database.entity

import androidx.room.ColumnInfo

data class MovieShort(
    @ColumnInfo(name = "movie_name")
    var name: String,
    var year: Int
)