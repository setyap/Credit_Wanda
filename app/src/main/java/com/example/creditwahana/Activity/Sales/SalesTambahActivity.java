package com.example.creditwahana.Activity.Sales;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.creditwahana.API.APIRequestData;
import com.example.creditwahana.API.RetroServer;
import com.example.creditwahana.Activity.TambahActivity;
import com.example.creditwahana.Model.ResponeModel;
import com.example.creditwahana.R;

public class SalesTambahActivity extends AppCompatActivity {
    private EditText etnik, etnama, ettpt_lahir,
            ettgl_lahir, etalamat, etnm_ibu, ettelp1, ettelp2, etstat_nikah,
            ettanggungan, etstat_tinggal, etpekerjaan, ettype_motor, etwarna, etharga,
            etdp, ettenor, etangsuran, etnm_stnk, etsales;
    private TextView tvstat_kredit;
    private Button btnSimpan,btnback;
    private String nik, nama, tpt_lahir,
            tgl_lahir, alamat, nm_ibu, telp1, telp2, stat_nikah,
            tanggungan, stat_tinggal, pekerjaan, type_motor, warna, harga,
            dp, tenor, angsuran, nm_stnk, sales, stat_kredit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tambah);

        etnik = findViewById(R.id.et_nik_sales);
        etnama = findViewById(R.id.et_nama_sales);
        ettpt_lahir = findViewById(R.id.et_tpt_lahir_sales);
        ettgl_lahir = findViewById(R.id.et_tgl_lahir_sales);
        etalamat = findViewById(R.id.et_alamat_sales);
        etnm_ibu = findViewById(R.id.et_nm_ibu_sales);
        ettelp1 = findViewById(R.id.et_telp1_sales);
        ettelp2 = findViewById(R.id.et_telp2_sales);
        etstat_nikah = findViewById(R.id.et_stat_nikah_sales);
        ettanggungan = findViewById(R.id.et_tanggungan_sales);
        etstat_tinggal = findViewById(R.id.et_stat_tinggal_sales);
        etpekerjaan = findViewById(R.id.et_pekerjaan_sales);
        ettype_motor = findViewById(R.id.et_type_motor_sales);
        etwarna = findViewById(R.id.et_warna_sales);
        etharga = findViewById(R.id.et_harga_sales);
        etdp = findViewById(R.id.et_dp_sales);
        ettenor = findViewById(R.id.et_tenor_sales);
        etangsuran = findViewById(R.id.et_angsuran_sales);
        etnm_stnk = findViewById(R.id.et_nm_stnk_sales);
        etsales = findViewById(R.id.et_sales_sales);
        tvstat_kredit = findViewById(R.id.tv_stat_kredit_sales);
        btnSimpan = findViewById(R.id.btn_simpan_sales);
        btnback = findViewById(R.id.bt_back_sales);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(SalesTambahActivity.this, SalesMainActivity.class);
                startActivity(kembali);
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nik = etnik.getText().toString();
                nama = etnama.getText().toString();
                tpt_lahir = ettpt_lahir.getText().toString();
                tgl_lahir = ettgl_lahir.getText().toString();
                alamat = etalamat.getText().toString();
                nm_ibu = etnm_ibu.getText().toString();
                telp1 = ettelp1.getText().toString();
                telp2 = ettelp2.getText().toString();
                stat_nikah = etstat_nikah.getText().toString();
                tanggungan = ettanggungan.getText().toString();
                stat_tinggal = etstat_tinggal.getText().toString();
                pekerjaan = etpekerjaan.getText().toString();
                type_motor = ettype_motor.getText().toString();
                warna = etwarna.getText().toString();
                harga = etharga.getText().toString();
                dp = etdp.getText().toString();
                tenor = ettenor.getText().toString();
                angsuran = etangsuran.getText().toString();
                nm_stnk = etnm_stnk.getText().toString();
                sales = etsales.getText().toString();
                stat_kredit = tvstat_kredit.getText().toString();

                if(nik.trim().equals("")){
                    etnik.setError("Tidak Boleh Kosong");
                }
                else if(nama.trim().equals("")){
                    etnama.setError("Tidak Boleh Kosong");
                }
                else if(tpt_lahir.trim().equals("")){
                    ettpt_lahir.setError("Tidak Boleh Kosong");
                }
                else if(tgl_lahir.trim().equals("")){
                    ettgl_lahir.setError("Tidak Boleh Kosong");
                }
                else if(alamat.trim().equals("")){
                    etalamat.setError("Tidak Boleh Kosong");
                }
                else if(nm_ibu.trim().equals("")){
                    etnm_ibu.setError("Tidak Boleh Kosong");
                }
                else if(telp1.trim().equals("")){
                    ettelp1.setError("Tidak Boleh Kosong");
                }
                else if(telp2.trim().equals("")){
                    ettelp2.setError("Tidak Boleh Kosong");
                }
                else if(stat_nikah.trim().equals("")){
                    etstat_nikah.setError("Tidak Boleh Kosong");
                }
                else if(tanggungan.trim().equals("")){
                    ettanggungan.setError("Tidak Boleh Kosong");
                }
                else if(stat_tinggal.trim().equals("")){
                    etstat_tinggal.setError("Tidak Boleh Kosong");
                }
                else if(pekerjaan.trim().equals("")){
                    etpekerjaan.setError("Tidak Boleh Kosong");
                }
                else if(type_motor.trim().equals("")){
                    ettype_motor.setError("Tidak Boleh Kosong");
                }
                else if(warna.trim().equals("")){
                    etwarna.setError("Tidak Boleh Kosong");
                }
                else if(harga.trim().equals("")){
                    etharga.setError("Tidak Boleh Kosong");
                }
                else if(dp.trim().equals("")){
                    etdp.setError("Tidak Boleh Kosong");
                }
                else if(tenor.trim().equals("")){
                    ettenor.setError("Tidak Boleh Kosong");
                }
                else if(angsuran.trim().equals("")){
                    etangsuran.setError("Tidak Boleh Kosong");
                }
                else if(nm_stnk.trim().equals("")){
                    etnm_stnk.setError("Tidak Boleh Kosong");
                }
                else if(sales.trim().equals("")){
                    etsales.setError("Tidak Boleh Kosong");
                }
                else{
                    AlertDialog.Builder pesan = new AlertDialog.Builder(SalesTambahActivity.this);
                    pesan.setMessage("Apakah Anda Yakin Ingin Menyimpan Data Ini?");
                    pesan.setTitle("PERHATIAN !");
                    pesan.setCancelable(true);

                    pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            createData();
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
            }
        });
    }

    private void createData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponeModel> simpanData = ardData.ardCreatedata(nik, nama, tpt_lahir,
                tgl_lahir, alamat, nm_ibu, telp1, telp2, stat_nikah,
                tanggungan, stat_tinggal, pekerjaan, type_motor, warna, harga,
                dp, tenor, angsuran, nm_stnk, sales, stat_kredit);

        simpanData.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(SalesTambahActivity.this, "Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {
                Toast.makeText(SalesTambahActivity.this, "Gagal Menghubungi Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}