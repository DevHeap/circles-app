package org.devheap.circlesapp.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by andrejermak on 09/09/2017.
 */
public class Event {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private User[] mUsers;
    private Location mLocation;

    public Event(UUID id, String title, Date date, User[] users, Location location) {
        mId = id;
        mTitle = title;
        mDate = date;
        mUsers = users;
        mLocation = location;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public User[] getUsers() {
        return mUsers;
    }

    public void setUsers(User[] users) {
        mUsers = users;
    }
}
