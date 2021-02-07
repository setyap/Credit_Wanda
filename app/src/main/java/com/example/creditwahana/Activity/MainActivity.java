package com.example.creditwahana.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.creditwahana.API.APIRequestData;
import com.example.creditwahana.API.RetroServer;
import com.example.creditwahana.Adapter.AdapterData;
import com.example.creditwahana.Model.DataModel;
import com.example.creditwahana.Model.ResponeModel;
import com.example.creditwahana.R;
import com.example.creditwahana.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> listData = new ArrayList<>();
    String id_cust = "id_cust", nik = "nik", nama ="nama", tpt_lahir = "tpt_lahir", tgl_lahir = "tgl_lahir",
    alamat = "alamat", nm_ibu = "nm_ibu", telp1 = "telp1", telp2 = "telp2", stat_nikah = "stat_nikah", tanggungan = "tanggungan",
    stat_tinggal = "stat_tinggal", pekerjaan = "pekerjaan", type_motor = "type_motor", warna = "warna",
    harga = "harga", dp = "dp", tenor = "tenor", angsuran = "angsuran", nm_stnk = "nm_stnk", sales = "sales",
    stat_kredit = "stat_kredit";
    private SwipeRefreshLayout srldata;
    private FloatingActionButton fabTambah;
    SessionManager sessionManager;
    private Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_data);
        srldata = findViewById(R.id.srl_data);
        fabTambah = findViewById(R.id.fab_tambah);
        btnlogout = findViewById(R.id.bt_logout);


        lmData = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);

        retrieveData();

        srldata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srldata.setRefreshing(true);
                retrieveData();
                srldata.setRefreshing(false);
            }
        });

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(MainActivity.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Log Out?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sessionManager.logoutSession();
                        moveToLogin();
                    }
                });
                pesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                pesan.show();

            }
        });
    }

    public void onBackPressed(){
        AlertDialog.Builder pesan = new AlertDialog.Builder(MainActivity.this);
        pesan.setMessage("Apakah Anda Yakin Ingin Log Out?");
        pesan.setTitle("PERHATIAN !");
        pesan.setCancelable(true);

        pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });
        pesan.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        pesan.show();
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void retrieveData(){

        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponeModel> tampildata = ardData.ardRetrievedata(
                id_cust, nik, nama, tpt_lahir, tgl_lahir,
                alamat, nm_ibu, telp1, telp2, stat_nikah, tanggungan,
                stat_tinggal, pekerjaan, type_motor, warna,
                harga, dp, tenor, angsuran, nm_stnk, sales,
                stat_kredit
        );

        //oke

        tampildata.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {

                listData = response.body().getData();

                adData = new AdapterData(MainActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server :    "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}