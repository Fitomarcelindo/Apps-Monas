package by.marcel.crud.data.dao

import android.os.health.UidHealthStats
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import by.marcel.crud.data.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM USER_TABLE")
    fun getAll(): List<User>

    @Query("SELECT * FROM USER_TABLE WHERE uid IN (:userId)")
    fun loadAllByIds(userId: IntArray): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user_table WHERE uid = :uid")
    fun get (uid: Int) : User

    @Update
    fun Update(user : User)

}