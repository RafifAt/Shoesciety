package com.example.recyclerproject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
    @PrimaryKey(autoGenerate = true)
    val userId: Int? = null,
    val nama: String,
    val email: String,
    val date: String
    )


