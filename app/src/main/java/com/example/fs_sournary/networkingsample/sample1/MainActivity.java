package com.example.fs_sournary.networkingsample.sample1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.fs_sournary.networkingsample.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String REQUEST_METHOD = "GET";
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2012-01-01" +
                    "&endtime=2012-12-01&minmagnitude=6";
    private TextView mDateTextView;

    public static Intent newInstance(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDateTextView = findViewById(R.id.text_data);

        // Get response from server using separate thread.

    }

//    private void updateUI(Event earthquake) {
//        mDateTextView.setText(earthquake.getTitle());
//    }
//
//    private class MyAsyncTaskLoader extends AsyncTask<URL, Void, Event> {
//
//        @Override
//        protected Event doInBackground(URL... urls) {
//            URL url = urls[0];
//            String jsonResponse = "";
//            try {
//                jsonResponse = makeHttpRequest(url);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return extractFeatureFromJson(jsonResponse);
//        }
//
//        @Override
//        protected void onPostExecute(Event event) {
//            super.onPostExecute(event);
//            if (event == null) {
//                return;
//            }
//            updateUI(event);
//        }
//
//        private String makeHttpRequest(URL url) throws IOException {
//            String jsonResponse = "";
//            if (url == null) {
//                return jsonResponse;
//            }
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod(REQUEST_METHOD);
//            urlConnection.setReadTimeout(10000);
//            urlConnection.setConnectTimeout(10000);
//            urlConnection.connect();
//            if (urlConnection.getResponseCode() == 200) {
//                InputStream inputStream = urlConnection.getInputStream();
//                jsonResponse = readFromStream(inputStream);
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//            }
//            urlConnection.disconnect();
//            return jsonResponse;
//        }
//
//        private String readFromStream(InputStream inputStream) throws IOException {
//            if (inputStream == null) {
//                return null;
//            }
//            StringBuilder output = new StringBuilder();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                output.append(line);
//                line = bufferedReader.readLine();
//            }
//            return output.toString();
//        }
//
//        private Event extractFeatureFromJson(String jsonResponse) {
//            if (TextUtils.isEmpty(jsonResponse)) {
//                return null;
//            }
//            try {
//                JSONObject baseJsonResponse = new JSONObject(jsonResponse);
//                JSONArray featureArray = baseJsonResponse.getJSONArray("features");
//
//                // If there are results in the features array
//                if (featureArray.length() > 0) {
//                    // Extract out the first feature (which is an earthquake)
//                    JSONObject firstFeature = featureArray.getJSONObject(0);
//                    JSONObject properties = firstFeature.getJSONObject("properties");
//
//                    // Extract out the title, time, and tsunami values
//                    String title = properties.getString("title");
//                    long time = properties.getLong("time");
//                    int tsunamiAlert = properties.getInt("tsunami");
//
//                    // Create a new {@link Event} object
//                    return new Event(title, time, tsunamiAlert);
//                }
//            } catch (JSONException e) {
//                Log.d(TAG, "Problem while passing result from JSON String: " + e.getMessage());
//            }
//            return null;
//        }
//    }
}
