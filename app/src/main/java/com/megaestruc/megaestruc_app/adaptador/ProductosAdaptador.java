package com.megaestruc.megaestruc_app.adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.megaestruc.megaestruc_app.Producto;
import com.megaestruc.megaestruc_app.R;

import java.util.List;

public class ProductosAdaptador extends RecyclerView.Adapter<ProductosAdaptador.ProductosHolder> {
    List<Producto> listaProductos;
    public ProductosAdaptador(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }
    @NonNull
    @Override
    public ProductosAdaptador.ProductosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_productos,parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new ProductosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosAdaptador.ProductosHolder productosHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ProductosHolder extends RecyclerView.ViewHolder{

        public ProductosHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
