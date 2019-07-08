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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ProductoInteractor {
    private static final String TAG = "ProductoInteractor";
    private static final String BASE_URL = "http://megaestruc.herokuapp.com/";

    public interface onDetailFetched{
        void onSuccess(ArrayList<Producto> producto);
        void onFailure();
    }

    public void remoteFetch(final onDetailFetched listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ProductoApi service = retrofit.create(ProductoApi.class);
        Call<ArrayList<Producto>> call = service.getProductos();
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, retrofit2.Response<ArrayList<Producto>> response) {
                if(!response.isSuccessful()){
                    listener.onFailure();
                    Log.e(TAG, "onFailure pero de response : "+response);
                    return;
                }
                ArrayList<Producto> producto =  response.body();
                if(producto!=null)
                    listener.onSuccess(producto);
                Log.e(TAG, producto.get(10).getDescripcion());
            }
            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                listener.onFailure();
                Log.e(TAG, "onFailure pero failure: "+t.getMessage()+" ...");
            }
        });
    }
}
