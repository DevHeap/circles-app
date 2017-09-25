package org.devheap.circlesapp.repository;

import android.support.v7.widget.RecyclerView;

import org.devheap.circlesapp.model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by User on 20.09.2017.
 */

public class EventsLab {
    private static List<Event> mEvents;

    private EventsLab () {

    }

    public static Event getEvent(UUID id) {
        for (Event event : mEvents) {
            if (event.getId().equals(id))
                return event;
        }
        return null;
    }

    public static List getEvents() {
        if (mEvents == null) {
            mEvents = new ArrayList();
            for (int i = 0; i < 10; i++) {
                mEvents.add(new Event(UUID.randomUUID(), "Event# " + i, new Date(), null, null));
            }
        }
        return mEvents;
    }
}
