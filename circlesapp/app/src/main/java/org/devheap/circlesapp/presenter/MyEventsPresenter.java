package org.devheap.circlesapp.presenter;

import org.devheap.circlesapp.contracts.MyEventsContract;
import org.devheap.circlesapp.repository.EventsLab;

/**
 * Created by User on 23.09.2017.
 */

public class MyEventsPresenter implements MyEventsContract.Presenter {
    MyEventsContract.View mView;

    public MyEventsPresenter (MyEventsContract.View view) {
        mView = view;
    }
    @Override
    public void removeEvent(int eventId) {

    }

    @Override
    public void getEvents() {
        mView.updateUI(EventsLab.getEvents());
    }
}
