package com.francisco.onepieceec03navarroinfante.views.fragments


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.francisco.onepieceec03navarroinfante.data.repository.OnePieceRepository
import com.francisco.onepieceec03navarroinfante.data.response.ApiResponse
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import com.francisco.onepieceec03navarroinfante.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class OnePieceListViewModel: ViewModel() {
    private val repository : OnePieceRepository = OnePieceRepository()
    private val onepieceL = MutableLiveData<List<OnePiece>?>()
    val onepieceList :LiveData<List<OnePiece>?>
        get()=onepieceL

    fun getOnePieceFromService(){
        GlobalScope.launch(Dispatchers.IO) {

            when(val response = repository.getOnePieces() ){
                is ApiResponse.Error -> {

                }
                is ApiResponse.Success ->{
                    onepieceL.postValue(response.data)
                }
            }
        }
    }
}