package com.lpc.test.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 功能:
 * <p>
 * 描述:
 * <p>
 * Created by lipc0113 on 2021/3/6.
 */
public class Book implements Parcelable {
    private int id;
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
