package com.ta.pendaftaransiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;
import com.ta.pendaftaransiswa.model.ProfileModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    TextView npsn, nama, alamat, kodepos, desa, kecamatan, kabupaten, prov;
    Context mContext;
    BaseApiService mApiService;

    ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponent();
        getProfile();
    }

    private void getProfile() {
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);

        mApiService.getProfile().enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                npsn.setText(response.body().getNpsn());
                nama.setText(response.body().getNama_sekolah());
                alamat.setText(response.body().getAlamat());
                kodepos.setText(response.body().getKodepos());
                desa.setText(response.body().getDesa());
                kecamatan.setText(response.body().getKecamatan());
                kabupaten.setText(response.body().getKabupaten_kota());
                prov.setText(response.body().getProvinsi());
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                loading.dismiss();
            }
        });
    }

    private void initComponent() {
        npsn = findViewById(R.id.txtNpsn);
        nama = findViewById(R.id.txtNamaSekolah);
        alamat = findViewById(R.id.txtAlamat);
        kodepos = findViewById(R.id.txtKodepos);
        desa = findViewById(R.id.txtdesa);
        kecamatan = findViewById(R.id.txtKec);
        kabupaten = findViewById(R.id.txtKab);
        prov = findViewById(R.id.txtprov);
    }
}
