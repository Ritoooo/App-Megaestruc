package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Cliente;
import com.megaestruc.megaestruc_app.modelo.Cotizacion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CotizacionApi {
    @GET("api/cotizaciones")
    Call<ArrayList<Cotizacion>> getCotizacion();
}
