package me.niccorder.fragmentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import me.niccorder.fragmentexample.bottom.BottomNavigationExampleActivity;
import me.niccorder.fragmentexample.communication.CommunicationBetweenFragmentsActivity;
import me.niccorder.fragmentexample.pager.ViewPagerExampleActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.communication_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCommunicationBetweenFragmentsActivity();
            }
        });

        findViewById(R.id.view_pager_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startViewPagerExampleActivity();
            }
        });

        findViewById(R.id.bottom_navigation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBottomNavigationExample();
            }
        });
    }

    private void startCommunicationBetweenFragmentsActivity() {
        Log.d(TAG, "startCommunicationBetweenFragmentsActivity()");

        final Intent intent = new Intent(this, CommunicationBetweenFragmentsActivity.class);
        startActivity(intent);
    }

    private void startViewPagerExampleActivity() {
        Log.d(TAG, "startViewPagerExampleActivity()");

        final Intent intent = new Intent(this, ViewPagerExampleActivity.class);
        startActivity(intent);
    }

    private void startBottomNavigationExample() {
        Log.d(TAG, "startBottomNavigationExample()");

        final Intent intent = new Intent(this, BottomNavigationExampleActivity.class);
        startActivity(intent);
    }
}
