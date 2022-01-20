package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lele extends AppCompatActivity {
    private TextView tv_jumlahLele,tv_hargaTotalLele;

    private Button btn_tambahLele,btn_kurangLele,btn_beliLele;
    private int jumlahLele, jumlahHargaLele;


    private int hargaLele = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lele);
        panggilViewLele();
        actionViewLele();
    }
    private void panggilViewLele(){
        btn_tambahLele=(Button)findViewById(R.id.tambahLele);
        btn_kurangLele=(Button)findViewById(R.id.kurangLele);
        btn_beliLele=(Button)findViewById(R.id.beliLele);

        tv_jumlahLele=(TextView) findViewById(R.id.tv_lele);
        tv_hargaTotalLele=(TextView) findViewById(R.id.tv_totalLele);
    }
    void jumlahtidakMinusLele() {

        if (jumlahLele < 0) {
            jumlahLele = 0;
            jumlahHargaLele =0;
        }
    }
    private void actionViewLele(){
        btn_tambahLele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahLele=jumlahLele+1;
                jumlahtidakMinusLele();
                jumlahHargaLele=jumlahLele*hargaLele;
                tv_jumlahLele.setText(""+jumlahLele);
                tv_hargaTotalLele.setText(""+jumlahHargaLele);
            }
        });
        btn_kurangLele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahLele=jumlahLele-1;
                jumlahtidakMinusLele();
                jumlahHargaLele=jumlahLele*hargaLele;
                tv_jumlahLele.setText(""+jumlahLele);
                tv_hargaTotalLele.setText(""+jumlahHargaLele);
            }
        });
    }
}