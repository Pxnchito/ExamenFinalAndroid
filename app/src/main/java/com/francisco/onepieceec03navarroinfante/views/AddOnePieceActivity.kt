package com.francisco.onepieceec03navarroinfante.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.francisco.onepieceec03navarroinfante.databinding.ActivityAddOnePieceBinding
import com.francisco.onepieceec03navarroinfante.model.OnePIeceFirebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class AddOnePieceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddOnePieceBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var storage: FirebaseStorage
    private var selectedImageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddOnePieceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firestore = Firebase.firestore
        storage = Firebase.storage


        binding.btnRegisterOnepiece.setOnClickListener{
            val description: String = binding.tilOnepieceDescripcion.editText?.text.toString()
            val tittle: String = binding.tilOnepEceTittle.editText?.text.toString()
            val img: String = binding.onepieceImg.editText?.text.toString()
            if (tittle.isNotEmpty() && description.isNotEmpty() ){
                uploadImage(description,tittle)
            }
        }
        binding.btnAddImg.setOnClickListener {
            openImageSelector()
        }
    }


    private fun uploadImage(description: String, tittle: String ) {
        val storageRef = storage.reference
        val imageRef = storageRef.child("images/${selectedImageUri?.lastPathSegment}")
        val uploadTask = imageRef.putFile(selectedImageUri!!)
        uploadTask.addOnSuccessListener {
            // Image uploaded successfully, now you can retrieve its download URL
            imageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                val img = downloadUri.toString()

                // Now you can save the rest of the clothe data along with the image URL to Firestore
                val onepiece = hashMapOf(
                    "arcdescription" to description,
                    "arctitte" to tittle,
                    "img" to img
                )
                firestore.collection("onepiece")
                    .add(onepiece)
                    .addOnSuccessListener {
                        Toast.makeText(this,"Agreado a correctamente con id: ${it.id}", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"No se agregó el elemento !", Toast.LENGTH_SHORT).show()
                    }
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Error al subir la imagen !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getData(){
        firestore.collection("onepiece").get()
            .addOnSuccessListener {
                   val onepieces = mutableListOf<OnePIeceFirebase>()
                for (document in it.documents){
                       val onePiece = OnePIeceFirebase(
                           arctitte = document.data?.get("arc_title").toString(),
                           arcdescription = document.data?.get("arc_description").toString(),
                           img = document.data?.get("img").toString()
                       )
                           onepieces.add(onePiece)
                   }
            }
    }

    companion object {
        private const val IMAGE_PICKER_REQUEST = 123
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICKER_REQUEST && resultCode == RESULT_OK) {
            selectedImageUri = data?.data
        }
    }
    private fun openImageSelector() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICKER_REQUEST)
    }

}