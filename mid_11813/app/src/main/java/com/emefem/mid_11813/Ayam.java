package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ayam extends AppCompatActivity {
    private TextView tv_jumlahAyam,tv_hargaTotalAyam;

    private Button btn_tambahAyam,btn_kurangAyam,btn_beliAyam;
    private int jumlahAyam, jumlahHargaAyam;


    private int hargaAyam = 12000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayam);
        panggilViewAyam();
        actionViewAyam();
    }
    private void panggilViewAyam(){
        btn_tambahAyam=(Button)findViewById(R.id.tambahAyam);
        btn_kurangAyam=(Button)findViewById(R.id.kurangAyam);
        btn_beliAyam=(Button)findViewById(R.id.beliAyam);

        tv_jumlahAyam=(TextView) findViewById(R.id.tv_ayam);
        tv_hargaTotalAyam=(TextView) findViewById(R.id.tv_totalAyam);
    }
    void jumlahtidakMinusAyam() {

        if (jumlahAyam < 0) {
            jumlahAyam = 0;
            jumlahHargaAyam =0;
        }
    }
    private void actionViewAyam(){
        btn_tambahAyam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahAyam=jumlahAyam+1;
                jumlahtidakMinusAyam();
                jumlahHargaAyam=jumlahAyam*hargaAyam;
                tv_jumlahAyam.setText(""+jumlahAyam);
                tv_hargaTotalAyam.setText(""+jumlahHargaAyam);
            }
        });
        btn_kurangAyam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahAyam=jumlahAyam-1;
                jumlahtidakMinusAyam();
                jumlahHargaAyam=jumlahAyam*hargaAyam;
                tv_jumlahAyam.setText(""+jumlahAyam);
                tv_hargaTotalAyam.setText(""+jumlahHargaAyam);
            }
        });
    }
}