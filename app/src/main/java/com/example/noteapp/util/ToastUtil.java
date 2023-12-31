package com.example.noteapp.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {//对toast的一个封装

    public static void toastShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
