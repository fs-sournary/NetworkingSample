package com.example.fs_sournary.networkingsample.sample2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fs-sournary.
 * Data: 1/31/18.
 * Description:
 */

public class MyLoader extends AsyncTaskLoader<List<Bitmap>> {

    private URL mURL;
    private List<Bitmap> mBitmaps;

    public MyLoader(Context context, URL url) {
        super(context);
        mURL = url;
    }

    @Override
    protected void onStartLoading() {
        if (mBitmaps != null) {
            deliverResult(mBitmaps);
        } else {
            forceLoad();
        }
    }

    @Override
    public List<Bitmap> loadInBackground() {
        List<Bitmap> bitmaps = null;
        try {
            bitmaps = extractBitmap(mURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmaps;
    }

    @Override
    public void deliverResult(List<Bitmap> data) {
        super.deliverResult(data);
        mBitmaps = data;
    }

    private List<Bitmap> extractBitmap(URL url) throws IOException {
        InputStream inputStream = url.openConnection().getInputStream();
        List<Bitmap> bitmaps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            bitmaps.add(bitmap);
        }
        return bitmaps;
    }
}
