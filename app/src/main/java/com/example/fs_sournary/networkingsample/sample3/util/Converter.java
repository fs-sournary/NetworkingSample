package com.example.fs_sournary.networkingsample.sample3.util;

import com.example.fs_sournary.networkingsample.R;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by fs-sournary.
 * Data: 1/31/18.
 * Description:
 */

public class Converter {

    private static final String MAG_FORMAT = "0.0";
    private static final String DATE_FORMAT = "MMM dd, yyyy";
    private static final String TIME_FORMAT = "h:mm a";
    private static final String SPLIT_TEXT = " of ";

    public static String getMagnitude(double mag) {
        DecimalFormat format = new DecimalFormat(MAG_FORMAT);
        return format.format(mag);
    }

    public static String getDate(long timeInMilliseconds) {
        Date date = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return dateFormat.format(date);
    }

    public static String getTime(long timeInMilliseconds) {
        Date date = new Date(timeInMilliseconds);
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault());
        return timeFormat.format(date);
    }

    public static List<String> getDetailLocations(String location) {
        List<String> detailLocations = new ArrayList<>();
        if (!location.contains(SPLIT_TEXT)) {
            detailLocations.add(location);
            return detailLocations;
        }
        int indexSplit = location.indexOf(SPLIT_TEXT);
        detailLocations.add(location.substring(0, indexSplit));
        detailLocations.add(location.substring(indexSplit + 4, location.length()));
        return detailLocations;
    }

    public static int getBackgroundMag(double mag) {
        int magnitude = (int) mag;
        switch (magnitude) {
            case 0:
            case 1:
                return R.color.magnitude1;
            case 2:
                return R.color.magnitude2;
            case 3:
                return R.color.magnitude3;
            case 4:
                return R.color.magnitude4;
            case 5:
                return R.color.magnitude5;
            case 6:
                return R.color.magnitude6;
            case 7:
                return R.color.magnitude7;
            case 8:
                return R.color.magnitude8;
            case 9:
                return R.color.magnitude9;
            default:
                return R.color.magnitude10plus;
        }
    }
}
