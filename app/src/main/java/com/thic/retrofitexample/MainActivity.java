package com.thic.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private KisilerDaoInterface kisilerDIF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kisilerDIF = ApiUtils.getkisilerDaoInterface();
        getKisiler();
    }
    public void getKisiler(){
        kisilerDIF.tumkisiler().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> kisilerList = response.body().getKisiler();

                for (Kisiler k:kisilerList){
                    Log.d("*********","***********");
                    Log.d("kisiID", k.getKisiId());
                    Log.d("kisiAdı", k.getKisiAd());
                    Log.d("kisiTel", k.getKisiTel());
                    Log.d("*********","***********");
                }
            }
            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }
}