package com.example.segundoparcial.model;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.segundoparcial.R;

public class Multiplication extends Operation {
    public Multiplication(int num1, int num2, int num3, Context context) {
        super(num1, num2, num3,context);
    }

    @Override
    protected int getResult() {
        return getNum1()*getNum2()*getNum3();
    }

    @NonNull
    @Override
    public String toString() {
        return getContext().getString(R.string.multiplication_result,String.valueOf(getResult()));
    }


}
