package org.devheap.circlesapp.contracts;


import org.devheap.circlesapp.model.Map;

/**
 * Created by andrejermak on 09/09/2017.
 */

interface MapFragmentContract {
    Map map = new Map();
    interface View{
        void setCircles();
        void setEvents();
        void loadMap();
        void showCircles();
        void showEvents();
    }

    interface Presenter{
        void initMap();
        void loadCircles();
        void loadEvents();
    }
}
