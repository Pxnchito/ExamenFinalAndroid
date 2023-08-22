package com.francisco.onepieceec03navarroinfante.views.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.francisco.onepieceec03navarroinfante.R
import com.francisco.onepieceec03navarroinfante.model.OnePiece
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class OnePieceFavoriteFragmentDirections private constructor() {
  private data class ActionOnePieceFavoriteFragmentToOnePieceDetailFragment(
    public val onepiece: OnePiece
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_onePieceFavoriteFragment_to_onePieceDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionOnePieceFavoriteFragmentToOnePieceDetailFragment(onepiece: OnePiece):
        NavDirections = ActionOnePieceFavoriteFragmentToOnePieceDetailFragment(onepiece)
  }
}
