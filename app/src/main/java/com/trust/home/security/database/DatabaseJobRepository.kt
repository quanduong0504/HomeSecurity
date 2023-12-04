package com.trust.home.security.database

import androidx.annotation.WorkerThread
import com.trust.home.security.database.local.DAOJob
import com.trust.home.security.database.entity.Face
import com.trust.home.security.database.entity.User

class DatabaseJobRepository(private val dao: DAOJob)  {
    @WorkerThread
    suspend fun insertFace(face: Face) {
        return dao.insertFace(face)
    }

    @WorkerThread
    suspend fun selectFaceWhere(userName: String): Face? {
        return dao.selectFaceWhere(userName)
    }

    @WorkerThread
    suspend fun insertUser(user: User) {
        return dao.insertUser(user)
    }

    @WorkerThread
    suspend fun selectUserWhere(userName: String): User? {
        return dao.selectUserWhere(userName)
    }

    @WorkerThread
    suspend fun selectUserWhere(userName: String, password: String): User? {
        return dao.selectUserWhere(userName, password)
    }
}