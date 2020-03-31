package com.awak25.listviewdanrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv;
    private String[] namaBuah = {"Alpukat","Apel","Ceri","Durian","Jambu Air","Manggis","Strawberry"};
    private int[] gambarBuah = {
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
    };
    private int[] suaraBuah ={
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambu_air,
            R.raw.manggis,
            R.raw.strawberry
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rv = findViewById(R.id.rv_buah);

        BuahAdapter adapterBuah = new BuahAdapter(namaBuah,gambarBuah,suaraBuah);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapterBuah);
    }
}
