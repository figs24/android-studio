package com.emefem.laundry_11813.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.emefem.laundry_11813.API.APIRequestData;
import com.emefem.laundry_11813.API.RetroServer;
import com.emefem.laundry_11813.Model.ResponseModel;
import com.emefem.laundry_11813.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    private int xid;
    private String xNama,xAlamat,xTelepon,xKota;
    private EditText etNama,etAlamat,etTelepon,etKota;
    private Button btnubah;
    private String yNama,yAlamat,yTelepon,yKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent terima=getIntent();
        xid=terima.getIntExtra("xId",-1);
        xNama=terima.getStringExtra("xNama");
        xAlamat=terima.getStringExtra("xAlamat");
        xTelepon=terima.getStringExtra("xTelepon");
        xKota=terima.getStringExtra("xKota");

        etNama=findViewById(R.id.et_nama);
        etAlamat=findViewById(R.id.et_alamat);
        etTelepon=findViewById(R.id.et_telepon);
        etKota=findViewById(R.id.et_kota);
        btnubah=findViewById(R.id.btn_ubah);

        etNama.setText(xNama);
        etAlamat.setText(xAlamat);
        etTelepon.setText(xTelepon);
        etKota.setText(xKota);

        btnubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yNama=etNama.getText().toString();
                yAlamat=etAlamat.getText().toString();
                yTelepon=etTelepon.getText().toString();
                yKota=etKota.getText().toString();
                ubahData();
            }
        });
    }
    private void ubahData(){
        APIRequestData ardData= RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> ubhData=ardData.ardUbahData(xid,yNama,yAlamat,yTelepon,yKota);

        ubhData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode =response.body().getKode();
                String pesan=response.body().getPesan();
                Toast.makeText(UpdateActivity.this, "kode"+kode+" | Pesan:"+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Gagal menghubungi server"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}