package com.ta.pendaftaransiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.RetrofitClient;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;
import com.ta.pendaftaransiswa.model.HasilModel;
import com.ta.pendaftaransiswa.model.PesertaModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CekHasilActivity extends AppCompatActivity {

    EditText noPendaftaran, namaPendaftar;
    Button btnHasil;
    CardView cvHasil;

    TextView noPend, nisn, nama, status, keterangan;

    Context mContext;
    BaseApiService mApiService;
    ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_hasil);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponent();
    }

    private void initComponent() {
        noPendaftaran = findViewById(R.id.noPendaftaran);
        namaPendaftar = findViewById(R.id.namaPendaftar);
        btnHasil = findViewById(R.id.btnHasil);
        cvHasil = findViewById(R.id.cardHasil);

        noPend =findViewById(R.id.txtNo);
        nisn = findViewById(R.id.txtNisn);
        nama = findViewById(R.id.txtNama);
        status = findViewById(R.id.txtStatus);
        keterangan = findViewById(R.id.txtKeternagan);


        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                String  no = noPendaftaran.getText().toString();
                String  nama = namaPendaftar.getText().toString();
                getHasil(no,nama);
            }
        });
    }

    private void getHasil(String noPendaftaran, String namaPendaftar) {
       mApiService.getHasil(noPendaftaran, namaPendaftar).enqueue(new Callback<PesertaModel>() {
            @Override
            public void onResponse(Call<PesertaModel> call, Response<PesertaModel> response) {
                if (response.body().getError().equals("false")) {
                    loading.dismiss();
                    cvHasil.setVisibility(View.VISIBLE);
                    noPend.setText(response.body().getNo_pendaftaran());
                    nama.setText(response.body().getNama());
                    nisn.setText(response.body().getNisn());
                    keterangan.setText(response.body().getKeterangan());
                    if(response.body().getStatus() == 1) {
                        status.setText("Lulus");
                        status.setBackground(getResources().getDrawable(R.drawable.bglulus));
                    }else if(response.body().getStatus()== 2) {
                        status.setText("Tidak Lulus");
                        status.setBackground(getResources().getDrawable(R.drawable.bgtidaklulus));
                    }else if(response.body().getStatus() == 0){
                        status.setText("Menunggu Konfirmasi");
                        status.setBackground(getResources().getDrawable(R.drawable.bgmenunggu));
                    }

                }else{
                    Toast.makeText(mContext, "Tidak Ditemukan", Toast.LENGTH_LONG).show();
                    cvHasil.setVisibility(View.GONE);
                    loading.dismiss();
                }

            }

            @Override
            public void onFailure(Call<PesertaModel> call, Throwable t) {

            }
        });
    }
}
