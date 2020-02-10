package com.ta.pendaftaransiswa;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.RetrofitClient;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout daftar, cekHasil;
    LinearLayout profile, informasi;
    TextView txtNama;
    Context mContext;
    BaseApiService mApiService;
    Button logout;
    ProgressDialog loading;
    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        sharedPrefManager = new SharedPrefManager(this);
        initComponent();

        RetrofitClient.NAMA = sharedPrefManager.getSPNama();
        RetrofitClient.NISN = sharedPrefManager.getSpNisn();

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setLogo(R.drawable.ic_person_black_24dp);
        actionBar.setTitle(sharedPrefManager.getSPNama());
        actionBar.setDisplayUseLogoEnabled(true);
    }

    private void initComponent() {
        daftar = findViewById(R.id.daftar);
        cekHasil = findViewById(R.id.cekHasil);
        profile = findViewById(R.id.profile);
        informasi = findViewById(R.id.informasi);
        logout = findViewById(R.id.logout);

       // txtNama = findViewById(R.id.txtNama);
   //     txtNama.setText(sharedPrefManager.getSPNama());
        cekHasil.setOnClickListener(this);
        daftar.setOnClickListener(this);
        profile.setOnClickListener(this);
        informasi.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.daftar:
                startActivity(new Intent(getApplicationContext(), DataPendaftaranActivity.class));
                break;
            case  R.id.cekHasil:
                startActivity(new Intent(getApplicationContext(), CekHasilActivity.class));
                break;
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                break;
            case R.id.informasi:
                startActivity(new Intent(getApplicationContext(), InformasiActivity.class));
                break;
            case R.id.logout:
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                break;
        }
    }
}
