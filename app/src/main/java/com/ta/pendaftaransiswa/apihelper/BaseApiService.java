package com.ta.pendaftaransiswa.apihelper;

import com.ta.pendaftaransiswa.model.PesertaModel;
import com.ta.pendaftaransiswa.model.UserModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("nisn") String nisn,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nisn") String nisn,
                                       @Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @FormUrlEncoded
    @POST("pendaftaranAdd")
    Call<ResponseBody> pendaftaranRequest(@Field("nisn") String nisn,
                                       @Field("nama") String nama,
                                          @Field("tmp_lahir") String tmp_lahir,
                                          @Field("tgl_lahir") String tgl_lahir,
                                          @Field("jk") String jk,
                                          @Field("alamat") String alamat,
                                          @Field("telepon") String telepon,
                                          @Field("sekolah_asal") String sekolah_asal,
                                          @Field("n_mtk") double n_mtk,
                                          @Field("n_bindo") double n_bindo,
                                          @Field("n_bing") double n_bing,
                                          @Field("avg") double avg,
                                          @Field("tahun_lulus") String tahun_lulus,
                                          @Field("nm_ayah") String nm_ayah,
                                          @Field("nm_ibu") String nm_ibu,
                                          @Field("program") String program
                                          );
    @FormUrlEncoded
    @POST("pendaftaranUpdate.php")
    Call<ResponseBody> pendaftaranUpRequest(@Field("nisn") String nisn,
                                          @Field("nama") String nama,
                                          @Field("tmp_lahir") String tmp_lahir,
                                          @Field("tgl_lahir") String tgl_lahir,
                                          @Field("jk") String jk,
                                          @Field("alamat") String alamat,
                                          @Field("telepon") String telepon,
                                          @Field("sekolah_asal") String sekolah_asal,
                                          @Field("n_mtk") double n_mtk,
                                          @Field("n_bindo") double n_bindo,
                                          @Field("n_bing") double n_bing,
                                          @Field("avg") double avg,
                                          @Field("tahun_lulus") String tahun_lulus,
                                          @Field("nm_ayah") String nm_ayah,
                                          @Field("nm_ibu") String nm_ibu,
                                          @Field("program") String program
    );
    @GET("semuapeserta")
    Call<List<PesertaModel>> requestPeserta();

    @GET("getPendaftaran.php")
    Call<PesertaModel> getData(@Query("nisn") String nisn);
}
