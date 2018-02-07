package com.example.fs_sournary.networkingsample.sample3.screen;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.fs_sournary.networkingsample.sample3.data.model.Earthquake;
import com.example.fs_sournary.networkingsample.sample3.util.Constant;
import com.example.fs_sournary.networkingsample.sample3.util.NetworkUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by fs-sournary.
 * Data: 1/31/18.
 * Description:
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private List<Earthquake> mEarthquakes;

    public EarthquakeLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (mEarthquakes != null) {
            deliverResult(mEarthquakes);
        } else {
            forceLoad();
        }
    }

    @Override
    public List<Earthquake> loadInBackground() {
        try {
            URL url = new URL(Constant.USGS_REQUEST_URL);
            return NetworkUtil.getEarthquakes(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deliverResult(List<Earthquake> data) {
        super.deliverResult(data);
        mEarthquakes = data;
    }
}
