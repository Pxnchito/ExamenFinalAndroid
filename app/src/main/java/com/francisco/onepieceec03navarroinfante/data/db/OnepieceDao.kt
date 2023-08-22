package com.francisco.onepieceec03navarroinfante.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.francisco.onepieceec03navarroinfante.model.OnePiece

@Dao
interface OnepieceDao {

    @Query("SELECT * FROM onepiece")
    fun getFavorites(): List<OnePiece>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(onePiece: OnePiece)

    @Delete
    suspend fun removeFirebase(onePiece: OnePiece)
}