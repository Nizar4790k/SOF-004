package com.example.segundoparcial;

import android.content.Context;

import com.example.segundoparcial.model.Addition;
import com.example.segundoparcial.model.Multiplication;
import com.example.segundoparcial.model.Operation;
import com.example.segundoparcial.model.Sustration;

public class OperationFactory {

    private static OperationFactory sInstance;
    private Context mContext;


    private OperationFactory(Context context){
        mContext = context;

    }


    public Operation getOperation(int n1, int n2, int n3, OperationType operationType){


        switch (operationType){

            case ADDITION:
                return new Addition(n1,n2,n3,mContext);

            case SUSTRATION:
                return new Sustration(n1,n2,n3,mContext);
            case MULTIPLICATION:
                return new Multiplication(n1,n2,n3,mContext);

                default:
                    return null;


        }



    }

    public static OperationFactory getInstance(Context context){

        if(sInstance==null){
            sInstance= new OperationFactory(context);
        }


        return sInstance;
    }


    public enum OperationType{
        ADDITION,SUSTRATION,MULTIPLICATION


    }





}
