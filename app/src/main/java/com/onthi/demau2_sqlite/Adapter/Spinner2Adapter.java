package com.onthi.demau2_sqlite.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.onthi.demau2_sqlite.Model.NhanVien;
import com.onthi.demau2_sqlite.Model.ViTri;
import com.onthi.demau2_sqlite.R;

import java.util.List;

public class Spinner2Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ViTri> viTris;
    private int textViewItemNameID;
    private int textViewItemID;
    private int listItemLayoutResource;

    public Spinner2Adapter(@NonNull Activity context, List<ViTri> viTris, int textViewItemNameID, int textViewItemID, int listItemLayoutResource) {
        this.inflater = context.getLayoutInflater();
        this.viTris = viTris;
        this.textViewItemNameID = textViewItemNameID;
        this.textViewItemID = textViewItemID;
        this.listItemLayoutResource = listItemLayoutResource;
    }

    @Override
    public int getCount() {
        if (this.viTris == null)
            return 0;
        return this.viTris.size();
    }

    @Override
    public Object getItem(int i) {
        return this.viTris.get(i);
    }

    @Override
    public long getItemId(int i) {
        ViTri viTri = (ViTri) this.getItem(i);
        return viTri.getMaVT();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViTri viTri = (ViTri) getItem(i);
        View rowView = this.inflater.inflate(R.layout.spinner_mode, null, true);
        TextView textViewItemName = (TextView) rowView.findViewById(R.id.item_name);
        textViewItemName.setText(viTri.getTenVT());
        TextView textViewItemID = (TextView) rowView.findViewById(R.id.item_id);
        textViewItemID.setText(Integer.toString(viTri.getMaVT()));
        return rowView;
    }
}
