package org.devheap.circlesapp.contracts;

import org.devheap.circlesapp.model.Event;

import java.util.List;

/**
 * Created by andrejermak on 09/09/2017.
 */
public interface MyEventsContract {
    interface View{
        void showPopup();
        void removeEvent(int eventId);
        void updateUI(List<Event> events);
    }

    interface Presenter{
        void removeEvent(int eventId);
        void getEvents();
    }
}
