package com.megaestruc.megaestruc_app.presentador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.megaestruc.megaestruc_app.Interface.ProductoInterface;
import com.megaestruc.megaestruc_app.base.BasePresenter;
import com.megaestruc.megaestruc_app.modelo.Producto;
import com.megaestruc.megaestruc_app.modelo.ProductoInteractor;

import org.json.JSONArray;

import java.util.List;

public class ListaProductosPresenter extends BasePresenter  implements ProductoInteractor.onDetailFetched{
    private ProductoInterface view;
    private ProductoInteractor productoInteractor;

    public ListaProductosPresenter(ProductoInterface view, ProductoInteractor productoInteractor){
        this.view = view;
        this.productoInteractor = productoInteractor;
    }

    public void fetchData(){
        view.mostrarProgressBar();
        productoInteractor.remoteFetch( this);
    }

    /*@Override
    public void onSuccess(JSONArray producto) {
        view.esconderProgressBar();
        view.mostrarProductos(producto);
    }*/

    @Override
    public void onSuccess(JsonObject producto) {
        view.esconderProgressBar();
        view.mostrarProductos(producto);
    }

    @Override
    public void onFailure() {
        view.mostrarError();
    }
}
