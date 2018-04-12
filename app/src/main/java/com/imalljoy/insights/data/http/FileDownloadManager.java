package com.imalljoy.insights.data.http;

import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by lijilong on 04/11.
 */

public class FileDownloadManager {
    private static final String TAG = "FileDownloadManager";

    public static void startDownloadFile(String fileUrl) {
        if(fileUrl == null)
            return;
        if(!fileUrl.endsWith("/"))
            fileUrl = fileUrl + "/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fileUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.downloadFile("");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e(TAG, "下载完成");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "下载失败");
            }
        });
    }
}
