package com.awak25.listviewdanrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListView2Activity extends AppCompatActivity {

    private ListView lvKota;
    private String[] dataKota = {"Lhoksumawe","Medan","Padang","Pekanbaru","Jambi","Bengkulu","Palembang","Jakarta","Bandung","Semarang","Surabaya"};
    private String[] deskripsi = {"Ibukota Aceh","Ibukota Sumatera Utara","Ibukota Sumatera Barat","Ibukota Riau","Ibukota Jambi","Ibukota Bengkulu","Ibukota Sumatera Selatan","Ibukota DKI Jakarta","Ibukota Jawa Barat","Ibukota Jawa Tengah","Ibukota Jawa Timur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        lvKota = findViewById(R.id.lv_view2);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1,dataKota){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View tampil2 = super.getView(position, convertView, parent);

                TextView tv2 = tampil2.findViewById(android.R.id.text2);
                tv2.setText(deskripsi[position]);
                return tampil2;
            }
        };
        lvKota.setAdapter(adapter2);
        lvKota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView2Activity.this, dataKota[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
