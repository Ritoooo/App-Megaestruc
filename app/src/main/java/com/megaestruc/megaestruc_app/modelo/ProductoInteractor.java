package com.megaestruc.megaestruc_app.modelo;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.RequestQueue;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.megaestruc.megaestruc_app.BuildConfig;
import com.megaestruc.megaestruc_app.Interface.ProductoApi;
import com.megaestruc.megaestruc_app.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ProductoInteractor {
    private static final String TAG = "ProductoInteractor";
    private RequestQueue queue;
    private static final String BASE_URL = "http://megaestruc.herokuapp.com/";

    public interface onDetailFetched{
        void onSuccess(JsonObject producto);
        void onFailure();
    }

    public void remoteFetch(final onDetailFetched listener){
        /*String url = "http://megaestruc.herokuapp.com/api/producto/";

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
        queue.add(request);*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoApi service = retrofit.create(ProductoApi.class);
        Call<JsonObject> call = service.getProductos();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                if(!response.isSuccessful()){
                    listener.onFailure();
                    Log.e(TAG, "onFailure pero de response: "+response);
                    return;
                }
                //List<Producto> listProducto = (response).body();
                JsonObject producto =  response.body();

                if(producto!=null)
                    listener.onSuccess(producto);

                Log.e(TAG, "Response : "+producto);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                listener.onFailure();
                Log.e(TAG, "onFailure pero failure: "+t.getMessage());
            }
        });
    }
}
