package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tempe extends AppCompatActivity {
    private TextView tv_jumlahTempe,tv_hargaTotalTempe;

    private Button btn_tambahTempe,btn_kurangTempe,btn_beliTempe;
    private int jumlahTempe, jumlahHargaTempe;


    private int hargaTempe = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempe);
        panggilViewTempe();
        actionViewTempe();
    }
    private void panggilViewTempe(){
        btn_tambahTempe=(Button)findViewById(R.id.tambahTempe);
        btn_kurangTempe=(Button)findViewById(R.id.kurangTempe);
        btn_beliTempe=(Button)findViewById(R.id.beliTempe);

        tv_jumlahTempe=(TextView) findViewById(R.id.tv_tempe);
        tv_hargaTotalTempe=(TextView) findViewById(R.id.tv_totalTempe);
    }
    void jumlahtidakMinus() {

        if (jumlahTempe <= 0) {
            jumlahTempe = 0;
            jumlahHargaTempe =0;
        }
    }
    private void actionViewTempe(){
        btn_tambahTempe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahTempe=jumlahTempe+1;
                jumlahtidakMinus();
                jumlahHargaTempe=jumlahTempe*hargaTempe;
                tv_jumlahTempe.setText(""+jumlahTempe);
                tv_hargaTotalTempe.setText(""+jumlahHargaTempe);
            }
        });
        btn_kurangTempe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahTempe=jumlahTempe-1;
                jumlahtidakMinus();
                jumlahHargaTempe=jumlahTempe*hargaTempe;
                tv_jumlahTempe.setText(""+jumlahTempe);
                tv_hargaTotalTempe.setText(""+jumlahHargaTempe);
            }
        });
    }
}