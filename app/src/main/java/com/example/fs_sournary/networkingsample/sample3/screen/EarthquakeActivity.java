package com.example.fs_sournary.networkingsample.sample3.screen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fs_sournary.networkingsample.R;
import com.example.fs_sournary.networkingsample.sample3.data.model.Earthquake;

import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<List<Earthquake>>,
        EarthquakeAdapter.OnItemRecyclerViewClick {

    private RecyclerView mRecyclerView;

    public static Intent newInstance(Context context) {
        return new Intent(context, EarthquakeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);
        mRecyclerView = findViewById(R.id.recycler_earthquake);
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
        return new EarthquakeLoader(EarthquakeActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, data);
        adapter.setClick(this);
        mRecyclerView.setAdapter(adapter);
        findViewById(R.id.progress).setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {

    }

    @Override
    public void onItemClick(Earthquake earthquake) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(earthquake.getUrl()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
