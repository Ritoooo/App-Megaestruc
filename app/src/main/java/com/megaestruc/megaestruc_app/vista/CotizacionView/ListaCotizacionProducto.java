package com.megaestruc.megaestruc_app.vista.CotizacionView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.megaestruc.megaestruc_app.DAO.CotizacionDAO;
import com.megaestruc.megaestruc_app.Interface.CotizacionInterface;
import com.megaestruc.megaestruc_app.R;
import com.megaestruc.megaestruc_app.adaptador.CotizacionAdaptador;
import com.megaestruc.megaestruc_app.base.BaseActivity;
import com.megaestruc.megaestruc_app.modelo.Cotizacion;
import com.megaestruc.megaestruc_app.presentador.ListaClientePresenter;
import com.megaestruc.megaestruc_app.presentador.ListaCotizacionPresenter;

import java.util.ArrayList;

public class ListaCotizacionProducto extends BaseActivity<ListaCotizacionPresenter> implements CotizacionInterface {

    ProgressBar pgcargar;
    private RecyclerView rvLista;

    @NonNull
    @Override
    protected ListaCotizacionPresenter createPresenter(@NonNull Context context) {
        return new ListaCotizacionPresenter(this, new CotizacionDAO());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cotizacion);
        pgcargar = (ProgressBar) findViewById(R.id.pgcargar);
        rvLista = findViewById(R.id.rvLista);
        fetchCotizaciones();
    }

    @Override
    public void mostrarProgressBar() {  pgcargar.setVisibility(View.VISIBLE);    }

    @Override
    public void esconderProgressBar()  {
        pgcargar.setVisibility(View.GONE);
    }

    @Override
    public void mostrarCotizaciones(ArrayList<Cotizacion> cotizaciones) {
        CotizacionAdaptador adaptador = new CotizacionAdaptador(this, cotizaciones);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvLista.setLayoutManager(llm);
        rvLista.setAdapter(adaptador);
    }

    @Override
    public void fetchCotizaciones()  {
        presenter.fetchData();
    }

    @Override
    public void mostrarError() {
        Toast.makeText(ListaCotizacionProducto.this, "ERRORES en Rettrofit", Toast.LENGTH_SHORT).show();
        Log.d("RETROFITTTTTT","onFailure");
    }
}
