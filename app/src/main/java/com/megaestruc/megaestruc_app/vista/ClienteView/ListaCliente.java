package com.megaestruc.megaestruc_app.vista.ClienteView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.megaestruc.megaestruc_app.DAO.ClienteDAO;
import com.megaestruc.megaestruc_app.Interface.ClienteInterface;
import com.megaestruc.megaestruc_app.R;
import com.megaestruc.megaestruc_app.adaptador.ClienteAdaptador;
import com.megaestruc.megaestruc_app.base.BaseActivity;
import com.megaestruc.megaestruc_app.modelo.Cliente;
import com.megaestruc.megaestruc_app.presentador.ListaClientePresenter;

import java.util.ArrayList;

public class ListaCliente extends BaseActivity<ListaClientePresenter> implements ClienteInterface {

    ProgressBar pgcargar;
    private RecyclerView rvLista;
    @NonNull
    @Override
    protected ListaClientePresenter createPresenter(@NonNull Context context) {
        return new ListaClientePresenter(this, new ClienteDAO());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cliente);
        pgcargar = (ProgressBar)findViewById(R.id.pgcargar);
        rvLista = findViewById(R.id.rvLista);
        fetchClientes();
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
    public void mostrarClientes(ArrayList<Cliente> productos) {
        Toast.makeText(ListaCliente.this, "hey: "+productos, Toast.LENGTH_SHORT).show();
        ClienteAdaptador adaptador = new ClienteAdaptador(this, productos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvLista.setLayoutManager(llm);
        rvLista.setAdapter(adaptador);
    }

    @Override
    public void fetchClientes() {
        presenter.fetchData();
    }

    @Override
    public void mostrarError() {
        Toast.makeText(ListaCliente.this, "ERRORES en Rettrofit", Toast.LENGTH_SHORT).show();
        Log.d("RETROFITTTTTT","onFailure");
    }
}
