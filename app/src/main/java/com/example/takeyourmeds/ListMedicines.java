package com.example.takeyourmeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListMedicines extends AppCompatActivity {

    private ListView listView;
    private MedicineDAO mdao;
    private List<Medicine> medicines_list;
    private List<Medicine> medicines_filtered = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_medicines);

        listView = findViewById(R.id.list_medicines);
        mdao = new MedicineDAO(this);
        medicines_list = mdao.getAllMeds();
        medicines_filtered.addAll(medicines_list);
        ArrayAdapter<Medicine> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicines_filtered);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }
}