package com.ta.pendaftaransiswa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ta.pendaftaransiswa.adapter.PesertaAdapter;
import com.ta.pendaftaransiswa.apihelper.BaseApiService;
import com.ta.pendaftaransiswa.apihelper.RetrofitClient;
import com.ta.pendaftaransiswa.apihelper.UtilsApi;
import com.ta.pendaftaransiswa.model.PesertaModel;
import com.ta.pendaftaransiswa.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalonPesertaActivity extends AppCompatActivity {

    RecyclerView rcPeserta;
    PesertaAdapter adapter;
    private ArrayList<PesertaModel> pesertaModels = new ArrayList<>();

    Context mContext;
    BaseApiService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calon_peserta);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponent();

    }

    private void initComponent() {
        rcPeserta = findViewById(R.id.rcPeserta);
        rcPeserta.setHasFixedSize(true);
        rcPeserta.setLayoutManager(new LinearLayoutManager(this));

        listPeserta();
    }

    public void listPeserta() {
        BaseApiService service = mApiService;
        Call<List<PesertaModel>> call = service.requestPeserta();
        call.enqueue(new Callback<List<PesertaModel>>() {
            @Override
            public void onResponse(Call<List<PesertaModel>> call, Response<List<PesertaModel>> response) {
                if(response.isSuccessful()){
                    int jumlah =  response.body().size();
                    for(int i=0; i<jumlah;i++){
                        PesertaModel data = new PesertaModel(
                                response.body().get(i).getNisn(),
                                response.body().get(i).getNama(),
                                response.body().get(i).getSekolah_asal()
                        );
                        pesertaModels.add(data);
                    }
                    adapter = new PesertaAdapter(mContext, pesertaModels);
                    rcPeserta.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<PesertaModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Tidak Ada Koneksi Internet "+ t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
