package com.example.mp3app.Service;

public class APIService {
    private static String url = "https://mp3-demo.herokuapp.com/api/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(url).create(DataService.class);
    }
}
