package com.megaestruc.megaestruc_app.modelo;

public class ProductoInteractor {
    private static final String TAG = "ProductoInteractor";
    public interface onDetailFetched{
        void onSucces(Producto producto);
    }
}
