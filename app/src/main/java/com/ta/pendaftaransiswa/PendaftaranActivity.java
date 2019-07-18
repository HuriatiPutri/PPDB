package com.ta.pendaftaransiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranActivity extends AppCompatActivity {

    EditText nisn, nama, tahunLulus,tmpLahir, tglLahir, alamat, telepon, sekolahAsal, mtk, bindo, bing, avg, nmAyah, nmIbu, jurusan;
    RadioGroup rgJk_, rgProgram_;
    RadioButton rgJk, rgProgram;
    Button btnDaftar;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponent();
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

        rgJk_ = findViewById(R.id.rgJk);
        rgProgram_ = findViewById(R.id.rgProgram);
//        rbLk = findViewById(R.id.rbLk);
//        rbPr = findViewById(R.id.rbPr);
        btnDaftar = findViewById(R.id.BtnDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestPendaftaran();
            }

        });

        nisn.setText(HomeActivity.NISN);
        nama.setText(HomeActivity.NAMA);
    }

    private void requestPendaftaran() {
        int id = rgJk_.getCheckedRadioButtonId();
        rgJk = findViewById(id);

        int idProgram = rgProgram_.getCheckedRadioButtonId();
        rgProgram = findViewById(idProgram);

        mApiService.pendaftaranRequest(nisn.getText().toString(),
                nama.getText().toString(),
                tmpLahir.getText().toString(),
                tglLahir.getText().toString(),
                String.valueOf(rgJk.getText()),
                alamat.getText().toString(),
                telepon.getText().toString(),
                sekolahAsal.getText().toString(),
                Double.parseDouble(mtk.getText().toString()),
                Double.parseDouble(bindo.getText().toString()),
                Double.parseDouble(bing.getText().toString()),
                Double.parseDouble(avg.getText().toString()),
                tahunLulus.getText().toString(),
                nmAyah.getText().toString(),
                nmIbu.getText().toString(),
                rgProgram.getText().toString()
                )
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
//                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "BERHASIL DAFTAR", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, HomeActivity.class));
                                    finish();
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
