package com.ta.pendaftaransiswa;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.RetrofitClient;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        mContext = this;
        mApiService = UtilsApi.getAPIService();


        sharedPrefManager = new SharedPrefManager(this);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

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

        btnDaftar = findViewById(R.id.BtnDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                if (nama.getText().toString().equals("") ||
                        tmpLahir.getText().toString().equals("") ||
                        tglLahir.getText().toString().equals("")
                    //    || String.valueOf(rgJk.getText()).equals("")
                        || alamat.getText().toString().equals("")
                        || telepon.getText().toString().equals("")
                        || sekolahAsal.getText().toString().equals("")
                        || mtk.getText().toString().equals("")
                        || bindo.getText().toString().equals("")
                        || bing.getText().toString().equals("")
                        || avg.getText().toString().equals("")
                        || tahunLulus.getText().toString().equals("")
                        || nmAyah.getText().toString().equals("")
                        || nmIbu.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Semua Field Harus Diisi", Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }else{
                    requestPendaftaran();

                }
            }

        });
        avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nmtk = Integer.parseInt(mtk.getText().toString());
                int nbind = Integer.parseInt(bindo.getText().toString());
                int nbing = Integer.parseInt(bing.getText().toString());
                double rata = (nmtk+nbind+nbing)/3;
                avg.setText(String.valueOf(rata));
            }
        });
        tglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalender();
            }
        });



        nisn.setText(sharedPrefManager.getSpNisn());
        nama.setText(sharedPrefManager.getSPNama());
    }

    void showCalender() {
            /**
             * Calendar untuk mendapatkan tanggal sekarang
             */
            Calendar newCalendar = Calendar.getInstance();

            /**
             * Initiate DatePicker dialog
             */
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    /**
                     * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                     */

                    /**
                     * Set Calendar untuk menampung tanggal yang dipilih
                     */
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);

                    /**
                     * Update TextView dengan tanggal yang kita pilih
                     */
                    tglLahir.setText(dateFormatter.format(newDate.getTime()));
                }

            },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

            /**
             * Tampilkan DatePicker dialog
             */
            datePickerDialog.show();
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
                    rgJk.getText().toString(),
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
                            if (response.isSuccessful()) {
                                Log.i("debug", "onResponse: BERHASIL");
//                            loading.dismiss();
                                try {
                                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                    if (jsonRESULTS.getString("error").equals("false")) {
                                        Toast.makeText(mContext, "BERHASIL DAFTAR", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(mContext, DataPendaftaranActivity.class));
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
