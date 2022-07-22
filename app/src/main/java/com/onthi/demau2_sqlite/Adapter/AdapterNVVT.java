package com.onthi.demau2_sqlite.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onthi.demau2_sqlite.R;

import java.util.ArrayList;

public class AdapterNVVT extends RecyclerView.Adapter<AdapterNVVT.MyViewHolder> {
    Context context;
    private Activity activity;
    private ArrayList nvvt_id, idNV, idVT, tgian, mta;

    public AdapterNVVT(Context context, Activity activity, ArrayList nvvt_id, ArrayList idNV, ArrayList idVT, ArrayList tgian, ArrayList mta) {
        this.context = context;
        this.activity = activity;
        this.nvvt_id = nvvt_id;
        this.idNV = idNV;
        this.idVT = idVT;
        this.tgian = tgian;
        this.mta = mta;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_listview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nvvt_id.setText(String.valueOf(nvvt_id.get(position)));
        holder.idNV.setText(String.valueOf(idNV.get(position)));
        holder.idVT.setText(String.valueOf(idVT.get(position)));
        holder.tgian.setText(String.valueOf(tgian.get(position)));
        holder.mta.setText(String.valueOf(mta.get(position)));

    }

    @Override
    public int getItemCount() {
        return nvvt_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nvvt_id, idNV, idVT, tgian, mta;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nvvt_id = itemView.findViewById(R.id.id_txt);
            idNV = itemView.findViewById(R.id.name_txt);
            idVT = itemView.findViewById(R.id.namsinh_txt);
            tgian = itemView.findViewById(R.id.quaQuan_txt);
            mta = itemView.findViewById(R.id.trinhdo_txt);

        }
    }
}
