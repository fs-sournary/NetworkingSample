package com.example.fs_sournary.networkingsample.sample3.screen;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fs_sournary.networkingsample.R;
import com.example.fs_sournary.networkingsample.sample3.data.model.Earthquake;
import com.example.fs_sournary.networkingsample.sample3.util.Converter;

import java.util.List;

/**
 * Created by fs-sournary.
 * Data: 1/31/18.
 * Description:
 */

public class EarthquakeAdapter
        extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {

    private List<Earthquake> mEarthquakes;
    private OnItemRecyclerViewClick mClick;
    private Context mContext;

    EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        mEarthquakes = earthquakes;
        mContext = context;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_earthquake, parent, false);
        return new EarthquakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EarthquakeViewHolder holder, int position) {
        holder.bindView(mEarthquakes.get(position));
    }

    @Override
    public int getItemCount() {
        return mEarthquakes != null ? mEarthquakes.size() : 0;
    }

    void setClick(OnItemRecyclerViewClick click) {
        mClick = click;
    }

    public interface OnItemRecyclerViewClick {
        void onItemClick(Earthquake earthquake);
    }

    class EarthquakeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mMagTextView;
        private TextView mDistanceTextView;
        private TextView mLocationTextView;
        private TextView mDateTextView;
        private TextView mTimeTextView;
        private Earthquake mEarthquake;

        EarthquakeViewHolder(View itemView) {
            super(itemView);
            mMagTextView = itemView.findViewById(R.id.text_mag);
            mDistanceTextView = itemView.findViewById(R.id.text_location_distance);
            mLocationTextView = itemView.findViewById(R.id.text_primary_location);
            mDateTextView = itemView.findViewById(R.id.text_date);
            mTimeTextView = itemView.findViewById(R.id.text_time);
            itemView.setOnClickListener(this);
        }

        void bindView(Earthquake earthquake) {
            mEarthquake = earthquake;
            mMagTextView.setText(Converter.getMagnitude(earthquake.getMagnitude()));
            GradientDrawable drawable = (GradientDrawable) mMagTextView.getBackground();
            int color = ContextCompat.getColor(
                    mContext, Converter.getBackgroundMag(earthquake.getMagnitude()));
            drawable.setColor(color);
            String location = earthquake.getLocation();
            List<String> detailLocations = Converter.getDetailLocations(location);
            if (detailLocations.size() == 1) {
                mLocationTextView.setText(location);
            } else {
                mDistanceTextView.setText(detailLocations.get(0));
                mLocationTextView.setText(detailLocations.get(1));
            }
            mDateTextView.setText(Converter.getDate(earthquake.getTimeInMilliseconds()));
            mTimeTextView.setText(Converter.getTime(earthquake.getTimeInMilliseconds()));
        }

        @Override
        public void onClick(View view) {
            mClick.onItemClick(mEarthquake);
        }
    }
}
