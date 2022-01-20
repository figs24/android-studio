package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tahu extends AppCompatActivity {
    private TextView tv_jumlahTahu,tv_hargaTotalTahu;

    private Button btn_tambahTahu,btn_kurangTahu,btn_beliTahu;
    private int jumlahTahu, jumlahHargaTahu;


    private int hargaTahu = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahu);
        panggilViewTahu();
        actionViewTahu();
    }
    private void panggilViewTahu(){
        btn_tambahTahu=(Button)findViewById(R.id.tambahTahu);
        btn_kurangTahu=(Button)findViewById(R.id.kurangTahu);
        btn_beliTahu=(Button)findViewById(R.id.beliTahu);

        tv_jumlahTahu=(TextView) findViewById(R.id.tv_tahu);
        tv_hargaTotalTahu=(TextView) findViewById(R.id.tv_totalTahu);
    }
    void jumlahtidakMinusTahu() {

        if (jumlahTahu < 0) {
            jumlahTahu = 0;
            jumlahHargaTahu =0;
        }
    }
    private void actionViewTahu(){
        btn_tambahTahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahTahu=jumlahTahu+1;
                jumlahtidakMinusTahu();
                jumlahHargaTahu=jumlahTahu*hargaTahu;
                tv_jumlahTahu.setText(""+jumlahTahu);
                tv_hargaTotalTahu.setText(""+jumlahHargaTahu);
            }
        });
        btn_kurangTahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahTahu=jumlahTahu-1;
                jumlahtidakMinusTahu();
                jumlahHargaTahu=jumlahTahu*hargaTahu;
                tv_jumlahTahu.setText(""+jumlahTahu);
                tv_hargaTotalTahu.setText(""+jumlahHargaTahu);
            }
        });
    }
}