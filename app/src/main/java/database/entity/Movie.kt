package database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

/*
 * primaryKeys = arrayOf("name", "year")
 * ignoredColumns = ["ignore", "array"]
 */
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "movie_name")
    var name: String,
    var genres: String,
    var directors: String,
    var year: Int
) {
    constructor(): this(0L, "", "", "", 0)
}