package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gurame extends AppCompatActivity {
    private TextView tv_jumlahGurame,tv_hargaTotalGurame;

    private Button btn_tambahGurame,btn_kurangGurame,btn_beliGurame;
    private int jumlahGurame, jumlahHargaGurame;


    private int hargaGurame = 18000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gurame);
        panggilViewGurame();
        actionViewGurame();
    }
    private void panggilViewGurame(){
        btn_tambahGurame=(Button)findViewById(R.id.tambahGurame);
        btn_kurangGurame=(Button)findViewById(R.id.kurangGurame);
        btn_beliGurame=(Button)findViewById(R.id.beliGurame);

        tv_jumlahGurame=(TextView) findViewById(R.id.tv_gurame);
        tv_hargaTotalGurame=(TextView) findViewById(R.id.tv_totalGurame);
    }
    void jumlahtidakMinusGurame() {

        if (jumlahGurame < 0) {
            jumlahGurame = 0;
            jumlahHargaGurame =0;
        }
    }
    private void actionViewGurame(){
        btn_tambahGurame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahGurame=jumlahGurame+1;
                jumlahtidakMinusGurame();
                jumlahHargaGurame=jumlahGurame*hargaGurame;
                tv_jumlahGurame.setText(""+jumlahGurame);
                tv_hargaTotalGurame.setText(""+jumlahHargaGurame);
            }
        });
        btn_kurangGurame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahGurame=jumlahGurame-1;
                jumlahtidakMinusGurame();
                jumlahHargaGurame=jumlahGurame*hargaGurame;
                tv_jumlahGurame.setText(""+jumlahGurame);
                tv_hargaTotalGurame.setText(""+jumlahHargaGurame);
            }
        });
    }
}