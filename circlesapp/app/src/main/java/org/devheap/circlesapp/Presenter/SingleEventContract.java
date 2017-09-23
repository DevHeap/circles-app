package org.devheap.circlesapp.presenter;

import java.util.List;

/**
 * Created by andrejermak on 09/09/2017.
 */
public interface SingleEventContract {
    interface View{
        void loadEvent(int eventId);
        void changeTitle(String newTitle);
        void removeEvent(int eventId);
        void addParticipants(List<Integer> participantsIDs);
        void changeLocation(Location newLocation);
        void deleteParticipant(int participantId);
    }

    interface Presenter{
        void loadEvent(int eventId);
        void changeTitle(String newTitle);
        void removeEvent(int eventId);
        void addParticipants(List<Integer> participantsIDs);
        void changeLocation(Location newLocation);
        void deleteParticipant(int participantId);
    }
}
