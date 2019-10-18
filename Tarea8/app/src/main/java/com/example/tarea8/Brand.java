package com.example.tarea8;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Brand  implements Serializable {

    private String mName;
    private int mPhoto;

    public Brand(String name, int photo) {
        mName = name;
        mPhoto = photo;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPhoto() {
        return mPhoto;
    }

    public void setPhoto(int photo) {
        mPhoto = photo;
    }


    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
