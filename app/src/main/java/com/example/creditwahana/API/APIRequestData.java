package com.example.creditwahana.API;

import com.example.creditwahana.Model.Login.Login;
import com.example.creditwahana.Model.ResponeModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponeModel> ardRetrievedata(
            @Query("id_cust") String id_cust,
            @Query("nik") String nik,
            @Query("nama") String nama,
            @Query("tpt_lahir") String tpt_lahir,
            @Query("tgl_lahir") String tgl_lahir,
            @Query("alamat") String alamat,
            @Query("nm_ibu") String nm_ibu,
            @Query("telp1") String telp1,
            @Query("telp2") String telp2,
            @Query("stat_nikah") String stat_nikah,
            @Query("tanggungan") String tanggungan,
            @Query("stat_tinggal") String stat_tinggal,
            @Query("pekerjaan") String pekerjaan,
            @Query("type_motor") String type_motor,
            @Query("warna") String warna,
            @Query("harga") String harga,
            @Query("dp") String dp,
            @Query("tenor") String tenor,
            @Query("angsuran") String angsuran,
            @Query("nm_stnk") String nm_stnk,
            @Query("sales") String sales,
            @Query("stat_kredit") String stat_kredit
    );
    @GET("user.php")
    Call<ResponeModel> ardUserData(
            @Query("id_user") String id_user,
            @Query("username") String username,
            @Query("name") String name,
            @Query("password") String password,
            @Query("jabatan") String jabatan
    );

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponeModel> ardCreatedata(
            @Field("nik") String nik,
            @Field("nama") String nama,
            @Field("tpt_lahir") String tpt_lahir,
            @Field("tgl_lahir") String tgl_lahir,
            @Field("alamat") String alamat,
            @Field("nm_ibu") String nm_ibu,
            @Field("telp1") String telp1,
            @Field("telp2") String telp2,
            @Field("stat_nikah") String stat_nikah,
            @Field("tanggungan") String tanggungan,
            @Field("stat_tinggal") String stat_tinggal,
            @Field("pekerjaan") String pekerjaan,
            @Field("type_motor") String type_motor,
            @Field("warna") String warna,
            @Field("harga") String harga,
            @Field("dp") String dp,
            @Field("tenor") String tenor,
            @Field("angsuran") String angsuran,
            @Field("nm_stnk") String nm_stnk,
            @Field("sales") String sales,
            @Field("stat_kredit") String stat_kredit
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponeModel> editData(
            @Field("id_cust") String id_cust,
            @Field("stat_kredit") String stat_kredit
    );
    
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponeModel> hapusData(
            @Field("id_cust") String id_cust
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<Login> LoginResponse(
      @Field("username") String username,
      @Field("password") String password
    );
}
