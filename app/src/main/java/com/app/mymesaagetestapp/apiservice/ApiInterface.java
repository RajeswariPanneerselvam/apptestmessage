package com.app.mymesaagetestapp.apiservice;

import com.app.mymesaagetestapp.MessageModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @GET("jsonmobile.asmx/Alerts?StudID=STUG115310009&&MacID=")
    Call<String> getMessageList();
}

