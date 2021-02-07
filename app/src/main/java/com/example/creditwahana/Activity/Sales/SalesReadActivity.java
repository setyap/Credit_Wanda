package com.example.creditwahana.Activity.Sales;

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

public class SalesReadActivity extends AppCompatActivity {
    String vID;
    String  vnik, vnama, vtpt_lahir,
            vtgl_lahir, valamat, vnm_ibu, vtelp1, vtelp2, vstat_nikah,
            vtanggungan, vstat_tinggal, vpekerjaan, vtype_motor, vwarna, vharga,
            vdp, vtenor, vangsuran, vnm_stnk, vsales;
    TextView tvID, tvnik, tvnama, tvtpt_lahir,
            tvtgl_lahir,tvalamat, tvnm_ibu, tvtelp1, tvtelp2, tvstat_nikah,
            tvtanggungan, tvstat_tinggal, tvpekerjaan, tvtype_motor, tvwarna, tvharga,
            tvdp, tvtenor, tvangsuran, tvnm_stnk, tvsales, tvstat_kredit;
    Button btnback2;

    String stat_kredit;
    public static final String DATA_DETAIL_SALES = "string_extra";
    DataModel dataModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_read);

        btnback2 = findViewById(R.id.bt_back2_sales);
        tvID = findViewById(R.id.tv_id_sales);
        tvnik = findViewById(R.id.tv_nik_sales);
        tvnama = findViewById(R.id.tv_nama_sales);
        tvtpt_lahir = findViewById(R.id.tv_tpt_lahir_sales);
        tvtgl_lahir = findViewById(R.id.tv_tgl_lahir_sales);
        tvalamat = findViewById(R.id.tv_alamat_sales);
        tvnm_ibu = findViewById(R.id.tv_nm_ibu_sales);
        tvtelp1 = findViewById(R.id.tv_telp1_sales);
        tvtelp2 = findViewById(R.id.tv_telp2_sales);
        tvstat_nikah = findViewById(R.id.tv_stat_nikah_sales);
        tvtanggungan = findViewById(R.id.tv_tanggungan_sales);
        tvstat_tinggal = findViewById(R.id.tv_stat_tinggal_sales);
        tvpekerjaan = findViewById(R.id.tv_pekerjaan_sales);
        tvtype_motor = findViewById(R.id.tv_type_motor_sales);
        tvwarna = findViewById(R.id.tv_warna_sales);
        tvharga = findViewById(R.id.tv_harga_sales);
        tvdp = findViewById(R.id.tv_dp_sales);
        tvtenor = findViewById(R.id.tv_tenor_sales);
        tvangsuran = findViewById(R.id.tv_angsuran_sales);
        tvnm_stnk = findViewById(R.id.tv_nm_stnk_sales);
        tvsales = findViewById(R.id.tv_sales_sales);
        tvstat_kredit = findViewById(R.id.tv_stat_kredit_sales);

        dataModel = getIntent().getParcelableExtra(DATA_DETAIL_SALES);
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
                Intent kembali = new Intent(SalesReadActivity.this, SalesMainActivity.class);
                startActivity(kembali);
            }
        });
    }
}