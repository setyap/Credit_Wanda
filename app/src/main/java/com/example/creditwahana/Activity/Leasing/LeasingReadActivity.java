package com.example.creditwahana.Activity.Leasing;

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

public class LeasingReadActivity extends AppCompatActivity {
    String vID;
    String  vnik, vnama, vtpt_lahir,
            vtgl_lahir, valamat, vnm_ibu, vtelp1, vtelp2, vstat_nikah,
            vtanggungan, vstat_tinggal, vpekerjaan, vtype_motor, vwarna, vharga,
            vdp, vtenor, vangsuran, vnm_stnk, vsales;
    EditText etstat_kredit;
    TextView tvID, tvnik, tvnama, tvtpt_lahir,
            tvtgl_lahir,tvalamat, tvnm_ibu, tvtelp1, tvtelp2, tvstat_nikah,
            tvtanggungan, tvstat_tinggal, tvpekerjaan, tvtype_motor, tvwarna, tvharga,
            tvdp, tvtenor, tvangsuran, tvnm_stnk, tvsales, tvstat_kredit;
    Button btnubah, btnback2;

    String stat_kredit;
    public static final String DATA_DETAIL_LEASING = "string_extra";
    DataModel dataModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leasing_read);

        btnback2 = findViewById(R.id.bt_back2_leasing);
        btnubah = findViewById(R.id.btn_ubah_leasing);
        tvID = findViewById(R.id.tv_id_leasing);
        tvnik = findViewById(R.id.tv_nik_leasing);
        tvnama = findViewById(R.id.tv_nama_leasing);
        tvtpt_lahir = findViewById(R.id.tv_tpt_lahir_leasing);
        tvtgl_lahir = findViewById(R.id.tv_tgl_lahir_leasing);
        tvalamat = findViewById(R.id.tv_alamat_leasing);
        tvnm_ibu = findViewById(R.id.tv_nm_ibu_leasing);
        tvtelp1 = findViewById(R.id.tv_telp1_leasing);
        tvtelp2 = findViewById(R.id.tv_telp2_leasing);
        tvstat_nikah = findViewById(R.id.tv_stat_nikah_leasing);
        tvtanggungan = findViewById(R.id.tv_tanggungan_leasing);
        tvstat_tinggal = findViewById(R.id.tv_stat_tinggal_leasing);
        tvpekerjaan = findViewById(R.id.tv_pekerjaan_leasing);
        tvtype_motor = findViewById(R.id.tv_type_motor_leasing);
        tvwarna = findViewById(R.id.tv_warna_leasing);
        tvharga = findViewById(R.id.tv_harga_leasing);
        tvdp = findViewById(R.id.tv_dp_leasing);
        tvtenor = findViewById(R.id.tv_tenor_leasing);
        tvangsuran = findViewById(R.id.tv_angsuran_leasing);
        tvnm_stnk = findViewById(R.id.tv_nm_stnk_leasing);
        tvsales = findViewById(R.id.tv_sales_leasing);
        tvstat_kredit = findViewById(R.id.tv_stat_kredit_leasing);
        etstat_kredit = findViewById(R.id.et_stat_kredit_leasing);

        dataModel = getIntent().getParcelableExtra(DATA_DETAIL_LEASING);
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
        etstat_kredit.setText(stat_kredit);

        btnback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(LeasingReadActivity.this, LeasingMainActivity.class);
                startActivity(kembali);
            }
        });

        btnubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(LeasingReadActivity.this);
                pesan.setMessage("Apakah Anda Yakin Ingin Menyimpan Data Ini?");
                pesan.setTitle("PERHATIAN !");
                pesan.setCancelable(true);

                pesan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvID.getText().toString();
                        stat_kredit=etstat_kredit.getText().toString();
                        if (etstat_kredit.equals("")){
                            etstat_kredit.setError("Tidak Boleh Kosong");
                        }
                        else{
                            updateData();
                        }
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



    private void updateData(){
        APIRequestData ardKredit = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponeModel> ubahData = ardKredit.editData( vID, stat_kredit);

        ubahData.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {
                int kode = response.body().getKode();
                String pesan= response.body().getPesan();
                Log.d("SERVER_KODE",String.valueOf(kode));
                Log.d("SERVER_PESAN",pesan);
                Log.d("SERVER_ISI_STATUS",dataModel.getStat_kredit());
                Log.d("SERVER_PESAN_ID",dataModel.getId_cust());
//                Toast.makeText(UbahActivity.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {
                Log.d("SERVER_PESAN",t.getMessage());
            }
        });
    }
}