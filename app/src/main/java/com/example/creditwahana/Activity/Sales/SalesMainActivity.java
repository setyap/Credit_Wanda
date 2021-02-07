package com.example.creditwahana.Activity.Sales;

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
import com.example.creditwahana.Activity.Leasing.LeasingMainActivity;
import com.example.creditwahana.Activity.LoginActivity;
import com.example.creditwahana.Activity.MainActivity;
import com.example.creditwahana.Activity.TambahActivity;
//import com.example.creditwahana.Adapter.AdapterData;
import com.example.creditwahana.Adapter.AdapterDataSales;
import com.example.creditwahana.Model.DataModel;
import com.example.creditwahana.Model.ResponeModel;
import com.example.creditwahana.R;
import com.example.creditwahana.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SalesMainActivity extends AppCompatActivity {
    private RecyclerView rvDataSales;
    private RecyclerView.Adapter adDataSales;
    private RecyclerView.LayoutManager lmDataSales;
    private List<DataModel> listDataSales = new ArrayList<>();
    String id_cust = "id_cust", nik = "nik", nama ="nama", tpt_lahir = "tpt_lahir", tgl_lahir = "tgl_lahir",
            alamat = "alamat", nm_ibu = "nm_ibu", telp1 = "telp1", telp2 = "telp2", stat_nikah = "stat_nikah", tanggungan = "tanggungan",
            stat_tinggal = "stat_tinggal", pekerjaan = "pekerjaan", type_motor = "type_motor", warna = "warna",
            harga = "harga", dp = "dp", tenor = "tenor", angsuran = "angsuran", nm_stnk = "nm_stnk", sales = "sales",
            stat_kredit = "stat_kredit";
    SessionManager sessionManagersales;
    private Button btnlogoutsales;
    private SwipeRefreshLayout srldatasales;
    private FloatingActionButton fabTambahsales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_main);

        rvDataSales = findViewById(R.id.rv_data_sales);
        srldatasales = findViewById(R.id.srl_data_sales);
        fabTambahsales = findViewById(R.id.fab_tambah_sales);
        btnlogoutsales = findViewById(R.id.bt_logout_sales);

        lmDataSales = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvDataSales.setLayoutManager(lmDataSales);

        retrieveDataSales();

        srldatasales.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srldatasales.setRefreshing(true);
                retrieveDataSales();
                srldatasales.setRefreshing(false);
            }
        });

        fabTambahsales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SalesMainActivity.this, SalesTambahActivity.class));
            }
        });

        sessionManagersales = new SessionManager(SalesMainActivity.this);
        if (!sessionManagersales.isLoggedIn()){
            moveToLoginSales();
        }

        btnlogoutsales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(SalesMainActivity.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Log Out?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sessionManagersales.logoutSession();
                        moveToLoginSales();
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
        AlertDialog.Builder pesan = new AlertDialog.Builder(SalesMainActivity.this);
        pesan.setMessage("Apakah Anda Yakin Ingin Log Out?");
        pesan.setTitle("PERHATIAN !");
        pesan.setCancelable(true);

        pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sessionManagersales.logoutSession();
                moveToLoginSales();
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

    protected void onResume() {
        super.onResume();
        retrieveDataSales();
    }

    private void moveToLoginSales() {
        Intent intent = new Intent(SalesMainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    public void retrieveDataSales(){
        APIRequestData ardDataSales = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponeModel> tampilDataSales = ardDataSales.ardRetrievedata(id_cust, nik, nama, tpt_lahir, tgl_lahir,
                alamat, nm_ibu, telp1, telp2, stat_nikah, tanggungan,
                stat_tinggal, pekerjaan, type_motor, warna,
                harga, dp, tenor, angsuran, nm_stnk, sales,
                stat_kredit);

        tampilDataSales.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {
                String pesan = response.body().getPesan();

                listDataSales = response.body().getData();

                adDataSales = new AdapterDataSales(SalesMainActivity.this, listDataSales);
                rvDataSales.setAdapter(adDataSales);
                adDataSales.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {
                Toast.makeText(SalesMainActivity.this, "GAGAL MENGHUBUNGI SERVER" +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}