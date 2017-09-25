package org.devheap.circlesapp.Events;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.devheap.circlesapp.R;
import org.devheap.circlesapp.contracts.MyEventsContract;
import org.devheap.circlesapp.model.Event;
import org.devheap.circlesapp.presenter.MyEventsPresenter;
import org.devheap.circlesapp.repository.EventsLab;

import java.util.List;


public class EventListFragment extends Fragment implements MyEventsContract.View {
    private RecyclerView mEventRecyclerView;
    private EventAdapter mEventAdapter;
    MyEventsContract.Presenter mPresenter;
    private static final String TAG = "Event list fragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        Log.d(TAG, "Creating event list fragment");
        mPresenter = new MyEventsPresenter(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEventRecyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);
        mEventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d(TAG, "Event list fragment created");
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getEvents();
    }

    @Override
    public void showPopup() {

    }

    @Override
    public void removeEvent(int eventId) {

    }

    @Override
    public void updateUI(List<Event> events) {
        if (mEventAdapter == null) {
            mEventAdapter = new EventAdapter(events);
            mEventRecyclerView.setAdapter(mEventAdapter);
        }
        else {
            mEventAdapter.notifyDataSetChanged();
        }
    }


    private class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private TextView mLocationTextView;
        private Event mEvent;

        public void bindEvent(Event event) {
            mEvent = event;
            mTitleTextView.setText(event.getTitle());
            mDateTextView.setText(event.getDate().toString());
            mLocationTextView.setText("location");
            //mLocationTextView.setText(event.getLocation().toString());
        }

        public EventHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.event_item_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.event_item_date_text_view);
            mLocationTextView = (TextView) itemView.findViewById(R.id.event_item_location_text_view);
        }

        @Override
        public void onClick(View view) {
            Intent intent = EventActivity.newIntent(getActivity(), mEvent.getId());
            startActivity(intent);
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder> {
        private List<Event> mEvents;

        public EventAdapter(List<Event> events) {
            mEvents = events;
        }
        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.event_item, parent, false);

            return new EventHolder(view);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Event event = mEvents.get(position);
            holder.bindEvent(event);
        }

        @Override
        public int getItemCount() {
            return mEvents.size();
        }
    }
}
