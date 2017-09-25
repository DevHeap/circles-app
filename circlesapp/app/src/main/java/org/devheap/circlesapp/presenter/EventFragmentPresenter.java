package org.devheap.circlesapp.presenter;

import org.devheap.circlesapp.contracts.SingleEventContract;
import org.devheap.circlesapp.model.Event;
import org.devheap.circlesapp.model.Location;
import org.devheap.circlesapp.repository.EventsLab;

import java.util.List;
import java.util.UUID;

/**
 * Created by User on 23.09.2017.
 */

public class EventFragmentPresenter implements SingleEventContract.Presenter {
    SingleEventContract.View mView;

    public EventFragmentPresenter(SingleEventContract.View view) {
        this.mView = view;
    }

    @Override
    public void loadEvent(UUID eventId) {
        Event event = EventsLab.getEvent(eventId);
        if (event != null) {
            mView.loadEvent(event);
        }
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
