package me.niccorder.fragmentexample.communication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.niccorder.fragmentexample.R;

/**
 * A fragment which handles the user input, and passes this information up to the containing
 * activity so it can be delegated out appropriately there.
 */
public class UserInputFragment extends Fragment {

    /**
     * A callback which is to be implemented by the context which contains this activity. In our
     * case the context will be our containing activity.
     */
    interface Callback {

        /**
         * This method will be implemented by my activity, and my fragment will call this
         * method when there is a text change event.
         */
        void onTextChanged(@NonNull final String text);
    }

    /**
     * Reference to something that implements my Callback.
     */
    private Callback inputCallback;

    /**
     * It is important to use onAttach(Context context) here instead of onAttach(Activity activity).
     *
     * Why? Well, onAttach(Activity activity) is deprecated, which means it will be removed in a
     * later iteration of the android SDK. We don't want to willingly use code that we know will
     * be removed because we are thoughtful engineers :-)
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // `instanceof` here is how we check if the containing context (in our case the activity)
        // implements the required callback interface.
        //
        // If it does not implement the required callback, we want
        if (context instanceof Callback) {

            // If it is an instance of our Callback then we want to cast the context to a Callback
            // and store it as a reference so we can later update the callback when there has been
            // a text change event.
            inputCallback = (Callback) context;
        } else {
            // Throwing an error and making your application crash instead of just sweeping it under
            // the rug is called being an "offensive" programmer.
            //
            // The best defense is a strong offense.
            throw new IllegalStateException("Containing context must implement UserInputFragment.Callback.");
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        // Where I programmatically create my view that will be used for my fragment.
        // I pretty much always want this to be the only like in your onCreateView method.
        //
        // You should handle all of the view.findViewById(...) logic inside of your onViewCreated
        // or onActivityCreated method :-)
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    /**
     * Where I want everyone to call "findViewById(...)" because this is called after our view is
     * created so we don't throw any runtime exceptions when we findViewById(...)
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Grab a reference to my view
        TextInputLayout textInputLayout = view.findViewById(R.id.text_input_container);

        // add a text change listener for when the user inputs any text as we need
        // to make sure to notify the activity of any text changes so it can delegate
        // (or communicate) this to the appropriate area to be handled.
        textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Unused, but required method.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Unused, but required method.
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Will pass back the text change to my "inputCallback" which is my
                // activity in this case, since we casted it in onAttach(context)
                //
                // This is how we communicate upwards from a fragment -> a containing activity.
                // we use a "listener" or "callback" pattern to do this.
                inputCallback.onTextChanged(s.toString());
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Because we grabbed a reference to our containing context in on attach, it is approriate
        // to clean-up our references in onDetach() so that way we don't leak any references and
        // run into any odd runtime errors!
        inputCallback = null;
    }
}
