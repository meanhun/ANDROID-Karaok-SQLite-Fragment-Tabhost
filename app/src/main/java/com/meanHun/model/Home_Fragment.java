package com.meanHun.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.meanHun.R;
import com.meanHun.adapter.AdapterList;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    ArrayList<Song> dsSong = new ArrayList<>();
    ArrayList<Song> dsSong2 = new ArrayList<>();
    AdapterList adapterList;
    ListView lv_item,lv_dsfavorite;
    TabHost tabHost ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        lv_item = view.findViewById(R.id.ds_item);
        lv_dsfavorite = view.findViewById(R.id.lv_dsfavorite);
        tabHost = view.findViewById(R.id.tabhostt);
        tabHost.setup();
        TabHost.TabSpec tabSpec;
        //tao tab1
        tabSpec = tabHost.newTabSpec("t1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Danh sách bài hát");
        tabHost.addTab(tabSpec);
        //tao tab2
        TabHost.TabSpec tabSpec1;
        tabSpec1 = tabHost.newTabSpec("t2");
        tabSpec1.setContent(R.id.tab2);
        tabSpec1.setIndicator("DS bài hát yêu thích");
        tabHost.addTab(tabSpec1);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (s.equalsIgnoreCase("t1")){
                    lv_item.deferNotifyDataSetChanged();
                }else if (s.equalsIgnoreCase("t2")){
                    dsSong2.clear();
                    for (Song ds_pet:dsSong) {
                        if (ds_pet.isState()){
                            dsSong2.add(ds_pet);
                        }
                    }
                    adapterList = new AdapterList(getActivity(),R.layout.item, dsSong2);
                    lv_dsfavorite.setAdapter(adapterList);
                    lv_dsfavorite.deferNotifyDataSetChanged();
                }
            }
        });
        dsPetmacdinh();
        return view;
    }

    private void dsPetmacdinh() {
        dsSong.add(new Song("1234","Nỗi đau xót xa","pop","Hoàn Mạh Hùg",false));
        dsSong.add(new Song("2345","Lời nguyền","pop","Hoàn Mạh Hùg",false));
        dsSong.add(new Song("2653","Bạc trắng tình đời","pop","Hoàn Mạh Hùg",false));
        dsSong.add(new Song("1254","Ngày hạnh phúc","pop","Hoàn Mạh Hùg",false));
        dsSong.add(new Song("6904","Hãy xem là giấc mơ","pop","Hoàn Mạh Hùg",false));
        dsSong.add(new Song("5456","Viên đá nhỏ","pop","Hoàn Mạh Hùg",false));
        dsSong.add(new Song("7534","Một vòng trái đất","pop","Hoàn Mạh Hùg",false));

        adapterList = new AdapterList(getActivity(),R.layout.item, dsSong);
        lv_item.setAdapter(adapterList);
        lv_item.deferNotifyDataSetChanged();
    }
}