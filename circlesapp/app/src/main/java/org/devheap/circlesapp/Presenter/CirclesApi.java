package org.devheap.circlesapp.presenter;

import org.devheap.circlesapp.model.Location;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Andrey Ermak on 23/09/2017.
 */

public interface CirclesApi {
    @POST("/api/post")
    Call<Location> postLocation(@Body Location location);
}
