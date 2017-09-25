package org.devheap.circlesapp.Events;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.devheap.circlesapp.R;
import org.devheap.circlesapp.contracts.SingleEventContract;
import org.devheap.circlesapp.model.Event;
import org.devheap.circlesapp.model.Location;
import org.devheap.circlesapp.presenter.EventFragmentPresenter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EventFragment extends Fragment implements SingleEventContract.View {
    private Event mEvent;
    private TextView mTitleField;
    private TextView mDateTextView;
    private TextView mLocationTextView;
    private SingleEventContract.Presenter mPresenter;
    private UUID eventId;
    private static final String ARG_EVENT_ID = "event_id";

    public EventFragment() {
        mPresenter = new EventFragmentPresenter(this);
    }

    public static Fragment newInstance(UUID eventId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_EVENT_ID, eventId);
        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("id", mEvent.getId());
        outState.putSerializable("title", mEvent.getTitle());
        outState.putSerializable("date", mEvent.getDate());
        outState.putSerializable("location", mEvent.getLocation());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventId = (UUID) getArguments().getSerializable(ARG_EVENT_ID);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            initializeEvent((String)getArguments().getSerializable("title"), (Date)getArguments().getSerializable("date"),
                    (Location)getArguments().getSerializable("location"));
            eventId = (UUID)getArguments().getSerializable("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        mTitleField = (TextView) v.findViewById(R.id.event_title);
        mDateTextView = (TextView) v.findViewById(R.id.event_date_details);
        mLocationTextView = (TextView) v.findViewById(R.id.event_location_details);

        return v;
    }

    private void initializeEvent(String title, Date date, Location location) {
        mDateTextView.setText(date.toString());
        mTitleField.setText(title);
        //mLocationTextView.setText(location.toString());
        mLocationTextView.setText("location");
    }

    @Override
    public void loadEvent(Event event) {
        mEvent = event;
        initializeEvent(event.getTitle(), event.getDate(), event.getLocation());
    }

    @Override
    public void changeTitle(String newTitle) {

    }

    @Override
    public void removeEvent(int eventId) {

    }

    @Override
    public void addParticipants(List<Integer> participantsIDs) {

    }

    @Override
    public void changeLocation(Location newLocation) {

    }

    @Override
    public void deleteParticipant(int participantId) {

    }
}
