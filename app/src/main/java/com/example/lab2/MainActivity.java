package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contactList;
    private ListView listView;
    private Adapter adapter;
    private EditText inputName;
    private Button addButton, deleteButton;
    private int SelectedItemId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputName = findViewById(R.id.etHoten_main);
        addButton = findViewById(R.id.btnThem);
        deleteButton = findViewById(R.id.btnXoa);
        listView = findViewById(R.id.list_item);

       // listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Create a list of Contact objects
        contactList = new ArrayList<>();
        contactList.add(new Contact(1, "Mot", "123", false));
        contactList.add(new Contact(2, "Hai", "456", false));
        contactList.add(new Contact(3, "Ba", "789", false));
        // Add more contacts as needed

        // Create the adapter and set it to the ListView
        adapter = new Adapter(contactList, this);
        listView.setAdapter(adapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openintent = new Intent(MainActivity.this, GetInfor.class);
                startActivityForResult(openintent, 100);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("do you want delete this item");
                builder.setMessage("delete");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < contactList.size(); i++) {
                            if(contactList.get(i).isActive()) contactList.remove(i);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("no", null);
                builder.create().show();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //nhan intent
        //lay bundle ra khoi intent
        Bundle reveiceBundle = data.getExtras();
        //lay du lieu ra khoi bundle
        int id = reveiceBundle.getInt("Id");
        String name = reveiceBundle.getString("Name");
        String phone = reveiceBundle.getString("Phone");
        boolean status = reveiceBundle.getBoolean("Status");

        Contact newContact= new Contact(id,name, phone, status);

        if(requestCode==100 && resultCode==150){
            contactList.add(newContact);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.SbName){
            Toast.makeText(this,"Sort by name", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.SbPhone) {

        } else if (item.getItemId() == R.id.Bd) {
            Intent intent = new Intent("com.example.lab2.SOME_ACTION");
            sendBroadcast(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.layout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        return super.onContextItemSelected(item);
    }
}