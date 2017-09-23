package org.devheap.circlesapp.presenter;

/**
 * Created by andrejermak on 09/09/2017.
 */
public interface AddParticipantsContract {
    interface View{
        void loadPeople();
        void loadCircles();
        void addParticipant(int id);
        void removeParticipant(int id);
        void addCircles();
        void saveChanges();
    }

    interface Presenter{
        void completeAddingPeople(int id);
    }
}
