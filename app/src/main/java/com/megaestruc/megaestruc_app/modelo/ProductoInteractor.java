package com.megaestruc.megaestruc_app.modelo;

import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.RequestQueue;
import com.megaestruc.megaestruc_app.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductoInteractor {
    private static final String TAG = "ProductoInteractor";
    private RequestQueue queue;

    public interface onDetailFetched{
        void onSuccess(JSONArray producto);
        void onFailure();
    }

    public void remoteFetch(final onDetailFetched listener){
        String url = "http://megaestruc.herokuapp.com/api/producto/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray mJsonArray = response.getJSONArray("productos");
                    listener.onSuccess(mJsonArray);
                }catch (JSONException e){
                    e.printStackTrace();
                    listener.onFailure();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailure();
                Log.e("Error", "onErrorResponse: ", error);
            }
        }
        );
        queue.add(request);
    }
}
