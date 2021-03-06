package com.megaestruc.megaestruc_app.presentador;

import com.megaestruc.megaestruc_app.Interface.ProductoInterface;
import com.megaestruc.megaestruc_app.base.BasePresenter;
import com.megaestruc.megaestruc_app.modelo.Producto;
import com.megaestruc.megaestruc_app.DAO.ProductoInteractor;

import java.util.ArrayList;

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

    @Override
    public void onSuccess(ArrayList<Producto> producto) {
        view.esconderProgressBar();
        view.mostrarProductos(producto);
    }

    @Override
    public void onFailure() {
        view.mostrarError();
    }
}
