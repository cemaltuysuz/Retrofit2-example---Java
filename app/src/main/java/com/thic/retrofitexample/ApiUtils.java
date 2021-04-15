package com.thic.retrofitexample;

public class ApiUtils {

    public static final String base_url = "http://kasimadalan.pe.hu/";

    public static KisilerDaoInterface getkisilerDaoInterface(){
        return RetrofitClient.getClient(base_url).create(KisilerDaoInterface.class);
    }
}
