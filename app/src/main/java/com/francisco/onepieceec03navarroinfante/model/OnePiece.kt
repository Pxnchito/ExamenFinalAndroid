package com.francisco.onepieceec03navarroinfante.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "onepiece")
@Parcelize
data class OnePiece(

    @PrimaryKey
    val id: Int,
    @SerializedName("arc_title")
    val arctitle: String,
    @SerializedName("arc_description")
    val arcdescription: String,
    var isFavorite: Boolean = false

) : Parcelable
fun getData(): List<OnePiece> =
    listOf(
        OnePiece( 1,"One Piece","Descripcion"),
        OnePiece(2,"One Piece","Descripcion"),
        OnePiece(3,"One Piece","Descripcion"),
        OnePiece(4,"One Piece","Descripcion"),
        OnePiece(5,"One Piece","Descripcion")
        )
