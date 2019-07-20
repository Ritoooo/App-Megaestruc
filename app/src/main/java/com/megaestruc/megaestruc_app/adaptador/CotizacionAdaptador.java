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
import com.megaestruc.megaestruc_app.modelo.Cotizacion;
import com.megaestruc.megaestruc_app.modelo.Producto;

import java.util.List;

public class CotizacionAdaptador extends RecyclerView.Adapter<CotizacionAdaptador.ViewHolder>{

    private Context context;
    private List<Cotizacion> data;



    public CotizacionAdaptador(Context context, List<Cotizacion> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CotizacionAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cotizacion_rows,viewGroup,false);
        return new CotizacionAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CotizacionAdaptador.ViewHolder viewHolder, int position) {
        viewHolder.user_id.setText("Cliente: "+data.get(position).getUser_id());
        viewHolder.sub_total.setText("Sub Total: "+data.get(position).getSub_total());
        viewHolder.igv.setText(String.valueOf("IGV: "+data.get(position).getIgv()));
        viewHolder.descuento.setText(String.valueOf("Descuento: "+data.get(position).getDescuento()));
        viewHolder.total.setText(String.valueOf("Total: "+data.get(position).getTotal()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout card;
        TextView user_id;
        TextView sub_total;
        TextView igv;
        TextView descuento;
        TextView total;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            user_id = itemView.findViewById(R.id.user_id);
            sub_total = itemView.findViewById(R.id.sub_tota);
            igv = itemView.findViewById(R.id.igv);
            descuento = itemView.findViewById(R.id.descuento);
            total = itemView.findViewById(R.id.total);
        }
    }

}