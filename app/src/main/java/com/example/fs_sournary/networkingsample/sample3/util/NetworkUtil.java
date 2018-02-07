package com.example.fs_sournary.networkingsample.sample3.util;

import android.text.TextUtils;

import com.example.fs_sournary.networkingsample.sample3.data.model.Earthquake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fs-sournary.
 * Data: 1/31/18.
 * Description:
 */

public class NetworkUtil {

    private static final String REQUEST_METHOD = "GET";
    private static final int DEF_READ = 10000;
    private static final int DEF_CONNECT = 10000;

    public static List<Earthquake> getEarthquakes(URL url) {
        String response;
        try {
            response = makeHttpRequest(url);
            return extractFromResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(REQUEST_METHOD);
        urlConnection.setReadTimeout(DEF_READ);
        urlConnection.setConnectTimeout(DEF_CONNECT);
        urlConnection.connect();
        if (urlConnection.getResponseCode() == 200) {
            InputStream inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        }
        urlConnection.disconnect();
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        if (inputStream == null) {
            return builder.toString();
        }
        InputStreamReader inputStreamReader =
                new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        BufferedReader bufferedReader =
                new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            builder.append(line);
            line = bufferedReader.readLine();
        }
        inputStreamReader.close();
        bufferedReader.close();
        return builder.toString();
    }

    private static List<Earthquake> extractFromResponse(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }
        List<Earthquake> earthquakes = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray jsonArray = jsonObject.optJSONArray("features");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.optJSONObject(i);
                JSONObject properties = object.getJSONObject("properties");
                double mag = properties.optDouble("mag");
                String location = properties.optString("place");
                long time = properties.optLong("time");
                String url = properties.optString("url");
                earthquakes.add(new Earthquake(mag, location, time, url));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return earthquakes;
    }
}
