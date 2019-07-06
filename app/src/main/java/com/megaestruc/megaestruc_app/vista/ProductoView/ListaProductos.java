package com.megaestruc.megaestruc_app.vista.ProductoView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.megaestruc.megaestruc_app.Interface.ListarProductoView;
import com.megaestruc.megaestruc_app.MainActivity;
import com.megaestruc.megaestruc_app.Producto;
import com.megaestruc.megaestruc_app.R;
import com.megaestruc.megaestruc_app.base.BaseActivity;
import com.megaestruc.megaestruc_app.modelo.ProductoInteractor;
import com.megaestruc.megaestruc_app.presentador.ListaProductosPresenter;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListaProductos extends BaseActivity<ListaProductosPresenter> implements ListarProductoView {

    ProgressBar pgcargar;

    @NonNull
    @Override
    protected ListaProductosPresenter createPresenter(@NonNull Context context) {
        return new ListaProductosPresenter(this, new ProductoInteractor());
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
    public void mostrarProductos(JSONArray productos) {
        try{
            for(int i = 0; i < productos.length(); i++){
                JSONObject mJsonObject = productos.getJSONObject(i);
                String name = mJsonObject.getString("nombre");
                String descripcion = mJsonObject.getString("descripcion");
                int stock = mJsonObject.getInt("stock");
                double preVen = mJsonObject.getDouble("preVen");
                Toast.makeText(ListaProductos.this, "Nombre: "+name+"\nDescripción: "+descripcion+"\nStock: "+stock+"\nPrecio de Venta: "+preVen, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){

        }
    }

    @Override
    public void listarProductos(Producto productoista) {

    }
}
