package com.basicappstructure.connection;


import com.basicappstructure.model.Login;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIClass {

    private static APIClass mInstance = null;

    public static APIClass getInstance() {
        if (mInstance == null)
            return new APIClass();
        else
            return mInstance;
    }


    public void callLoginApi(JsonObject params, final InterActorCallback<Login> callback) {

        callback.onStart();

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), params.toString());

        RestClient.getService().apiPost(ApiRequestUrl.LOGIN, body).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (isSuccess(response.code()).equalsIgnoreCase(ApiParamConstant.SUCCESS)) {
                    callback.onResponse(new Gson().fromJson(response.body(), Login.class));
                } else {
                    callback.onError(isSuccess(response.code()));
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });


    }


    private String isSuccess(int response) {
        // error case
        switch (response) {
            case 200:
                return ApiParamConstant.SUCCESS;

            case 404:
                return "not found";

            case 500:
                return "server broken";

            case 204:
                return "No content found";

            default:
                return "unknown error";
        }

    }


}