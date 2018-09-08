package com.dietncure.dietncureadmin.utils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dietncure.dietncureadmin.R;
import com.squareup.picasso.Picasso;

/**
 * Created by hp on 7/6/2018.
 */

public class Tools {

    public static boolean validateNormalText(EditText editText){
        if(TextUtils.isEmpty(editText.getText().toString().trim())){
            return false;
        }else{
            return true;
        }
    }

    public static void loadImageIntoImageView(String url, ImageView img){
        Picasso.get().load(url).into(img);
    }

    public static void initCustomToast(Context c, String message){
        Toast.makeText(c,message, Toast.LENGTH_SHORT).show();
    }

    public static void initNetworkErrorToast(Context c){
        Toast.makeText(c,"Something went wrong! Check your internet connection and try again.", Toast.LENGTH_SHORT).show();
    }

    public static void displayImageOriginal(Context ctx, ImageView img, @DrawableRes int drawable) {
        try {
            Glide.with(ctx).load(drawable)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(img);
        } catch (Exception e) {
        }
    }

    public static AlertDialog getDialog(String msg, Context mCtx){
        android.support.v7.app.AlertDialog.Builder alertDialog = new android.support.v7.app.AlertDialog.Builder(mCtx);
        LayoutInflater linf = LayoutInflater.from(mCtx);
        final View inflator = linf.inflate(R.layout.loading_layout, null);
        inflator.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView tv = (TextView) inflator.findViewById(R.id.msg);
        tv.setText(msg);
        alertDialog.setView(inflator);
        alertDialog.setCancelable(false);
        return alertDialog.create();
    }
}
