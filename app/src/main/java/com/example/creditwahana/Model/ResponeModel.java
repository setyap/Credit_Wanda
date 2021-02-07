package com.example.creditwahana.Model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponeModel implements Parcelable
{

    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("data")
    @Expose
    private List<DataModel> data = null;
    public final static Parcelable.Creator<ResponeModel> CREATOR = new Creator<ResponeModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResponeModel createFromParcel(Parcel in) {
            return new ResponeModel(in);
        }

        public ResponeModel[] newArray(int size) {
            return (new ResponeModel[size]);
        }

    }
            ;

    protected ResponeModel(Parcel in) {
        this.kode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pesan = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.example.creditwahana.Model.DataModel.class.getClassLoader()));
    }

    public ResponeModel() {
    }

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kode);
        dest.writeValue(pesan);
        dest.writeList(data);
    }

    public int describeContents() {
        return 0;
    }

}