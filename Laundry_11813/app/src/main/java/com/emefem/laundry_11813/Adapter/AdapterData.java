package com.emefem.laundry_11813.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.emefem.laundry_11813.API.APIRequestData;
import com.emefem.laundry_11813.API.RetroServer;
import com.emefem.laundry_11813.Activity.MainActivity;
import com.emefem.laundry_11813.Activity.UpdateActivity;
import com.emefem.laundry_11813.Model.DataModel;
import com.emefem.laundry_11813.Model.ResponseModel;
import com.emefem.laundry_11813.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private Context ctx;
    private List<DataModel> ListData;
    private List<DataModel> listLaundry;
    private int idLaundry;

    public AdapterData(Context ctx, List<DataModel> ListData) {
        this.ctx = ctx;
        this.ListData = ListData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderData holder=new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm=ListData.get(position);
        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNama.setText(dm.getNama());
        holder.tvAlamat.setText(dm.getAlamat());
        holder.tvTelepon.setText(dm.getNohp());
        holder.tvKota.setText(dm.getKota());

    }

    @Override
    public int getItemCount() {
        return ListData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId,tvNama,tvKota,tvAlamat,tvTelepon;


        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tv_id);
            tvNama=itemView.findViewById(R.id.tv_nama);
            tvAlamat=itemView.findViewById(R.id.tv_alamat);
            tvTelepon=itemView.findViewById(R.id.tv_telepon);
            tvKota=itemView.findViewById(R.id.tv_kota);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder dialogPesan=new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Operasi yang akan dilakukan");
                    dialogPesan.setTitle("Perhatian");
                    dialogPesan.setIcon(R.mipmap.ic_launcher_round);
                    dialogPesan.setCancelable(true);

                    idLaundry=Integer.parseInt(tvId.getText().toString());

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteData();
                            dialog.dismiss();
                            Handler hand=new Handler();
                            hand.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    ((MainActivity)ctx).retrieveData();
                                }
                            },500);
                        }
                    });
                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            updateData();
                            dialog.dismiss();
                        }
                    });
                    dialogPesan.show();

                    return false;
                }
            });
        }
        private void deleteData(){
            APIRequestData ardData= RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData=ardData.ardDeleteData(idLaundry);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode=response.body().getKode();
                    String pesan=response.body().getPesan();

                    Toast.makeText(ctx, "kode:"+kode+" |Pesan: "+pesan, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "gagal menghubungi server: "+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        private void updateData(){
            APIRequestData ardData= RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> getData=ardData.ardUpdateData(idLaundry);

            getData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    int kode=response.body().getKode();
                    String pesan=response.body().getPesan();
                    listLaundry=response.body().getData();

                    int varIdLaundry=listLaundry.get(0).getId();
                    String varNamaLaundry=listLaundry.get(0).getNama();
                    String varAlamatLaundry=listLaundry.get(0).getAlamat();
                    String varTeleponLaundry=listLaundry.get(0).getNohp();
                    String varKotaLaundry=listLaundry.get(0).getKota();


                    //Toast.makeText(ctx, "kode:"+kode+" |Pesan: "+pesan+"|Data:"+varIdLaundry+"|"+varNamaLaundry+"|"+varAlamatLaundry+"|"+varTeleponLaundry+"|"+varNISNLaundry, Toast.LENGTH_SHORT).show();
                    Intent kirim=new Intent(ctx, UpdateActivity.class);
                    kirim.putExtra("xId", varIdLaundry);
                    kirim.putExtra("xNama", varNamaLaundry);
                    kirim.putExtra("xAlamat", varAlamatLaundry);
                    kirim.putExtra("xTelepon", varTeleponLaundry);
                    kirim.putExtra("xKota", varKotaLaundry);
                    ctx.startActivity(kirim);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "gagal menghubungi server: "+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}