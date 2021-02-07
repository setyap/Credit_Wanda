package com.example.creditwahana.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.creditwahana.Activity.Leasing.LeasingReadActivity;
import com.example.creditwahana.Model.DataModel;
import com.example.creditwahana.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDataLeasing extends RecyclerView.Adapter<AdapterDataLeasing.HolderDataLeasing> {
    private Context ctx;
    private List<DataModel> listdataleasing;

    public AdapterDataLeasing(Context ctx, List<DataModel> listdataleasing) {
        this.ctx = ctx;
        this.listdataleasing = listdataleasing;
    }

    @NonNull
    @Override
    public HolderDataLeasing onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutleasing = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        HolderDataLeasing holderleasing = new HolderDataLeasing(layoutleasing);
        return holderleasing;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataLeasing holder, int position) {
        DataModel dm = listdataleasing.get(position);

        holder.tvNo.setText(dm.getId_cust());
        holder.tvNik.setText(dm.getNik());
        holder.tvNama.setText(dm.getNama());
        holder.tvTpt_lahr.setText(dm.getTempatLahir());
        holder.tvTgl_lahir.setText(dm.getTanggalLahir());
        holder.tvAlamat.setText(dm.getAlamat());
        holder.tvNm_ibu.setText(dm.getNamaIbu());
        holder.tvTelp1.setText(dm.getTelp1());
        holder.tvTelp2.setText(dm.getTelp2());
        holder.tvStat_nikah.setText(dm.getStatusNikah());
        holder.tvTanggungan.setText(dm.getTanggungan());
        holder.tvStat_tinggal.setText(dm.getStatusTinggal());
        holder.tvPekerjaan.setText(dm.getPekerjaan());
        holder.tvType_motor.setText(dm.getTypeMotor());
        holder.tvWarna.setText(dm.getWarna());
        holder.tvHarga.setText(dm.getHarga());
        holder.tvDp.setText(dm.getDp());
        holder.tvTenor.setText(dm.getTenor());
        holder.tvAngsuran.setText(dm.getAngsuran());
        holder.tvNm_stnk.setText(dm.getNamaStnk());
        holder.tvSales.setText(dm.getSales());
        holder.tvStat_kredit.setText(dm.getStat_kredit());

        holder.kreditleader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent readleasing = new Intent(ctx, LeasingReadActivity.class);
                readleasing.putExtra(LeasingReadActivity.DATA_DETAIL_LEASING,dm);
                ctx.startActivity(readleasing);
            }
        });   }

    @Override
    public int getItemCount() {
        return listdataleasing.size();
    }

    public class HolderDataLeasing extends RecyclerView.ViewHolder{
        TextView tvNo, tvNik, tvNama, tvTpt_lahr, tvTgl_lahir, tvAlamat, tvNm_ibu, tvTelp1, tvTelp2,
                tvStat_nikah, tvTanggungan, tvStat_tinggal, tvPekerjaan, tvType_motor, tvWarna, tvHarga,
                tvDp, tvTenor, tvAngsuran, tvNm_stnk, tvSales, tvStat_kredit;

        CardView kreditleader;

        public HolderDataLeasing(@NonNull View itemView) {
            super(itemView);

            kreditleader = itemView.findViewById(R.id.kredit);
            tvNo = itemView.findViewById(R.id.tv_no);
            tvNik = itemView.findViewById(R.id.tv_nik);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTpt_lahr = itemView.findViewById(R.id.tv_tpt_lahir);
            tvTgl_lahir = itemView.findViewById(R.id.tv_tgl_lahir);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvNm_ibu = itemView.findViewById(R.id.tv_nm_ibu);
            tvTelp1 = itemView.findViewById(R.id.tv_telp1);
            tvTelp2 = itemView.findViewById(R.id.tv_telp2);
            tvStat_nikah = itemView.findViewById(R.id.tv_stat_nikah);
            tvTanggungan = itemView.findViewById(R.id.tv_tanggungan);
            tvStat_tinggal = itemView.findViewById(R.id.tv_stat_tinggal);
            tvPekerjaan = itemView.findViewById(R.id.tv_pekerjaan);
            tvType_motor = itemView.findViewById(R.id.tv_type_motor);
            tvWarna = itemView.findViewById(R.id.tv_warna);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            tvDp = itemView.findViewById(R.id.tv_dp);
            tvTenor = itemView.findViewById(R.id.tv_tenor);
            tvAngsuran = itemView.findViewById(R.id.tv_angsuran);
            tvNm_stnk = itemView.findViewById(R.id.tv_nm_stnk);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvSales = itemView.findViewById(R.id.tv_sales);
            tvStat_kredit = itemView.findViewById(R.id.tv_stat_kredit);
        }
    }
}
