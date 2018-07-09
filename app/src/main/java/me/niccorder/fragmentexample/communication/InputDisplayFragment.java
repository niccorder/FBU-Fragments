package me.niccorder.fragmentexample.communication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.niccorder.fragmentexample.R;


/**
 * This fragment is used to display the input from the user. This fragment's job is NOT TO GATHER
 * THE USER INPUT, ONLY TO DISPLAY IT.
 */
public class InputDisplayFragment extends Fragment {

    /**
     * A key which we use to grab the initial value from our {@link #getArguments()} method so that
     * way we can allow configuration of the initial text which is displayed.
     */
    private static final String KEY_INITIAL_VALUE = "key_initial_value";

    /**
     * Used as a creator method for our fragment. This is a common pattern that allows us to keep
     * our fragment creation logic contained inside of this class.
     *
     * Any containing activities should call this method if they want to create an instance of the
     * {@link InputDisplayFragment}.
     *
     * @param initialValue to be displayed.
     * @return a new instance of the {@link InputDisplayFragment} to be used.
     */
    public static InputDisplayFragment create(String initialValue) {
        final Bundle arguments = new Bundle();
        arguments.putString(KEY_INITIAL_VALUE, initialValue);

        final InputDisplayFragment fragment = new InputDisplayFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    /**
     * A reference to our displayText which we will be updating whenever there is a text change that
     * occurred.
     */
    private TextView displayText;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_input_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Grab a reference to our display text
        displayText = view.findViewById(R.id.display_tv);

        // Grab the initial value passed as an argument to this fragment as an argument
        final String initialDisplayText = getArguments().getString(KEY_INITIAL_VALUE);

        // Sets the display to the initial text we retrieved
        displayText.setText(initialDisplayText);
    }

    /**
     * Used by the activity to update the display text, ideally when the input text has changed.
     */
    public void setText(String text) {
        displayText.setText(text);
    }
}
