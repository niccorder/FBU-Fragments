package me.niccorder.fragmentexample.communication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.niccorder.fragmentexample.R;

public class CommunicationBetweenFragmentsActivity extends AppCompatActivity implements UserInputFragment.Callback {

    // Bottom fragment
    private InputDisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_between_fragments);

        // This attaches my first fragment to my activity specifically in the fragment_one_container
        // space.
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_one_container, new UserInputFragment())
                .commit();

        // Create our display fragment, set the initially displayed value to "sup fam"
        displayFragment = InputDisplayFragment.create("Sup fam!");

        // then we attach our fragment to our activity, in the bottom most fragment container.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_two_container, displayFragment)
                .commit();
    }

    /**
     * This method will be called when the UserInputFragment has detected a text change.
     *
     */
    @Override
    public void onTextChanged(@NonNull String text) {
        Log.d("MainAcitivty", "text changed = " + text);

        // Set the text inside of the display fragment to the text passed to this method.
        // remember, this method is the UserInputFragment.Callback where we actually
        displayFragment.setText(text);
    }
}