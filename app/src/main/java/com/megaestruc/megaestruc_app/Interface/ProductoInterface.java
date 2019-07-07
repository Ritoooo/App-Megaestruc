package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Producto;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoInterface {

    void mostrarProgressBar();
    void esconderProgressBar();
    void mostrarProductos(Producto productos);
    void listarProductos(Producto productoista);
    void fetchProductos();
    void mostrarError();
}
