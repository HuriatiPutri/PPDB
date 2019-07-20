package com.ta.pendaftaransiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.RetrofitClient;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;
import com.ta.pendaftaransiswa.model.PesertaModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPendaftaranActivity extends AppCompatActivity {

    TextView nisn, nama, tahunLulus,tmpLahir, tglLahir, alamat, telepon, sekolahAsal, mtk, bindo, bing, avg, nmAyah, nmIbu, jurusan, jk;
    Button btnEdit;
    Context mContext;
    BaseApiService mApiService;

    ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pendaftaran);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponent();
        requestDataPeserta();

    }

    private void requestDataPeserta() {
//        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);

        BaseApiService service = mApiService;
        Call<PesertaModel> call = service.getData(RetrofitClient.NISN);
        call.enqueue(new Callback<PesertaModel>() {
            @Override
            public void onResponse(Call<PesertaModel> call, Response<PesertaModel> response) {
                if (response.code() == 200) {
                        nisn.setText(response.body().getNisn());
                        nama.setText(response.body().getNama());
                        tmpLahir.setText(response.body().getTmp_lahir());
                        tglLahir.setText(response.body().getTgl_lahir());
                        alamat.setText(response.body().getAlamat());
                        jk.setText(response.body().getJk());
                        nmAyah.setText(response.body().getNm_ayah());
                        telepon.setText(response.body().getTelepon());
                        nmIbu.setText(response.body().getNm_ibu());
                        tahunLulus.setText(response.body().getTahun_lulus());
                        sekolahAsal.setText(response.body().getsekolah_asal());
                        mtk.setText(response.body().getN_mtk() + "");
                        bindo.setText(response.body().getN_bindo() + "");
                        bing.setText(response.body().getN_bing() +"");
                        avg.setText(response.body().getAvg() +"");
                        jurusan.setText(response.body().getProgram());

                        btnEdit.setText("UBAH DATA");
//                           loading.dismiss();
                    }else{
                        Toast.makeText(mContext, "Kamu Belum Mendaftar, Silahkan Daftar Dulu ya..." + response.code(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(mContext, PendaftaranActivity.class));
                        finish();
                    }

            }

            @Override
            public void onFailure(Call<PesertaModel> call, Throwable t) {

            }
        });
    }

    private void initComponent() {
        nisn = findViewById(R.id.nisn);
        nama = findViewById(R.id.nama);
        tmpLahir = findViewById(R.id.tmpLahir);
        tglLahir = findViewById(R.id.tglLahir);
        alamat = findViewById(R.id.alamat);
        telepon = findViewById(R.id.telepon);
        sekolahAsal = findViewById(R.id.sekolahasal);
        tahunLulus = findViewById(R.id.tahunLulus);
        mtk = findViewById(R.id.nmtk);
        bindo = findViewById(R.id.nbindo);
        bing = findViewById(R.id.nbing);
        avg = findViewById(R.id.avg);
        nmAyah = findViewById(R.id.nmayah);
        nmIbu = findViewById(R.id.nmibu);
        jk = findViewById(R.id.jk);
        jurusan = findViewById(R.id.jurusan);

        btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UpdatePendaftarnActivity.class);
                intent.putExtra("nisn", nisn.getText().toString());
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("tmplahir", tmpLahir.getText().toString());
                intent.putExtra("tgllahir", tglLahir.getText().toString());
                intent.putExtra("jk", jk.getText().toString());
                intent.putExtra("alamat", alamat.getText().toString());
                intent.putExtra("asal_sekolah", sekolahAsal.getText().toString());
                intent.putExtra("telepon", telepon.getText().toString());
                intent.putExtra("nmtk", String.valueOf(mtk.getText().toString()));
                intent.putExtra("bindo", String.valueOf(bindo.getText().toString()));
                intent.putExtra("bing", String.valueOf(bing.getText().toString()));
                intent.putExtra("avg", String.valueOf(avg.getText().toString()));
                intent.putExtra("nmayah", nmAyah.getText().toString());
                intent.putExtra("nmibu", nmIbu.getText().toString());
                intent.putExtra("program", jurusan.getText().toString());
                intent.putExtra("tahun_lulus", tahunLulus.getText().toString());
                startActivity(intent);
            }
        });

    }


}
