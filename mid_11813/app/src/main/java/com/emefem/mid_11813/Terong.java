package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Terong extends AppCompatActivity {
    private TextView tv_jumlahTerong,tv_hargaTotalTerong;

    private Button btn_tambahTerong,btn_kurangTerong,btn_beliTerong;
    private int jumlahTerong, jumlahHargaTerong;


    private int hargaTerong = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terong);
        panggilViewTerong();
        actionViewTerong();
    }
    private void panggilViewTerong(){
        btn_tambahTerong=(Button)findViewById(R.id.tambahTerong);
        btn_kurangTerong=(Button)findViewById(R.id.kurangTerong);
        btn_beliTerong=(Button)findViewById(R.id.beliTerong);

        tv_jumlahTerong=(TextView) findViewById(R.id.tv_terong);
        tv_hargaTotalTerong=(TextView) findViewById(R.id.tv_totalTerong);
    }
    void jumlahtidakMinusTerong() {

        if (jumlahTerong < 0) {
            jumlahTerong = 0;
            jumlahHargaTerong =0;
        }
    }
    private void actionViewTerong(){
        btn_tambahTerong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahTerong=jumlahTerong+1;
                jumlahtidakMinusTerong();
                jumlahHargaTerong=jumlahTerong*hargaTerong;
                tv_jumlahTerong.setText(""+jumlahTerong);
                tv_hargaTotalTerong.setText(""+jumlahHargaTerong);
            }
        });
        btn_kurangTerong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahTerong=jumlahTerong-1;
                jumlahtidakMinusTerong();
                jumlahHargaTerong=jumlahTerong*hargaTerong;
                tv_jumlahTerong.setText(""+jumlahTerong);
                tv_hargaTotalTerong.setText(""+jumlahHargaTerong);
            }
        });
    }
}