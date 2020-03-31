package com.awak25.listviewdanrecyclerview;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.ViewHolderBuah> {

    String[] namaBuah;
    int[] gambarBuah;
    int[] suaraBuah;

    public BuahAdapter(String[]namaBuah, int[]gambarBuah, int[]suaraBuah){
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.suaraBuah = suaraBuah;
    }

    @NonNull
    @Override
    public BuahAdapter.ViewHolderBuah onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buah,parent,false);
        return new ViewHolderBuah(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.ViewHolderBuah holder, final int position) {
        holder.imgBuah.setImageResource(gambarBuah[position]);
        holder.tvBuah.setText(namaBuah[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), namaBuah[position], Toast.LENGTH_SHORT).show();
                putarMusik(suaraBuah[position],v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namaBuah.length;
    }

    public class ViewHolderBuah extends RecyclerView.ViewHolder {

        private ImageView imgBuah;
        private TextView tvBuah;

        public ViewHolderBuah(@NonNull View itemView) {
            super(itemView);

            imgBuah = itemView.findViewById(R.id.img_buah);
            tvBuah = itemView.findViewById(R.id.tv_buah);

        }
    }

    public void putarMusik(int suaraBuah, View v){

        MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri uri = Uri.parse("android.resource://"+getClass().getPackage().getName()+"/"+suaraBuah);

        try {
            player.setDataSource(v.getContext(),uri);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
