package com.megaestruc.megaestruc_app.vista.ProductoView;

import android.content.Context;
import android.support.annotation.NonNull;

import com.megaestruc.megaestruc_app.Interface.ListarProductoView;
import com.megaestruc.megaestruc_app.Producto;
import com.megaestruc.megaestruc_app.base.BaseActivity;
import com.megaestruc.megaestruc_app.presentador.ListaProductosPresenter;

public class ListarProducto extends BaseActivity<ListaProductosPresenter> implements ListarProductoView {

    
    @Override
    public void mostrarProgressBar() {

    }

    @Override
    public void esconderProgressBar() {

    }

    @Override
    public void mostrarProductos() {

    }

    @Override
    public void listarProductos(Producto productoista) {

    }

    @NonNull
    @Override
    protected ListaProductosPresenter createPresenter(@NonNull Context context) {
        return null;
    }
}
