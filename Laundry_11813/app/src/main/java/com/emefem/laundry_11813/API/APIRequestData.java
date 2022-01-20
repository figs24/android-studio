package com.emefem.laundry_11813.API;

import com.emefem.laundry_11813.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();
    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("nohp") String nohp,
            @Field("kota") String kota
    );
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("get.php")
    Call<ResponseModel> ardUpdateData(
            @Field("id") int id
    );
    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUbahData(
            @Field("id") int id,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("nohp") String nohp,
            @Field("kota") String kota
    );
}
