package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.Producto;

public interface ListarProductoView {
    void mostrarProgressBar();
    void esconderProgressBar();
    void mostrarProductos();
    void listarProductos(Producto productoista);
}
