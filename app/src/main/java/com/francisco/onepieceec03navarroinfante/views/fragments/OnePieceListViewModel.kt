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
     val onepieceList = MutableLiveData<List<OnePiece>?>()
     val repository:OnePieceRepository = OnePieceRepository()
    val cerveceriaList: LiveData<List<OnePiece>?>
        get() = onepieceList
    fun getOnePieceList(){
        val data = getData()
        onepieceList.value= data
    }
    ////CORREGIR
    fun getOnePieceFromService(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getOnePieces()
            when(response){

                is ApiResponse.Error -> {
                    //Colocar error
                }
                is ApiResponse.Success -> {
                    onepieceList.postValue(response.data)
                }
            }
        }
    }
}