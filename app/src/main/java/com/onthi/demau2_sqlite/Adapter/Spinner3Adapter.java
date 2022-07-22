package com.onthi.demau2_sqlite.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.onthi.demau2_sqlite.Model.NhanVien;
import com.onthi.demau2_sqlite.R;

import java.util.List;

public class Spinner3Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<NhanVien> nhanViens;
    private int textViewItemNameID;
    private int textViewItemID;
    private int listItemLayoutResource;

    public Spinner3Adapter(@NonNull Activity context, List<NhanVien> nhanViens, int textViewItemNameID, int textViewItemID, int listItemLayoutResource) {
        this.inflater = context.getLayoutInflater();
        this.nhanViens = nhanViens;
        this.textViewItemNameID = textViewItemNameID;
        this.textViewItemID = textViewItemID;
        this.listItemLayoutResource = listItemLayoutResource;
    }



    @Override
    public int getCount() {
        if (this.nhanViens == null)
            return 0;
        return this.nhanViens.size();
    }

    @Override
    public Object getItem(int i) {
        return this.nhanViens.get(i);
    }

    @Override
    public long getItemId(int i) {
        NhanVien nhanVien = (NhanVien) this.getItem(i);
        return nhanVien.getMaNV();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NhanVien nhanVien = (NhanVien) getItem(i);
        View rowView = this.inflater.inflate(R.layout.spinner_mode2, null, true);
        TextView textViewItemName = (TextView) rowView.findViewById(R.id.item_name);
        textViewItemName.setText(nhanVien.getNamsinh() + "");
        TextView textViewItemID = (TextView) rowView.findViewById(R.id.item_id);
        textViewItemID.setText(Integer.toString(nhanVien.getMaNV()));
        return rowView;
    }
}
