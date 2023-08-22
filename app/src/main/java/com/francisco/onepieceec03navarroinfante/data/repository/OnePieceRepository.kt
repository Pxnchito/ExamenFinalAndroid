package com.francisco.onepieceec03navarroinfante.data.repository


import com.francisco.onepieceec03navarroinfante.data.db.OnepieceDao
import com.francisco.onepieceec03navarroinfante.data.response.ApiResponse
import com.francisco.onepieceec03navarroinfante.data.response.OnePieceListResponse
import com.francisco.onepieceec03navarroinfante.data.retrofit.ServiceInstance
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import java.lang.Exception

class OnePieceRepository(val onepieceDao: OnepieceDao?= null){

    suspend fun getOnePieces(): ApiResponse<List<OnePiece>?> {
        return try {
            val response = ServiceInstance.getOnePieceService().getOnePieces()
            ApiResponse.Success(response)
        }catch (e: Exception) {
            ApiResponse.Error(e)
        }
    }
    suspend fun addFavorite(onePiece: OnePiece){
         onepieceDao?.let {
              it.addFavorite(onePiece)
           }
      }

    suspend fun removeFirebase(onePiece: OnePiece) {
        onepieceDao?.let {
            it.removeFirebase(onePiece)
        }
    }
      fun getFavorites(): List<OnePiece> {
           onepieceDao?.let {
                   return it.getFavorites()
       } ?: kotlin.run {
               return listOf()
        }
    }
}