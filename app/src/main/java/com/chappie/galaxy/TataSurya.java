package com.chappie.galaxy;

import android.os.Parcel;
import android.os.Parcelable;

public class TataSurya implements Parcelable {
    public static final Creator<TataSurya> CREATOR = new Creator<TataSurya>() {
        public TataSurya createFromParcel(Parcel parcel) {
            return new TataSurya(parcel);
        }

        public TataSurya[] newArray(int i) {
            return new TataSurya[i];
        }
    };
    private String describe;
    private int imgPlanet;
    private String name;

    public int describeContents() {
        return 0;
    }

    TataSurya(int i, String str, String str2) {
        this.imgPlanet = i;
        this.name = str;
        this.describe = str2;
    }

    int getImgPlanet() {
        return this.imgPlanet;
    }

    public void setImgPlanet(int i) {
        this.imgPlanet = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.imgPlanet);
        parcel.writeString(this.name);
        parcel.writeString(this.describe);
    }

    protected TataSurya(Parcel parcel) {
        this.imgPlanet = parcel.readInt();
        this.name = parcel.readString();
        this.describe = parcel.readString();
    }
}
