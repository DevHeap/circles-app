package org.devheap.circlesapp.contracts;

import org.devheap.circlesapp.model.Event;
import org.devheap.circlesapp.model.Location;

import java.util.List;
import java.util.UUID;

/**
 * Created by andrejermak on 09/09/2017.
 */
public interface SingleEventContract {
    interface View{
        void loadEvent(Event event);
        void changeTitle(String newTitle);
        void removeEvent(int eventId);
        void addParticipants(List<Integer> participantsIDs);
        void changeLocation(Location newLocation);
        void deleteParticipant(int participantId);
    }

    interface Presenter{
        void loadEvent(UUID eventId);
        void changeTitle(String newTitle);
        void removeEvent(int eventId);
        void addParticipants(List<Integer> participantsIDs);
        void changeLocation(Location newLocation);
        void deleteParticipant(int participantId);
    }
}
