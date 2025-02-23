package com.haotsang.neteasecloudmusic.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class ImageUtils {

    public static Bitmap stringToBitmap(String string) {
        if (string == null) {
            return null;
        }

        try {
            String[] parts = string.split(",");
            byte[] bitmapArray = Base64.decode(parts[1], Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String bitmapToString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }

        // Convert Bitmap to String
        String string;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
        byte[] bytes = bStream.toByteArray();
        string = Base64.encodeToString(bytes, Base64.DEFAULT);
        return "data:image/png;base64," + string;
    }
}