/**
 * Created by andrejermak on 09/09/2017.
 */
public interface MyEventsContract {
    interface View{
        void showPopup();
        void removeEvent(int eventId);
        void loadEvents();
    }

    interface Presenter{
        void removeEvent(int eventId);
        void getEvents();
    }
}
