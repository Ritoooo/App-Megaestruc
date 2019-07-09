package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Producto;
import java.util.ArrayList;


public interface ProductoInterface {

    void mostrarProgressBar();
    void esconderProgressBar();
    void mostrarProductos(ArrayList<Producto> productos);
    void listarProductos(Producto productoista);
    void fetchProductos();
    void mostrarError();
}
