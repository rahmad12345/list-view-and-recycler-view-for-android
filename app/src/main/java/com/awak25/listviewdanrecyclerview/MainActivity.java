package com.awak25.listviewdanrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvBuah;
    private String[] dataBuah ={"Alpukat","Apel","Ceri","Mangga","Jeruk","Durian","Anggut","Rambutan","Melon",
                                "Salak","Pir","Lengkeng","Naga"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBuah = findViewById(R.id.lv_buah);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataBuah);

        lvBuah.setAdapter(adapter);
        lvBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dataBuah[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
