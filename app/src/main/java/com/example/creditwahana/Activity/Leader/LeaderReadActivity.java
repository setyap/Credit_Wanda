package com.example.creditwahana.Activity.Leader;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creditwahana.API.APIRequestData;
import com.example.creditwahana.API.RetroServer;
import com.example.creditwahana.Activity.UbahActivity;
import com.example.creditwahana.Model.DataModel;
import com.example.creditwahana.Model.ResponeModel;
import com.example.creditwahana.R;

public class LeaderReadActivity extends AppCompatActivity {
    String vID;
    String  vnik, vnama, vtpt_lahir,
            vtgl_lahir, valamat, vnm_ibu, vtelp1, vtelp2, vstat_nikah,
            vtanggungan, vstat_tinggal, vpekerjaan, vtype_motor, vwarna, vharga,
            vdp, vtenor, vangsuran, vnm_stnk, vsales;
    TextView tvID, tvnik, tvnama, tvtpt_lahir,
            tvtgl_lahir,tvalamat, tvnm_ibu, tvtelp1, tvtelp2, tvstat_nikah,
            tvtanggungan, tvstat_tinggal, tvpekerjaan, tvtype_motor, tvwarna, tvharga,
            tvdp, tvtenor, tvangsuran, tvnm_stnk, tvsales, tvstat_kredit;
    Button  btnback2, btnhapus;

    String stat_kredit;
    public static final String DATA_DETAIL_LEADER = "string_extra";
    DataModel dataModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_read);

        btnhapus = findViewById(R.id.btn_hapus_leader);
        btnback2 = findViewById(R.id.bt_back2_leader);
        tvID = findViewById(R.id.tv_id_leader);
        tvnik = findViewById(R.id.tv_nik_leader);
        tvnama = findViewById(R.id.tv_nama_leader);
        tvtpt_lahir = findViewById(R.id.tv_tpt_lahir_leader);
        tvtgl_lahir = findViewById(R.id.tv_tgl_lahir_leader);
        tvalamat = findViewById(R.id.tv_alamat_leader);
        tvnm_ibu = findViewById(R.id.tv_nm_ibu_leader);
        tvtelp1 = findViewById(R.id.tv_telp1_leader);
        tvtelp2 = findViewById(R.id.tv_telp2_leader);
        tvstat_nikah = findViewById(R.id.tv_stat_nikah_leader);
        tvtanggungan = findViewById(R.id.tv_tanggungan_leader);
        tvstat_tinggal = findViewById(R.id.tv_stat_tinggal_leader);
        tvpekerjaan = findViewById(R.id.tv_pekerjaan_leader);
        tvtype_motor = findViewById(R.id.tv_type_motor_leader);
        tvwarna = findViewById(R.id.tv_warna_leader);
        tvharga = findViewById(R.id.tv_harga_leader);
        tvdp = findViewById(R.id.tv_dp_leader);
        tvtenor = findViewById(R.id.tv_tenor_leader);
        tvangsuran = findViewById(R.id.tv_angsuran_leader);
        tvnm_stnk = findViewById(R.id.tv_nm_stnk_leader);
        tvsales = findViewById(R.id.tv_sales_leader);
        tvstat_kredit = findViewById(R.id.tv_stat_kredit_leader);

        dataModel = getIntent().getParcelableExtra(DATA_DETAIL_LEADER);
        vID = dataModel.getId_cust();
        vnik = dataModel.getNik();
        vnama = dataModel.getNama();
        vtpt_lahir = dataModel.getTempatLahir();
        vtgl_lahir = dataModel.getTanggalLahir();
        valamat = dataModel.getAlamat();
        vnm_ibu = dataModel.getNamaIbu();
        vtelp1 = dataModel.getTelp1();
        vtelp2 = dataModel.getTelp2();
        vstat_nikah = dataModel.getStatusNikah();
        vtanggungan = dataModel.getTanggungan();
        vstat_tinggal = dataModel.getStatusTinggal();
        vpekerjaan = dataModel.getPekerjaan();
        vtype_motor = dataModel.getTypeMotor();
        vwarna = dataModel.getWarna();
        vharga = dataModel.getHarga();
        vdp = dataModel.getDp();
        vtenor = dataModel.getTenor();
        vangsuran = dataModel.getAngsuran();
        vnm_stnk = dataModel.getNamaStnk();
        vsales = dataModel.getSales();
        stat_kredit = dataModel.getStat_kredit();


        tvID.setText(vID);
        tvnik.setText(vnik);
        tvnama.setText(vnama);
        tvtpt_lahir.setText(vtpt_lahir);
        tvtgl_lahir.setText(vtgl_lahir);
        tvalamat.setText(valamat);
        tvnm_ibu.setText(vnm_ibu);
        tvtelp1.setText(vtelp1);
        tvtelp2.setText(vtelp2);
        tvstat_nikah.setText(vstat_nikah);
        tvtanggungan.setText(vtanggungan);
        tvstat_tinggal.setText(vstat_tinggal);
        tvpekerjaan.setText(vpekerjaan);
        tvtype_motor.setText(vtype_motor);
        tvwarna.setText(vwarna);
        tvharga.setText(vharga);
        tvdp.setText(vdp);
        tvtenor.setText(vtenor);
        tvangsuran.setText(vangsuran);
        tvnm_stnk.setText(vnm_stnk);
        tvsales.setText(vsales);
        tvstat_kredit.setText(stat_kredit);

        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(LeaderReadActivity.this, LeaderMainActivity.class);
                startActivity(kembali);
            }
        });

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(LeaderReadActivity.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menghapus Data Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvID.getText().toString();
                        deleteData();

                        Intent hapus = new Intent(LeaderReadActivity.this, LeaderMainActivity.class);
                        startActivity(hapus);
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

    private void deleteData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponeModel> hapusData = ardData.hapusData(vID);

        hapusData.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(LeaderReadActivity.this, "Kode : "+kode+" | Pesan : "+pesan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {
                Toast.makeText(LeaderReadActivity.this, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}