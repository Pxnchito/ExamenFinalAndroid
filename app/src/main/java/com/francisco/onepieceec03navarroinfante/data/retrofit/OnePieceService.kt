package com.francisco.onepieceec03navarroinfante.data.retrofit
import com.francisco.onepieceec03navarroinfante.data.response.OnePieceListResponse
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import retrofit2.http.GET

interface OnePieceService {
    @GET("arcs")
    suspend fun getOnePieces(): List<OnePiece>
}