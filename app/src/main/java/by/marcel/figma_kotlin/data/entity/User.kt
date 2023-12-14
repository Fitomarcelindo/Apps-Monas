package by.marcel.crud.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,

    @ColumnInfo(name = "namaMK")
    val namaMK: String,

    @ColumnInfo(name = "kodeMK")
    val kodeMK: String,

    @ColumnInfo(name = "ruangan")
    val ruangan: String,

    @ColumnInfo(name = "status")
    val status: String
)



