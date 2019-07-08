package com.megaestruc.megaestruc_app.adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.megaestruc.megaestruc_app.R;
import com.megaestruc.megaestruc_app.modelo.Producto;

import java.util.List;

public class ProductosAdaptador extends RecyclerView.Adapter<ProductosAdaptador.ViewHolder>{

    private Context context;
    private List<Producto> data;



    public ProductosAdaptador(Context context, List<Producto> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_rows,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.nombre.setText("Nombre: "+data.get(position).getNombre());
        viewHolder.descripcion.setText("Descripción: "+data.get(position).getDescripcion());
        viewHolder.preVen.setText(String.valueOf("Precio: "+data.get(position).getPreVen()));
        viewHolder.stock.setText(String.valueOf("stock: "+data.get(position).getStock()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout card;
        TextView nombre;
        TextView descripcion;
        TextView preVen;
        TextView stock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            nombre = itemView.findViewById(R.id.txtNombre);
            descripcion = itemView.findViewById(R.id.txtDescripcion);
            preVen = itemView.findViewById(R.id.txtPrecio);
            stock = itemView.findViewById(R.id.txtStock);
        }
    }

}
/*public class ProductosAdaptador{ //extends RecyclerView.Adapter<ProductosAdaptador.ProductosHolder> {
    /*List<Producto> listaProductos;
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
    public void onBindViewHolder(@NonNull ProductosAdaptador.ProductosHolder holder, int posotion) {
        /*holder.txtNombre.setText(listaProductos.get(posotion).getNombre());
        holder.txtDescripcion.setText(listaProductos.get(posotion).getDescripcion());
        holder.txtPrecio.setText(listaProductos.get(posotion).getPrecio());
        holder.txtStock.setText(listaProductos.get(posotion).getStock());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ProductosHolder extends RecyclerView.ViewHolder{

        TextView txtNombre,txtDescripcion, txtPrecio, txtStock;

        public ProductosHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            txtStock = itemView.findViewById(R.id.txtStock);
        }
    }*/
