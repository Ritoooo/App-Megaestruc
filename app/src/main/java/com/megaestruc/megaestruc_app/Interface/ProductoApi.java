package com.megaestruc.megaestruc_app.Interface;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.megaestruc.megaestruc_app.modelo.Producto;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductoApi {
    @GET("api/producto")
    Call<JsonObject> getProductos();
}
