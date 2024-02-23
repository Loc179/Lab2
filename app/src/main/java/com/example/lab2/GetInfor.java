package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class GetInfor extends AppCompatActivity {

    protected EditText get_Name;
    protected EditText get_Phone;
    protected EditText get_ID;

    protected CheckBox is_Status;

    protected Button btnAdd;

    protected ArrayList<Contact> data;

    protected MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_infor);

        get_ID= findViewById(R.id.etID);
        get_Name= findViewById(R.id.etName);
        get_Phone= findViewById(R.id.etPhone);
        is_Status = findViewById(R.id.ck_status);
        btnAdd= findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //lay du lieu cho main activity
                    int id = Integer.parseInt(get_ID.getText().toString());
                    String name = get_Name.getText().toString();
                    String phone = get_Phone.getText().toString();
                    boolean status = is_Status.isChecked();

                    //kiem tra xem cac truong hop co rong khong

                    if (name.isEmpty() || phone.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "du lieu chua du", Toast.LENGTH_SHORT).show();
                    } else {

                        //khai bao intent
                        Intent intent = new Intent();
                        //dong goi du lieu vao bundle
                        Bundle b = new Bundle();
                        b.putInt("Id", id);
                        b.putString("Name", name);
                        b.putString("Phone", phone);
                        b.putBoolean("Status", status);
                        //dua bundle vao intent
                        //intent.putExtra("additem", b);
                        intent.putExtras(b);
                        //khoi dong
                        setResult(150, intent);
                        finish();

                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "du lieu bi sai kieu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}