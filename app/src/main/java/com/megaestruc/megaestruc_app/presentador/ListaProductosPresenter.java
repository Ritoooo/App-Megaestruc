package com.megaestruc.megaestruc_app.presentador;

import com.megaestruc.megaestruc_app.Interface.ListarProductoView;
import com.megaestruc.megaestruc_app.Producto;
import com.megaestruc.megaestruc_app.base.BasePresenter;
import com.megaestruc.megaestruc_app.modelo.ProductoInteractor;

import org.json.JSONArray;

public class ListaProductosPresenter extends BasePresenter  implements ProductoInteractor.onDetailFetched{
    private ListarProductoView view;
    private ProductoInteractor productoInteractor;

    public ListaProductosPresenter(ListarProductoView view, ProductoInteractor productoInteractor){
        this.view = view;
        this.productoInteractor = productoInteractor;
    }

    public void fetchData(){
        view.mostrarProgressBar();
        productoInteractor.remoteFetch( this);
    }

    @Override
    public void onSuccess(JSONArray producto) {
        view.esconderProgressBar();
        view.mostrarProductos(producto);
    }

    @Override
    public void onFailure() {

    }
}
