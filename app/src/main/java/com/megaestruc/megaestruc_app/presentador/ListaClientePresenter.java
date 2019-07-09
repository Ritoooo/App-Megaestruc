package com.megaestruc.megaestruc_app.presentador;

import com.megaestruc.megaestruc_app.DAO.ClienteDAO;
import com.megaestruc.megaestruc_app.Interface.ClienteInterface;
import com.megaestruc.megaestruc_app.base.BasePresenter;
import com.megaestruc.megaestruc_app.modelo.Cliente;

import java.util.ArrayList;

public class ListaClientePresenter extends BasePresenter implements ClienteDAO.onDetailFetched{
    private ClienteInterface view;
    private ClienteDAO clienteDAO;

    public ListaClientePresenter(ClienteInterface view, ClienteDAO clienteDAO){
        this.view = view;
        this.clienteDAO = clienteDAO;
    }

    public void fetchData(){
        view.mostrarProgressBar();
        clienteDAO.remoteFetch( this);
    }

    @Override
    public void onSuccess(ArrayList<Cliente> clientes) {
        view.esconderProgressBar();
        view.mostrarClientes(clientes);
    }

    @Override
    public void onFailure() {
        view.mostrarError();
    }
}

