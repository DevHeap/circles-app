package org.devheap.circlesapp.presenter;

import org.devheap.circlesapp.model.Location;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andrey Ermak on 24/09/2017.
 */

public class ServerRequestProvider {
    private static ServerRequestProvider serverRequestProvider = null;

    private static Retrofit retrofit;
    private static CirclesApi circlesApi;

    private static String API_URL = "http://localhost.com/"; // TODO
    private static String TOKEN = "";

    public static ServerRequestProvider getInstance(){
        if(serverRequestProvider != null)
            return serverRequestProvider;
        else {
            serverRequestProvider = new ServerRequestProvider();

            retrofitInit();

            return serverRequestProvider;
        }
    }

    public static void setToken(String token){
        TOKEN = token;
    }

    public static void setApiUrl(String newUrl){
        API_URL = newUrl;
    }

    public static String getApiUrl(){
        return API_URL;
    }

    public static void sendLocation(Location location){
        circlesApi.postLocation(location);
    }

    // Retrofit2 and OkHttp3
    private static void retrofitInit() {
        // Used for useful inserting to header of requests auth token
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                if(TOKEN.isEmpty())
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization", TOKEN);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .client(okHttpClient)
                .build();
        circlesApi = retrofit.create(CirclesApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }
}
