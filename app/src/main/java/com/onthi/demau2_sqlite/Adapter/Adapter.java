package com.onthi.demau2_sqlite.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onthi.demau2_sqlite.Model.NhanVien;
import com.onthi.demau2_sqlite.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    private Activity activity;
    private ArrayList nv_id, tenNV, namsinhNV, quequanNV, trinhdoNV;

    public Adapter(Context context, Activity activity, ArrayList nv_id, ArrayList tenNV, ArrayList namsinhNV, ArrayList quequanNV, ArrayList trinhdoNV) {
        this.context = context;
        this.activity = activity;
        this.nv_id = nv_id;
        this.tenNV = tenNV;
        this.namsinhNV = namsinhNV;
        this.quequanNV = quequanNV;
        this.trinhdoNV = trinhdoNV;
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
        holder.nv_id.setText(String.valueOf(nv_id.get(position)));
        holder.tenNV.setText(String.valueOf(tenNV.get(position)));
        holder.namsinhNV.setText(String.valueOf(namsinhNV.get(position)));
        holder.quequanNV.setText(String.valueOf(quequanNV.get(position)));
        holder.trinhdoNV.setText(String.valueOf(trinhdoNV.get(position)));

    }

    @Override
    public int getItemCount() {
        return nv_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nv_id, tenNV, namsinhNV, quequanNV, trinhdoNV;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nv_id = itemView.findViewById(R.id.id_txt);
            tenNV = itemView.findViewById(R.id.name_txt);
            namsinhNV = itemView.findViewById(R.id.namsinh_txt);
            quequanNV = itemView.findViewById(R.id.quaQuan_txt);
            trinhdoNV = itemView.findViewById(R.id.trinhdo_txt);


        }
    }
}
