package com.example.morningroutine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;





import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements Dialog.DialogListener {
    public Button addButton;
    public Button removeButton;
    public ArrayList<String> addArray= new ArrayList<String>();


    ListView listViewShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton = (Button) findViewById(R.id.addRoutineButton);
        removeButton = (Button) findViewById(R.id.removeRoutineButton);
        listViewShow = (ListView) findViewById(R.id.listView);
        addButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             openDialog();
                                         }
                                     }
        );
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addArray.isEmpty() == false) {
                    addArray.remove(0);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addArray);
                    listViewShow.setAdapter(adapter);
                }

            }
        });
    }


    public void openDialog(){
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }





    @Override
    public void applyText(String routine) {
        addArray.add(routine);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addArray);
        listViewShow.setAdapter(adapter);

    }
}