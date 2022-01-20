package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bebek extends AppCompatActivity {
    private TextView tv_jumlahBebek,tv_hargaTotalBebek;

    private Button btn_tambahBebek,btn_kurangBebek,btn_beliBebek;
    private int jumlahBebek, jumlahHargaBebek;


    private int hargaBebek = 17000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebek);
        panggilViewBebek();
        actionViewBebek();
    }
    private void panggilViewBebek(){
        btn_tambahBebek=(Button)findViewById(R.id.tambahBebek);
        btn_kurangBebek=(Button)findViewById(R.id.kurangBebek);
        btn_beliBebek=(Button)findViewById(R.id.beliBebek);

        tv_jumlahBebek=(TextView) findViewById(R.id.tv_bebek);
        tv_hargaTotalBebek=(TextView) findViewById(R.id.tv_totalBebek);
    }
    void jumlahtidakMinusBebek() {

        if (jumlahBebek < 0) {
            jumlahBebek = 0;
            jumlahHargaBebek =0;
        }
    }
    private void actionViewBebek(){
        btn_tambahBebek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahBebek=jumlahBebek+1;
                jumlahtidakMinusBebek();
                jumlahHargaBebek=jumlahBebek*hargaBebek;
                tv_jumlahBebek.setText(""+jumlahBebek);
                tv_hargaTotalBebek.setText(""+jumlahHargaBebek);
            }
        });
        btn_kurangBebek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahBebek=jumlahBebek-1;
                jumlahtidakMinusBebek();
                jumlahHargaBebek=jumlahBebek*hargaBebek;
                tv_jumlahBebek.setText(""+jumlahBebek);
                tv_hargaTotalBebek.setText(""+jumlahHargaBebek);
            }
        });
    }
}