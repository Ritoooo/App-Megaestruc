package com.megaestruc.megaestruc_app.modelo;

public class Cliente {
    private int id;
    private int distrito_id;
    private String raz_social;
    private String ruc;
    private String direccion;
    private String telefono;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistrito_id() {
        return distrito_id;
    }

    public void setDistrito_id(int distrito_id) {
        this.distrito_id = distrito_id;
    }

    public String getRaz_social() {
        return raz_social;
    }

    public void setRaz_social(String raz_social) {
        this.raz_social = raz_social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(int id, int distrito_id, String raz_social, String ruc, String direccion, String telefono, String email) {
        this.id = id;
        this.distrito_id = distrito_id;
        this.raz_social = raz_social;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
}
