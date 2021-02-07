package com.example.creditwahana.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel implements Parcelable
{

    @SerializedName("id_cust")
    @Expose
    private String id_cust;
    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tempat lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("tanggal lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("nama ibu")
    @Expose
    private String namaIbu;
    @SerializedName("telp1")
    @Expose
    private String telp1;
    @SerializedName("telp2")
    @Expose
    private String telp2;
    @SerializedName("status nikah")
    @Expose
    private String statusNikah;
    @SerializedName("tanggungan")
    @Expose
    private String tanggungan;
    @SerializedName("status tinggal")
    @Expose
    private String statusTinggal;
    @SerializedName("pekerjaan")
    @Expose
    private String pekerjaan;
    @SerializedName("type motor")
    @Expose
    private String typeMotor;
    @SerializedName("warna")
    @Expose
    private String warna;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("dp")
    @Expose
    private String dp;
    @SerializedName("tenor")
    @Expose
    private String tenor;
    @SerializedName("angsuran")
    @Expose
    private String angsuran;
    @SerializedName("nama stnk")
    @Expose
    private String namaStnk;
    @SerializedName("sales")
    @Expose
    private String sales;
    @SerializedName("stat_kredit")
    @Expose
    private String stat_kredit;
    public final static Parcelable.Creator<DataModel> CREATOR = new Creator<DataModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        public DataModel[] newArray(int size) {
            return (new DataModel[size]);
        }

    }
            ;

    protected DataModel(Parcel in) {
        this.id_cust = ((String) in.readValue((String.class.getClassLoader())));
        this.nik = ((String) in.readValue((String.class.getClassLoader())));
        this.nama = ((String) in.readValue((String.class.getClassLoader())));
        this.tempatLahir = ((String) in.readValue((String.class.getClassLoader())));
        this.tanggalLahir = ((String) in.readValue((String.class.getClassLoader())));
        this.alamat = ((String) in.readValue((String.class.getClassLoader())));
        this.namaIbu = ((String) in.readValue((String.class.getClassLoader())));
        this.telp1 = ((String) in.readValue((String.class.getClassLoader())));
        this.telp2 = ((String) in.readValue((String.class.getClassLoader())));
        this.statusNikah = ((String) in.readValue((String.class.getClassLoader())));
        this.tanggungan = ((String) in.readValue((String.class.getClassLoader())));
        this.statusTinggal = ((String) in.readValue((String.class.getClassLoader())));
        this.pekerjaan = ((String) in.readValue((String.class.getClassLoader())));
        this.typeMotor = ((String) in.readValue((String.class.getClassLoader())));
        this.warna = ((String) in.readValue((String.class.getClassLoader())));
        this.harga = ((String) in.readValue((String.class.getClassLoader())));
        this.dp = ((String) in.readValue((String.class.getClassLoader())));
        this.tenor = ((String) in.readValue((String.class.getClassLoader())));
        this.angsuran = ((String) in.readValue((String.class.getClassLoader())));
        this.namaStnk = ((String) in.readValue((String.class.getClassLoader())));
        this.sales = ((String) in.readValue((String.class.getClassLoader())));
        this.stat_kredit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DataModel() {
    }

    public String getId_cust() {
        return id_cust;
    }

    public void setId_cust(String id_cust) {
        this.id_cust = id_cust;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getTelp1() {
        return telp1;
    }

    public void setTelp1(String telp1) {
        this.telp1 = telp1;
    }

    public String getTelp2() {
        return telp2;
    }

    public void setTelp2(String telp2) {
        this.telp2 = telp2;
    }

    public String getStatusNikah() {
        return statusNikah;
    }

    public void setStatusNikah(String statusNikah) {
        this.statusNikah = statusNikah;
    }

    public String getTanggungan() {
        return tanggungan;
    }

    public void setTanggungan(String tanggungan) {
        this.tanggungan = tanggungan;
    }

    public String getStatusTinggal() {
        return statusTinggal;
    }

    public void setStatusTinggal(String statusTinggal) {
        this.statusTinggal = statusTinggal;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getTypeMotor() {
        return typeMotor;
    }

    public void setTypeMotor(String typeMotor) {
        this.typeMotor = typeMotor;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public String getAngsuran() {
        return angsuran;
    }

    public void setAngsuran(String angsuran) {
        this.angsuran = angsuran;
    }

    public String getNamaStnk() {
        return namaStnk;
    }

    public void setNamaStnk(String namaStnk) {
        this.namaStnk = namaStnk;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getStat_kredit() {
        return stat_kredit;
    }

    public void setStatus(String stat_kredit) {
        this.stat_kredit = stat_kredit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id_cust);
        dest.writeValue(nik);
        dest.writeValue(nama);
        dest.writeValue(tempatLahir);
        dest.writeValue(tanggalLahir);
        dest.writeValue(alamat);
        dest.writeValue(namaIbu);
        dest.writeValue(telp1);
        dest.writeValue(telp2);
        dest.writeValue(statusNikah);
        dest.writeValue(tanggungan);
        dest.writeValue(statusTinggal);
        dest.writeValue(pekerjaan);
        dest.writeValue(typeMotor);
        dest.writeValue(warna);
        dest.writeValue(harga);
        dest.writeValue(dp);
        dest.writeValue(tenor);
        dest.writeValue(angsuran);
        dest.writeValue(namaStnk);
        dest.writeValue(sales);
        dest.writeValue(stat_kredit);
    }

    public int describeContents() {
        return 0;
    }

}