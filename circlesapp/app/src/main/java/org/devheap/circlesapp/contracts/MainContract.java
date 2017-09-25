package org.devheap.circlesapp.contracts;

interface MainContract {
    interface View{
        void locationHiddenToast();
        void hideLocation();
        void updateLocation();
    }

    interface Presernter{
        void locationHiddenToast();
        void hideLocation();
        void updateLocation();
    }
}
