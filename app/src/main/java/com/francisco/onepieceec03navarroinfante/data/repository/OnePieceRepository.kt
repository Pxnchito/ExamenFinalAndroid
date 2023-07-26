package com.francisco.onepieceec03navarroinfante.data.repository

import com.francisco.onepieceec03navarroinfante.data.response.ApiResponse
import com.francisco.onepieceec03navarroinfante.data.response.OnePieceListResponse
import com.francisco.onepieceec03navarroinfante.data.retrofit.ServiceInstance
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import java.lang.Exception

class OnePieceRepository {
    suspend fun getOnePieces(): ApiResponse<List<OnePiece>?> {
        return try {
            val response = ServiceInstance.getOnePieceService().getOnePieces()
            ApiResponse.Success(response)
        }catch (e: Exception) {
            ApiResponse. Error (e)
        }
    }
}