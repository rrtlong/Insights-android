package com.imalljoy.insights.data.http;

import com.imalljoy.insights.entity.HttpResult;
import com.imalljoy.insights.entity.Subject;
import com.imalljoy.insights.entity.UserEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lijilong on 03/06.
 */

public interface ApiService {
    @GET("/student/mobileRegister")
    Observable<HttpResult<UserEntity>> login(@Query("phone") String phone, @Query("password") String psw);


    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("top250")
    Observable<HttpResult<Subject>> getUser( @Query("touken") String touken);
}
