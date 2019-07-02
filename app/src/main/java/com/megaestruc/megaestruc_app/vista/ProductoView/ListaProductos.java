package com.megaestruc.megaestruc_app.vista.ProductoView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.megaestruc.megaestruc_app.Interface.ListarProductoView;
import com.megaestruc.megaestruc_app.Producto;
import com.megaestruc.megaestruc_app.R;
import com.megaestruc.megaestruc_app.base.BaseActivity;
import com.megaestruc.megaestruc_app.presentador.ListaProductosPresenter;

public class ListaProductos extends BaseActivity<ListaProductosPresenter> implements ListarProductoView {

    ProgressBar pgcargar;

    @NonNull
    @Override
    protected ListaProductosPresenter createPresenter(@NonNull Context context) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_productos);
        //pgcargar = (ProgressBar)findViewById(R.id.pgListaProductosCargando);
    }

    @Override
    public void mostrarProgressBar() {
        pgcargar.setVisibility(View.VISIBLE);
    }

    @Override
    public void esconderProgressBar() {
        pgcargar.setVisibility(View.GONE);
    }

    @Override
    public void mostrarProductos() {

    }

    @Override
    public void listarProductos(Producto productoista) {

    }
}
