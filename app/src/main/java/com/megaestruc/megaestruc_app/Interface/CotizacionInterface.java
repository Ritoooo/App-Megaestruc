package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Cliente;
import com.megaestruc.megaestruc_app.modelo.Cotizacion;

import java.util.ArrayList;

public interface CotizacionInterface {
    void mostrarProgressBar();
    void esconderProgressBar();
    void mostrarCotizaciones(ArrayList<Cotizacion> cotizaciones);
    void fetchCotizaciones();
    void mostrarError();
}
