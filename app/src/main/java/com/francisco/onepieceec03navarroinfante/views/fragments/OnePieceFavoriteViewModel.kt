package com.francisco.onepieceec03navarroinfante.views.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.francisco.onepieceec03navarroinfante.data.db.OnePieceDataBase
import com.francisco.onepieceec03navarroinfante.data.repository.OnePieceRepository
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnePieceFavoriteViewModel (application: Application): AndroidViewModel(application)  {
    private val repository: OnePieceRepository
    private val _favorites: MutableLiveData<List<OnePiece>> = MutableLiveData()
    val favorites: LiveData<List<OnePiece>> = _favorites
    init {
        val db = OnePieceDataBase.getDatabase(application)
        repository = OnePieceRepository(db.onePieceDao())
    }
    fun getFavorites(){
        viewModelScope.launch(Dispatchers.IO){
            val data =  repository.getFavorites()
            _favorites.postValue(data)
        }
    }

}