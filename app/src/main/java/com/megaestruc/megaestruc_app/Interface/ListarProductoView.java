package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.Producto;

import org.json.JSONArray;

public interface ListarProductoView {
    void mostrarProgressBar();
    void esconderProgressBar();
    void mostrarProductos(JSONArray productos);
    void listarProductos(Producto productoista);
}
