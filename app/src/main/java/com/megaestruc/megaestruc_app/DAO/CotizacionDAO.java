package com.megaestruc.megaestruc_app.DAO;

import android.util.Log;

import com.megaestruc.megaestruc_app.Interface.ClienteApi;
import com.megaestruc.megaestruc_app.Interface.CotizacionApi;
import com.megaestruc.megaestruc_app.modelo.Cliente;
import com.megaestruc.megaestruc_app.modelo.Cotizacion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CotizacionDAO {
    private static final String TAG = "CotizacionInteractor";
    private static final String BASE_URL = "http://megaestruc.herokuapp.com/";

    public interface onDetailFetched{
        void onSuccess(ArrayList<Cotizacion> cotizaciones);
        void onFailure();
    }

    public void remoteFetch(final CotizacionDAO.onDetailFetched listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final CotizacionApi service = retrofit.create(CotizacionApi.class);
        Call<ArrayList<Cotizacion>> call = service.getCotizacion();
        call.enqueue(new Callback<ArrayList<Cotizacion>>() {
            @Override
            public void onResponse(Call<ArrayList<Cotizacion>> call, retrofit2.Response<ArrayList<Cotizacion>> response) {
                if(!response.isSuccessful()){
                    listener.onFailure();
                    Log.e(TAG, "onFailure pero de response : "+response);
                    return;
                }
                ArrayList<Cotizacion> cotizaciones =  response.body();
                if(cotizaciones!=null)
                    listener.onSuccess(cotizaciones);
            }
            @Override
            public void onFailure(Call<ArrayList<Cotizacion>> call, Throwable t) {
                listener.onFailure();
                Log.e(TAG, "onFailure pero failure: "+t.getMessage()+" ...");
            }
        });
    }
}
