package com.example.challenge7.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Biodata implements Parcelable {
    private String nama;
    private String nim;
    private String tglLahir;
    private String jk;
    private String jurusan;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.tglLahir);
        dest.writeString(this.jk);
        dest.writeString(this.jurusan);
    }

    protected Biodata(Parcel in) {
        this.nama = in.readString();
        this.nim = in.readString();
        this.tglLahir = in.readString();
        this.jk = in.readString();
        this.jurusan = in.readString();
    }

    public static final Parcelable.Creator<Biodata> CREATOR = new Parcelable.Creator<Biodata>() {
        @Override
        public Biodata createFromParcel(Parcel source) {
            return new Biodata(source);
        }

        @Override
        public Biodata[] newArray(int size) {
            return new Biodata[size];
        }
    };

    public Biodata(String nama, String nim, String tglLahir, String jk, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.tglLahir = tglLahir;
        this.jk = jk;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
