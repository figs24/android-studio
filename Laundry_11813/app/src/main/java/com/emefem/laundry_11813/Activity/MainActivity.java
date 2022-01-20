package com.emefem.laundry_11813.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.emefem.laundry_11813.API.APIRequestData;
import com.emefem.laundry_11813.API.RetroServer;
import com.emefem.laundry_11813.Adapter.AdapterData;
import com.emefem.laundry_11813.Model.DataModel;
import com.emefem.laundry_11813.Model.ResponseModel;
import com.emefem.laundry_11813.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData= new ArrayList<>();
    private SwipeRefreshLayout srlData;
    private ProgressBar pbData;
    private FloatingActionButton fabTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData=findViewById(R.id.rv_data);
        srlData=findViewById(R.id.svl_data);
        pbData=findViewById(R.id.pd_data);
        fabTambah=findViewById(R.id.fab_tambah);
        lmData=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);

        srlData.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlData.setRefreshing(true);
                retrieveData();
                srlData.setRefreshing(false);
            }
        });
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TambahActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData(){
        pbData.setVisibility(View.VISIBLE);
        APIRequestData ardData= RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData=ardData.ardRetrieveData();
        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode=response.body().getKode();
                String pesan=response.body().getPesan();
                //Toast.makeText(MainActivity.this,"kode : "+kode+"| Pesan: "+pesan,Toast.LENGTH_SHORT).show();

                listData=response.body().getData();
                adData=new AdapterData(MainActivity.this,listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                pbData.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Gagal Menghubungi Server"+t.getMessage(),Toast.LENGTH_SHORT).show();
                pbData.setVisibility(View.INVISIBLE);

            }
        });
    }
}