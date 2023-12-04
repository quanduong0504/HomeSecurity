package com.trust.home.security.database.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.trust.home.security.database.entity.Face
import com.trust.home.security.database.entity.User

@Dao
interface DAOJob {
    @Insert
    fun insertFace(face: Face)

    @Query("SELECT * FROM Face_ID WHERE user_name = :userName")
    fun selectFaceWhere(userName: String): Face?

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM User_Data WHERE user_name = :userName")
    fun selectUserWhere(userName: String): User?

    @Query("SELECT * FROM User_Data WHERE user_name = :userName AND password = :password")
    fun selectUserWhere(userName: String, password: String): User?
}