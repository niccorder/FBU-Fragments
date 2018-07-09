package me.niccorder.fragmentexample.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.niccorder.fragmentexample.R;

/**
 * A placeholder fragment used for example purpouses. This shows text that says "this fragment hasn't
 * yet been implemented."
 *
 * This is a good pattern to use to make sure you preform piecewise development.
 */
public class NotYetImplementedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_not_yet_implemented, container, false);
    }
}
