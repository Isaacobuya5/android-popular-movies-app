package com.example.android.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Credits implements Parcelable {

    @SerializedName("cast")
    private List<Cast> mCast = null;

    @SerializedName("crew")
    private List<Crew> mCrew = null;

    private Credits(Parcel in) {
        if (in.readByte() == 0x01) {
            mCast = new ArrayList<Cast>();
            in.readList(mCast, Cast.class.getClassLoader());
        } else {
            mCast = null;
        }
        if (in.readByte() == 0x01) {
            mCrew = new ArrayList<Crew>();
            in.readList(mCrew, Crew.class.getClassLoader());
        } else {
            mCrew = null;
        }
    }

    @SuppressWarnings("unused")
    public static final Creator<Credits> CREATOR = new Creator<Credits>() {
        @Override
        public Credits createFromParcel(Parcel in) {
            return new Credits(in);
        }

        @Override
        public Credits[] newArray(int size) {
            return new Credits[size];
        }
    };

    public void setCast(List<Cast> cast) {
        mCast = cast;
    }

    public List<Cast> getCast() {
        return mCast;
    }

    public void setCrew(List<Crew> crew) {
        mCrew = crew;
    }

    public List<Crew> getCrew() {
        return mCrew;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mCast == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mCast);
        }
        if (mCrew == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(mCrew);
        }
    }
}
