package com.example.recyclerproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahUser(user: User)

    @Query("SELECT * FROM User")
    fun ambilSemuaUser(): LiveData<List<User>>

}