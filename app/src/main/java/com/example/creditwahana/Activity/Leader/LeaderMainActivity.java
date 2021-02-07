package com.example.creditwahana.Activity.Leader;

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
import com.example.creditwahana.Activity.LoginActivity;
import com.example.creditwahana.Activity.MainActivity;
import com.example.creditwahana.Activity.TambahActivity;
//import com.example.creditwahana.Adapter.AdapterData;
import com.example.creditwahana.Adapter.AdapterDataLeader;
import com.example.creditwahana.Model.DataModel;
import com.example.creditwahana.Model.ResponeModel;
import com.example.creditwahana.R;
import com.example.creditwahana.SessionManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LeaderMainActivity extends AppCompatActivity {
    private RecyclerView rvDataLeader;
    private RecyclerView.Adapter adDataLeader;
    private RecyclerView.LayoutManager lmDataLeader;
    private List<DataModel> listDataLeader = new ArrayList<>();
    String id_cust = "id_cust", nik = "nik", nama ="nama", tpt_lahir = "tpt_lahir", tgl_lahir = "tgl_lahir",
            alamat = "alamat", nm_ibu = "nm_ibu", telp1 = "telp1", telp2 = "telp2", stat_nikah = "stat_nikah", tanggungan = "tanggungan",
            stat_tinggal = "stat_tinggal", pekerjaan = "pekerjaan", type_motor = "type_motor", warna = "warna",
            harga = "harga", dp = "dp", tenor = "tenor", angsuran = "angsuran", nm_stnk = "nm_stnk", sales = "sales",
            stat_kredit = "stat_kredit";
    SessionManager sessionManagerleader;
    private Button btnlogoutleader;
    private SwipeRefreshLayout srldataleader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_main);

        rvDataLeader = findViewById(R.id.rv_data_leader);
        srldataleader = findViewById(R.id.srl_data_leader);
        btnlogoutleader = findViewById(R.id.bt_logout_leader);


        lmDataLeader = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rvDataLeader.setLayoutManager(lmDataLeader);

        retrieveData();

        srldataleader.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srldataleader.setRefreshing(true);
                retrieveData();
                srldataleader.setRefreshing(false);
            }
        });

        sessionManagerleader = new SessionManager(LeaderMainActivity.this);
        if(!sessionManagerleader.isLoggedIn()){
            moveToLoginLeader();
        }

        btnlogoutleader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(LeaderMainActivity.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Log Out?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sessionManagerleader.logoutSession();
                        moveToLoginLeader();
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

    @Override
    protected void onResume() {
        super.onResume();
        retrieveData();
    }

    public void onBackPressed(){
        AlertDialog.Builder pesan = new AlertDialog.Builder(LeaderMainActivity.this);
        pesan.setMessage("Apakah Anda Yakin Ingin Log Out?");
        pesan.setTitle("PERHATIAN !");
        pesan.setCancelable(true);

        pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sessionManagerleader.logoutSession();
                moveToLoginLeader();
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

    private void moveToLoginLeader() {
        Intent intent = new Intent(LeaderMainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    public void retrieveData(){
        APIRequestData ardDataLeader = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponeModel> tampildata = ardDataLeader.ardRetrievedata(id_cust, nik, nama, tpt_lahir, tgl_lahir,
                alamat, nm_ibu, telp1, telp2, stat_nikah, tanggungan,
                stat_tinggal, pekerjaan, type_motor, warna,
                harga, dp, tenor, angsuran, nm_stnk, sales,
                stat_kredit);

        tampildata.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {
                String pesan = response.body().getPesan();

                listDataLeader = response.body().getData();

                adDataLeader = new AdapterDataLeader(LeaderMainActivity.this, listDataLeader);
                rvDataLeader.setAdapter(adDataLeader);
                adDataLeader.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {
                Toast.makeText(LeaderMainActivity.this, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}