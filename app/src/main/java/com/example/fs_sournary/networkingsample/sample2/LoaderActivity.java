package com.example.fs_sournary.networkingsample.sample2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.fs_sournary.networkingsample.R;
import com.example.fs_sournary.networkingsample.sample2.util.Constant;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class LoaderActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Bitmap>> {

    public static Intent newInstance(Context context){
        return new Intent(context, LoaderActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        getSupportLoaderManager().initLoader(1, null, this);
    }


    @Override
    public Loader<List<Bitmap>> onCreateLoader(int id, Bundle args) {
        try {
            URL url = new URL(Constant.DEF_URL);
            return new MyLoader(this, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Bitmap>> loader, List<Bitmap> data) {
        Toast.makeText(this, "Size: " + data.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(Loader<List<Bitmap>> loader) {

    }
}
