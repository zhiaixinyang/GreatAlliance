package com.greatalliance.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.provider.MediaStore;

import com.greatalliance.GreatAllianceApplication;
import com.greatalliance.base.Constant;

/**
 * Created by MBENBEN on 2017/7/11.
 */

public class AlbumUtils {
    public static void startAlbum(Activity activity) {
        try {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
            intent.setType("image/*");
            activity.startActivityForResult(intent, Constant.START_ALBUM_REQUESTCODE);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            try {
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                activity.startActivityForResult(intent, Constant.START_ALBUM_REQUESTCODE);
            } catch (Exception e2) {
                e.printStackTrace();
            }
        }
    }
}
