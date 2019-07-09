package com.megaestruc.megaestruc_app.DAO;

import android.util.Log;

import com.megaestruc.megaestruc_app.Interface.ClienteApi;
import com.megaestruc.megaestruc_app.Interface.ProductoApi;
import com.megaestruc.megaestruc_app.modelo.Cliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteDAO {
    private static final String TAG = "ProductoInteractor";
    private static final String BASE_URL = "http://megaestruc.herokuapp.com/";

    public interface onDetailFetched{
        void onSuccess(ArrayList<Cliente> clientes);
        void onFailure();
    }

    public void remoteFetch(final onDetailFetched listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ClienteApi service = retrofit.create(ClienteApi.class);
        Call<ArrayList<Cliente>> call = service.getClientes();
        call.enqueue(new Callback<ArrayList<Cliente>>() {
            @Override
            public void onResponse(Call<ArrayList<Cliente>> call, retrofit2.Response<ArrayList<Cliente>> response) {
                if(!response.isSuccessful()){
                    listener.onFailure();
                    Log.e(TAG, "onFailure pero de response : "+response);
                    return;
                }
                ArrayList<Cliente> clientes =  response.body();
                if(clientes!=null)
                    listener.onSuccess(clientes);
            }
            @Override
            public void onFailure(Call<ArrayList<Cliente>> call, Throwable t) {
                listener.onFailure();
                Log.e(TAG, "onFailure pero failure: "+t.getMessage()+" ...");
            }
        });
    }
}

