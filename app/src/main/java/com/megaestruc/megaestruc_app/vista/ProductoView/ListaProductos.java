package com.megaestruc.megaestruc_app.vista.ProductoView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.megaestruc.megaestruc_app.Interface.ProductoInterface;
import com.megaestruc.megaestruc_app.modelo.Producto;
import com.megaestruc.megaestruc_app.R;
import com.megaestruc.megaestruc_app.base.BaseActivity;
import com.megaestruc.megaestruc_app.modelo.ProductoInteractor;
import com.megaestruc.megaestruc_app.presentador.ListaProductosPresenter;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;

public class ListaProductos extends BaseActivity<ListaProductosPresenter> implements ProductoInterface {

    ProgressBar pgcargar;
    private TextView mJsonTxtView;

    @NonNull
    @Override
    protected ListaProductosPresenter createPresenter(@NonNull Context context) {
        return new ListaProductosPresenter(this, new ProductoInteractor());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_productos);
        //pgcargar = (ProgressBar)findViewById(R.id.)
        pgcargar = (ProgressBar)findViewById(R.id.pgcargar);
        mJsonTxtView = findViewById(R.id.jsonText);
        //Toast.makeText(ListaProductos.this, "ERRORES XD", Toast.LENGTH_SHORT).show();
        fetchProductos();
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
    public void mostrarProductos(Producto productos) {

        Toast.makeText(ListaProductos.this, "HOLA XD", Toast.LENGTH_SHORT).show();
        Toast.makeText(ListaProductos.this, "hey: "+productos, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void listarProductos(Producto productoista) {

    }

    @Override
    public void fetchProductos() {
        presenter.fetchData();
    }

    @Override
    public void mostrarError(){
        Toast.makeText(ListaProductos.this, "ERRORES en Rettrofit", Toast.LENGTH_SHORT).show();
        Log.d("RETROFITTTTTT","onFailure");
    }
}
