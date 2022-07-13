package com.example.takeyourmeds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_NewMedMain, btn_ListData;
    private String str_MedName;
    private MedicineDAO mdao;
    private Medicine medicine = null;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_NewMedMain = findViewById(R.id.btn_NewMedMain);
        btn_ListData = findViewById(R.id.btn_ListData);

        btn_NewMedMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlog_NewMedMain = new AlertDialog.Builder(MainActivity.this);
                dlog_NewMedMain.setTitle("New Medicine");

                final EditText medInput = new EditText(MainActivity.this);
                medInput.setInputType(InputType.TYPE_CLASS_TEXT);
                dlog_NewMedMain.setView(medInput);

                dlog_NewMedMain.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str_MedName = medInput.getText().toString();
                        Toast.makeText(MainActivity.this, "Medicine's name is: "+str_MedName, Toast.LENGTH_LONG).show();
                        medSave();
                    }
                });

                dlog_NewMedMain.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dlog_NewMedMain.show();

            }
        });

        btn_ListData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListMedActvt();
               // Toast.makeText(MainActivity.this, "clicked list", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuit_language:
                Toast.makeText(this, "Clicked Language", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuit_theme:
                Toast.makeText(this, "Clicked Theme", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuit_about:
                Toast.makeText(this, "Clicked About", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public  void medSave(){
        mdao = new MedicineDAO(this);
        medicine = new Medicine();
        medicine.setMedName(str_MedName);

        long id = mdao.med_Create(medicine);
        Toast.makeText(this, "Saved with ID: "+id, Toast.LENGTH_SHORT).show();
    }

    public void openListMedActvt(){
        Intent i = new Intent(this,ListMedicines.class);
        startActivity(i);
    }


}