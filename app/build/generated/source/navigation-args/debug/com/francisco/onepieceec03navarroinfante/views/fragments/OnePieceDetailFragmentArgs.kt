package com.francisco.onepieceec03navarroinfante.views.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class OnePieceDetailFragmentArgs(
  public val onepiece: OnePiece
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(OnePiece::class.java)) {
      result.putParcelable("onepiece", this.onepiece as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(OnePiece::class.java)) {
      result.putSerializable("onepiece", this.onepiece as Serializable)
    } else {
      throw UnsupportedOperationException(OnePiece::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(OnePiece::class.java)) {
      result.set("onepiece", this.onepiece as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(OnePiece::class.java)) {
      result.set("onepiece", this.onepiece as Serializable)
    } else {
      throw UnsupportedOperationException(OnePiece::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): OnePieceDetailFragmentArgs {
      bundle.setClassLoader(OnePieceDetailFragmentArgs::class.java.classLoader)
      val __onepiece : OnePiece?
      if (bundle.containsKey("onepiece")) {
        if (Parcelable::class.java.isAssignableFrom(OnePiece::class.java) ||
            Serializable::class.java.isAssignableFrom(OnePiece::class.java)) {
          __onepiece = bundle.get("onepiece") as OnePiece?
        } else {
          throw UnsupportedOperationException(OnePiece::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__onepiece == null) {
          throw IllegalArgumentException("Argument \"onepiece\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"onepiece\" is missing and does not have an android:defaultValue")
      }
      return OnePieceDetailFragmentArgs(__onepiece)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        OnePieceDetailFragmentArgs {
      val __onepiece : OnePiece?
      if (savedStateHandle.contains("onepiece")) {
        if (Parcelable::class.java.isAssignableFrom(OnePiece::class.java) ||
            Serializable::class.java.isAssignableFrom(OnePiece::class.java)) {
          __onepiece = savedStateHandle.get<OnePiece?>("onepiece")
        } else {
          throw UnsupportedOperationException(OnePiece::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__onepiece == null) {
          throw IllegalArgumentException("Argument \"onepiece\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"onepiece\" is missing and does not have an android:defaultValue")
      }
      return OnePieceDetailFragmentArgs(__onepiece)
    }
  }
}
