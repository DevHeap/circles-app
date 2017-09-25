package org.devheap.circlesapp.contracts;

/**
 * Created by andrejermak on 09/09/2017.
 */
public interface SettingsContract {
    interface View{
        void setPeriodicity(int seconds);
        void enableNotifications(boolean enable);
        void setMyTitle(); // FIXME
        void logOut();
    }

    interface Presenter{
        void setPeriodicity(int seconds);
        void enableNotifications(boolean enable);
        void setMyTitle(); // FIXME
        void logOut();
    }
}
