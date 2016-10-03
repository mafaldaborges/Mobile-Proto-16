package mafalda.lesson7hw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.button) Button button;
    @BindView(R.id.input) EditText input;
    @BindView(R.id.price) TextView price;

    private final String TAG = this.getClass().getName();

    private Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            /**Tries to take in the JSON array with the stock information, extract the price, and display the price*/
            try{
                JSONArray company = new JSONArray(response.substring(3));
                String stockPrice = extractPriceFromJSON(company);
                price.setText(stockPrice);
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        /**Handles errors that occur when getting a response*/
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "A VolleyError occurred.");
            error.printStackTrace();
        }
    };

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        final Context c = this.getContext();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Displays stock price when user clicks a button*/
                String stockUrl = buildSearchURL(input.getText().toString());
                StringRequest stringRequest = new StringRequest(Request.Method.GET, stockUrl, responseListener, errorListener);
                MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);

            }
        });

        return view;
    }



    private String buildSearchURL(String companyTicker) {
        /**Builds the url to create the request*/
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("finance.google.com")
                .appendPath("finance")
                .appendPath("info")
                .appendQueryParameter("info","iq")
                .appendQueryParameter("q",companyTicker);
        String stockUrl = builder.build().toString();

        return stockUrl;
    }

    private String extractPriceFromJSON(JSONArray array) throws JSONException {
        /**Parces the JSON array to get the stock price*/

        JSONObject jsonObject = array.getJSONObject(0);
        String stockPrice = jsonObject.getString("l");
        return stockPrice;
    }

}
