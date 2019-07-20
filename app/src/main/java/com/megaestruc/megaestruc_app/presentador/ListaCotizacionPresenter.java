package com.megaestruc.megaestruc_app.presentador;

import com.megaestruc.megaestruc_app.DAO.ClienteDAO;
import com.megaestruc.megaestruc_app.DAO.CotizacionDAO;
import com.megaestruc.megaestruc_app.Interface.ClienteInterface;
import com.megaestruc.megaestruc_app.Interface.CotizacionInterface;
import com.megaestruc.megaestruc_app.base.BasePresenter;
import com.megaestruc.megaestruc_app.modelo.Cliente;
import com.megaestruc.megaestruc_app.modelo.Cotizacion;

import java.util.ArrayList;

public class ListaCotizacionPresenter extends BasePresenter implements CotizacionDAO.onDetailFetched{
    private CotizacionInterface view;
    private CotizacionDAO cotizacionDAO;

    public ListaCotizacionPresenter(CotizacionInterface view, CotizacionDAO cotizacionDAO){
        this.view = view;
        this.cotizacionDAO = cotizacionDAO;
    }

    public void fetchData(){
        view.mostrarProgressBar();
        cotizacionDAO.remoteFetch( this);
    }

    @Override
    public void onSuccess(ArrayList<Cotizacion> cotizaciones) {
        view.esconderProgressBar();
        view.mostrarCotizaciones(cotizaciones);
    }

    @Override
    public void onFailure() {
        view.mostrarError();
    }
}
