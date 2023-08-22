package com.francisco.onepieceec03navarroinfante.views.fragments

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.francisco.onepieceec03navarroinfante.model.OnePIeceFirebase
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import android.nfc.Tag
import android.content.ContentValues.TAG
import android.util.Log

class FirebaseListViewModel(application: Application): AndroidViewModel(application) {
    private val firestore: FirebaseFirestore= Firebase.firestore
    private val _onepiece: MutableLiveData<List<OnePIeceFirebase>> = MutableLiveData()
    val onepiece: LiveData<List<OnePIeceFirebase>> = _onepiece

    fun firebaseList(){
        firestore.collection("onepiece").get()
            .addOnSuccessListener {
                result -> val onepieceList= mutableListOf<OnePIeceFirebase>()
                for (document in result.documents){
                    val onepieceFirebase= OnePIeceFirebase(
                        arctitte = document.getString("arctitte") ?: "",
                        arcdescription = document.getString("arcdescription") ?: "",
                        img = document.getString("img")?: ""
                    )
                    onepieceList.add(onepieceFirebase)
                }
                _onepiece.value= onepieceList
            }
            .addOnFailureListener{
                //OJITO
                exception -> Log.e(TAG,"Error obteniendo documentos", exception)
            }
    }

}