package com.basicappstructure.connection;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RestService {
    @FormUrlEncoded
    @POST
    Call<String> apiPost(@Url String url, @FieldMap HashMap<String, String> params);


    @FormUrlEncoded
    @POST
    Call<String> apiPostJson(@Url String url, @Body HashMap<String, String> body);


    @POST
    Call<String> apiPost(@Url String url, @Body RequestBody responseBody);


    @GET
    Call<String> apiGet(@Url String url, @QueryMap HashMap<String, String> options);


    @GET
    Call<String> apiGet(@Url String url);


    @POST
    Call<String> apiPostQuery(@Url String url, @QueryMap HashMap<String, String> options);


    @Multipart
    @POST
    Call<String> apiMultipartPost(@Url String url, @PartMap HashMap<String, RequestBody> params, @Part MultipartBody.Part body);



    @Multipart
    @POST
    Call<String> apiMultipartPost(@Url String url, @PartMap HashMap<String, RequestBody> params, @Part MultipartBody.Part body, @Part MultipartBody.Part body1);


    @Multipart
    @POST
    Call<String> apiMultipartPost(@Url String url, @PartMap HashMap<String, RequestBody> params);


    @Streaming
    @GET
    Call<ResponseBody> downloadData(@Url String fileUrl);


    @GET
    Call<String> apiGetPost(@Url String url);
}