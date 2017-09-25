package org.devheap.circlesapp.model;

import java.util.UUID;

/**
 * Created by User on 20.09.2017.
 */

public class User {
    private UUID mId;
    private String mName;
    private Event[] mEvents;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Event[] getEvents() {
        return mEvents;
    }

    public void setEvents(Event[] events) {
        mEvents = events;
    }
}
