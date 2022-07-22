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

public class AdapterVT extends RecyclerView.Adapter<AdapterVT.MyViewHolder> {
    Context context;
    private Activity activity;
    private ArrayList vt_id, tenVT, motaVT;

    public AdapterVT(Context context, Activity activity, ArrayList vt_id, ArrayList tenVT, ArrayList motaVT) {
        this.context = context;
        this.activity = activity;
        this.vt_id = vt_id;
        this.tenVT = tenVT;
        this.motaVT = motaVT;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_listview_vtri, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.vt_id.setText(String.valueOf(vt_id.get(position)));
        holder.tenVT.setText(String.valueOf(tenVT.get(position)));
        holder.motaVT.setText(String.valueOf(motaVT.get(position)));
    }

    @Override
    public int getItemCount() {
        return vt_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vt_id, tenVT, motaVT;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vt_id = itemView.findViewById(R.id.idvt_txt);
            tenVT = itemView.findViewById(R.id.tenvt_txt);
            motaVT = itemView.findViewById(R.id.mota_txt);

        }
    }
}
