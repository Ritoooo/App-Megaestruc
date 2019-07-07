package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductoApi {
    @GET("api/producto")
    Call<Producto> getProductos();
}
