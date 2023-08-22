package com.francisco.onepieceec03navarroinfante.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.francisco.onepieceec03navarroinfante.model.OnePiece

@Database(entities = [OnePiece::class], version = 1)
abstract class OnePieceDataBase : RoomDatabase() {
    abstract fun onePieceDao(): OnepieceDao

    companion object{
        @Volatile
        private var instance: OnePieceDataBase? = null
        fun getDatabase(context: Context): OnePieceDataBase{
            if (instance == null){
                synchronized(this){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context): OnePieceDataBase? {
            return Room.databaseBuilder(
                context.applicationContext,
                OnePieceDataBase::class.java,
                "onepiece_database"
            ).build()
        }
    }
}