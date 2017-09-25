package org.devheap.circlesapp.Events;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.devheap.circlesapp.R;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.event_list_fragment);

        if (fragment == null) {
            fragment = new EventListFragment();
            fm.beginTransaction()
                    .add(R.id.event_list_fragment, fragment)
                    .commit();
        }
    }
}
