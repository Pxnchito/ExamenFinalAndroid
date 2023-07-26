package com.francisco.onepieceec03navarroinfante.model

import com.google.gson.annotations.SerializedName

data class OnePiece(

    val id: Int,
    val arc_title: String,
    val arc_description: String,
    val sagaId: Int

)

fun getData(): List<OnePiece> =
    listOf(
        OnePiece( 1,"One Piece","Descripcion", 1),
        OnePiece(1,"One Piece","Descripcion",  1),
        OnePiece(1,"One Piece","Descripcion",  1),
        OnePiece(1,"One Piece","Descripcion", 1),
        OnePiece(1,"One Piece","Descripcion", 1),

        )
