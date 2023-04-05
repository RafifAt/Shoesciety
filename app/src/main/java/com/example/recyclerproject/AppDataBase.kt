package com.example.recyclerproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        var INSTANCE: AppDataBase? = null

        fun getAppDatabase(context: Context) : AppDataBase? {
            if (INSTANCE == null){
                synchronized(AppDataBase::class){
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "UserAppDB").build()
                }
            }
            return INSTANCE
        }
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}