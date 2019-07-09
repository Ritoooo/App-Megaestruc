package com.megaestruc.megaestruc_app.Interface;

import com.megaestruc.megaestruc_app.modelo.Cliente;

import java.util.ArrayList;

public interface ClienteInterface {
    void mostrarProgressBar();
    void esconderProgressBar();
    void mostrarClientes(ArrayList<Cliente> productos);
    void fetchClientes();
    void mostrarError();
}
