package com.meanHun.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.meanHun.R;
import com.meanHun.model.Song;

import java.util.List;

public class AdapterList extends ArrayAdapter<Song> {
    Activity context;
    int resource;
    @NonNull
    List<Song> objects;
    public AdapterList(@NonNull Activity context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource,null);

        TextView _idSong = row.findViewById(R.id.id_Song);
        TextView _nameSong = row.findViewById(R.id.txt_nameSong);
        TextView _theloai = row.findViewById(R.id.txt_theloai);
        TextView _nameSinger = row.findViewById(R.id.txt_nameSinger);

        ImageButton img_love = row.findViewById(R.id.imgLove);
        ImageButton img_profile = row.findViewById(R.id.imgProfile);

        Song song = this.objects.get(position);

        _idSong.setText(song.getidSong());
        _nameSong.setText(song.getName_Song());
        _theloai.setText("Thể loại:"+song.getSince());
        _nameSinger.setText("Ca sĩ: "+song.getName_Singer());
        //Kiểm tra đã like hay chưa
        if(song.isState()){
            img_love.setImageResource(R.drawable.ic_heart2);
        }else {
            img_love.setImageResource(R.drawable.ic_heart);
        }

        //Button like
        img_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (song.isState()){
                    song.setState(false);
                    img_love.setImageResource(R.drawable.ic_heart);
                }else{
                    song.setState(true);
                    img_love.setImageResource(R.drawable.ic_heart2);
                }
            }
        });
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Chúng tôi chưa hoàn thiện tính năng này", Toast.LENGTH_SHORT).show();
            }
        });
        return row;

    }
}
