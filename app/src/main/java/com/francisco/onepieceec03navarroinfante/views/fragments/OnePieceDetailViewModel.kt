package com.francisco.onepieceec03navarroinfante.views.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.francisco.onepieceec03navarroinfante.data.db.OnePieceDataBase
import com.francisco.onepieceec03navarroinfante.data.repository.OnePieceRepository
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnePieceDetailViewModel (application: Application): AndroidViewModel(application) {

    private val repository: OnePieceRepository
    init {
        val db = OnePieceDataBase.getDatabase(application)
        repository = OnePieceRepository(db.onePieceDao())
    }

    fun addFavorite(onePiece: OnePiece){
        viewModelScope.launch(Dispatchers.IO){
            repository.addFavorite(onePiece)
        }
    }

    fun removeFavorite(onePiece: OnePiece) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFirebase(onePiece)
        }
    }

}