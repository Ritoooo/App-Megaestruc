package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Cliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClienteApi {
    @GET("api/clientes")
    Call<ArrayList<Cliente>> getClientes();
}
