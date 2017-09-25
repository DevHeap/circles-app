package org.devheap.circlesapp.Events;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.devheap.circlesapp.R;

import java.util.UUID;

public class EventActivity extends AppCompatActivity {
    public static final String EXTRA_EVENT_ID = "org.devheap.circlesapp.event_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.event_list_fragment);

        if (fragment == null) {
            UUID eventId = (UUID) getIntent().getSerializableExtra(EXTRA_EVENT_ID);
            fragment = EventFragment.newInstance(eventId);
            fm.beginTransaction()
                    .add(R.id.event_list_fragment, fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context packageContext, UUID eventId) {
        Intent intent = new Intent(packageContext, EventActivity.class);
        intent.putExtra(EXTRA_EVENT_ID, eventId);
        return intent;
    }
}
