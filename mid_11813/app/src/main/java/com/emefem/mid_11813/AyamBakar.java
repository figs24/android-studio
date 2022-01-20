package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AyamBakar extends AppCompatActivity {
    private TextView tv_jumlahAyamBakar,tv_hargaTotalAyamBakar;

    private Button btn_tambahAyamBakar,btn_kurangAyamBakar,btn_beliAyamBakar;
    private int jumlahAyamBakar, jumlahHargaAyamBakar;


    private int hargaAyamBakar = 14000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayam_bakar);
        panggilViewAyamBakar();
        actionViewAyamBakar();
    }
    private void panggilViewAyamBakar(){
        btn_tambahAyamBakar=(Button)findViewById(R.id.tambahAyamBakar);
        btn_kurangAyamBakar=(Button)findViewById(R.id.kurangAyamBakar);
        btn_beliAyamBakar=(Button)findViewById(R.id.beliAyamBakar);

        tv_jumlahAyamBakar=(TextView) findViewById(R.id.tv_ayamBakar);
        tv_hargaTotalAyamBakar=(TextView) findViewById(R.id.tv_totalAyamBakar);
    }
    void jumlahtidakMinusAyamBakar() {

        if (jumlahAyamBakar < 0) {
            jumlahAyamBakar = 0;
            jumlahHargaAyamBakar =0;
        }
    }
    private void actionViewAyamBakar(){
        btn_tambahAyamBakar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahAyamBakar=jumlahAyamBakar+1;
                jumlahtidakMinusAyamBakar();
                jumlahHargaAyamBakar=jumlahAyamBakar*hargaAyamBakar;
                tv_jumlahAyamBakar.setText(""+jumlahAyamBakar);
                tv_hargaTotalAyamBakar.setText(""+jumlahHargaAyamBakar);
            }
        });
        btn_kurangAyamBakar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahAyamBakar=jumlahAyamBakar-1;
                jumlahtidakMinusAyamBakar();
                jumlahHargaAyamBakar=jumlahAyamBakar*hargaAyamBakar;
                tv_jumlahAyamBakar.setText(""+jumlahAyamBakar);
                tv_hargaTotalAyamBakar.setText(""+jumlahHargaAyamBakar);
            }
        });
    }
}