package com.example.segundoparcial.model;

import android.content.Context;

public abstract class Operation  {

    private int mNum1;
    private int mNum2;
    private int mNum3;
    private Context mContext;


    public Operation(int num1, int num2, int num3, Context context) {
        mNum1 = num1;
        mNum2 = num2;
        mNum3 = num3;
        mContext=context;
    }

    protected abstract int getResult();

    protected int getNum1() {
        return mNum1;
    }

    protected int getNum2() {
        return mNum2;
    }

    protected int getNum3() {
        return mNum3;
    }

    protected Context getContext() {
        return mContext;
    }
}
