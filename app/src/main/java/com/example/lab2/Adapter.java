package com.example.lab2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<Contact> data;
    private LayoutInflater inflater;
    private Activity context;
    public void setData(ArrayList<Contact> data) {this.data = data;}
    public Adapter(ArrayList<Contact> data, Activity activity){
        this.data = data;
        this.context = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null)
            v = inflater.inflate(R.layout.infor,null);

        Contact itemValues= data.get(position);

        TextView txtName = v.findViewById(R.id.txtName);
        txtName.setText(itemValues.getUserName());
        TextView txtPhone = v.findViewById(R.id.txtPhone);
        txtPhone.setText(itemValues.getUserPhone());

        CheckBox cb = v.findViewById(R.id.ck_item);
        cb.setChecked(itemValues.isActive());

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setActive(cb.isChecked());
            }
        });
        return v;
    }
}
