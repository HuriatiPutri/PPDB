package com.ta.pendaftaransiswa.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ta.pendaftaransiswa.R;
import com.ta.pendaftaransiswa.model.PesertaModel;

import java.util.List;

public class PesertaAdapter extends RecyclerView.Adapter<PesertaAdapter.PesertaHolder> {

    private Context context;
    private List<PesertaModel> list;

    public PesertaAdapter(Context context, List<PesertaModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PesertaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peserta, parent, false);
        return new PesertaHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull PesertaHolder holder, int position) {
        holder.nama.setText(list.get(position).getNisn());
        holder.nisn.setText(list.get(position).getNama());
        holder.asal.setText(list.get(position).getSekolah_asal());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class PesertaHolder extends RecyclerView.ViewHolder{

        TextView nisn,nama, asal;
        public PesertaHolder(View itemView) {
            super(itemView);
            nisn = itemView.findViewById(R.id.nisn);
            nama = itemView.findViewById(R.id.nama);
            asal = itemView.findViewById(R.id.asal);
        }
    }
}
