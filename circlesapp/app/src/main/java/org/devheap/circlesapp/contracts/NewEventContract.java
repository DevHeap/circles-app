package org.devheap.circlesapp.contracts;

import org.devheap.circlesapp.model.Event;
import org.devheap.circlesapp.model.Location;

import java.util.Date;
import java.util.List;

/**
 * Created by andrejermak on 09/09/2017.
 */
public interface NewEventContract {
    interface View{
        void setTitle(String newTitle);
        void setLocation(Location location);
        void addParticipants(List<Integer> participants);
        void addTime(Date time);
        void createEvent();
    }

    interface Presenter{
        void createEvent(Event event);
    }
}
