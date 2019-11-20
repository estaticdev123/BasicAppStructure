package com.basicappstructure.connection;

public class ApiRequestUrl {


    public static String LOGIN = "api/Login";



    private String value;

    public ApiRequestUrl(String value) {
        this.value = ApiParamConstant.BASE_URL + value;
    }

    public String getValue() {
        return value;
    }
}