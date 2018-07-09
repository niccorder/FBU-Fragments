package me.niccorder.fragmentexample.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.niccorder.fragmentexample.R;
import me.niccorder.fragmentexample.internal.NotYetImplementedFragment;

public class ViewPagerExampleActivity extends AppCompatActivity {

    /**
     * Our list of fragments which our view pager will display.
     */
    private final List<Fragment> fragments = new ArrayList<>();

    /**
     * A reference to our view pager.
     */
    private ViewPager viewPager;

    /**
     * An instance variable for our view pager adapter we created, our ExampleAdapter.
     */
    private ExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_example);

        // Create some dummy fragments so that way we can showcase how to create an adapter.
        // normally this will contain actually useful fragments, and not just blank placeholder
        // fragments like in this example.
        fragments.add(new NotYetImplementedFragment());
        fragments.add(new NotYetImplementedFragment());
        fragments.add(new NotYetImplementedFragment());

        // Grab a reference to my view pager.
        viewPager = findViewById(R.id.pager);

        // Instantiate our ExampleAdapter, and pass it a reference to our supportFragmentManager()
        adapter = new ExampleAdapter(getSupportFragmentManager(), fragments);

        // Attach the adapter to our view pager.
        viewPager.setAdapter(adapter);
    }

    /**
     * Similar to a {@link android.support.v7.widget.RecyclerView.Adapter},
     * a FragmentStatePagerAdapter tells the {@link ViewPager} what to display.
     * <p>
     * If we make any changes, we will also have to call notifyDatasetChanged() just like we did
     * with the {@link android.support.v7.widget.RecyclerView}.
     */
    static class ExampleAdapter extends FragmentStatePagerAdapter {

        /**
         * The list of fragments this view pager will be displaying.
         */
        private List<Fragment> fragments;

        ExampleAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
