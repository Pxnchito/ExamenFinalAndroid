// Generated by view binder compiler. Do not edit!
package com.francisco.onepieceec03navarroinfante.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.francisco.onepieceec03navarroinfante.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemOnepieceBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Guideline guidelineMiddle;

  @NonNull
  public final ImageView imageArco;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView txtDescripcion;

  @NonNull
  public final TextView txtNameArco;

  @NonNull
  public final TextView txtTituloDescripcion;

  private ItemOnepieceBinding(@NonNull CardView rootView, @NonNull Guideline guidelineMiddle,
      @NonNull ImageView imageArco, @NonNull LinearLayout linearLayout,
      @NonNull TextView txtDescripcion, @NonNull TextView txtNameArco,
      @NonNull TextView txtTituloDescripcion) {
    this.rootView = rootView;
    this.guidelineMiddle = guidelineMiddle;
    this.imageArco = imageArco;
    this.linearLayout = linearLayout;
    this.txtDescripcion = txtDescripcion;
    this.txtNameArco = txtNameArco;
    this.txtTituloDescripcion = txtTituloDescripcion;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemOnepieceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemOnepieceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_onepiece, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemOnepieceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline_middle;
      Guideline guidelineMiddle = ViewBindings.findChildViewById(rootView, id);
      if (guidelineMiddle == null) {
        break missingId;
      }

      id = R.id.imageArco;
      ImageView imageArco = ViewBindings.findChildViewById(rootView, id);
      if (imageArco == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.txt_descripcion;
      TextView txtDescripcion = ViewBindings.findChildViewById(rootView, id);
      if (txtDescripcion == null) {
        break missingId;
      }

      id = R.id.txt_name_arco;
      TextView txtNameArco = ViewBindings.findChildViewById(rootView, id);
      if (txtNameArco == null) {
        break missingId;
      }

      id = R.id.txt_titulo_descripcion;
      TextView txtTituloDescripcion = ViewBindings.findChildViewById(rootView, id);
      if (txtTituloDescripcion == null) {
        break missingId;
      }

      return new ItemOnepieceBinding((CardView) rootView, guidelineMiddle, imageArco, linearLayout,
          txtDescripcion, txtNameArco, txtTituloDescripcion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
