package com.emefem.mid_11813;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView bt_ayamB=findViewById(R.id.ayamB);
        CardView bt_ayam=findViewById(R.id.ayam);
        CardView bt_ayam1=findViewById(R.id.ayam1);
        CardView bt_bebek=findViewById(R.id.bebek);
        CardView bt_bebek1=findViewById(R.id.bebek1);
        CardView bt_gurame=findViewById(R.id.gurame);
        CardView bt_lele=findViewById(R.id.lele);
        CardView bt_lele1=findViewById(R.id.lele1);
        CardView bt_tahu=findViewById(R.id.tahu);
        CardView bt_tahu1=findViewById(R.id.tahu1);
        CardView bt_tempe=findViewById(R.id.tempe);
        CardView bt_tempe1=findViewById(R.id.tempe1);
        CardView bt_terong=findViewById(R.id.terong);

        bt_ayamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AyamBakar.class));
            }
        });
        bt_ayam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Ayam.class));
            }
        });
        bt_ayam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Ayam.class));
            }
        });
        bt_bebek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Bebek.class));
            }
        });
        bt_bebek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Bebek.class));
            }
        });
        bt_gurame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Gurame.class));
            }
        });
        bt_lele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Lele.class));
            }
        });
        bt_lele1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Lele.class));
            }
        });
        bt_tahu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Tahu.class));
            }
        });
        bt_tahu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Tahu.class));
            }
        });
        bt_tempe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Tempe.class));
            }
        });
        bt_tempe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Tempe.class));
            }
        });
        bt_terong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Terong.class));
            }
        });
    }
}