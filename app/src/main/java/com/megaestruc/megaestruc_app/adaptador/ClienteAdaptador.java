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
import com.megaestruc.megaestruc_app.modelo.Cliente;

import java.util.List;

public class ClienteAdaptador extends RecyclerView.Adapter<ClienteAdaptador.ViewHolder>{

    private Context context;
    private List<Cliente> data;



    public ClienteAdaptador(Context context, List<Cliente> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ClienteAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_rows,viewGroup,false);
        return new ClienteAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdaptador.ViewHolder viewHolder, int position) {
        viewHolder.nombre.setText("Razón Social: "+data.get(position).getRaz_social());
        viewHolder.descripcion.setText("Dirección: "+data.get(position).getDireccion());
        viewHolder.preVen.setText("Teléfono: "+data.get(position).getTelefono());
        viewHolder.stock.setText("Email: "+data.get(position).getEmail());
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

