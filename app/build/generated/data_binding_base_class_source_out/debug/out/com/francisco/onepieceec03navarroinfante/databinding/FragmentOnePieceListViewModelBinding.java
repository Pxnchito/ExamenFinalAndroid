// Generated by view binder compiler. Do not edit!
package com.francisco.onepieceec03navarroinfante.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.francisco.onepieceec03navarroinfante.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class FragmentOnePieceListViewModelBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  private FragmentOnePieceListViewModelBinding(@NonNull FrameLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentOnePieceListViewModelBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentOnePieceListViewModelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_one_piece_list_view_model, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentOnePieceListViewModelBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new FragmentOnePieceListViewModelBinding((FrameLayout) rootView);
  }
}
