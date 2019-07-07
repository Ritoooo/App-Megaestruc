package com.megaestruc.megaestruc_app.modelo;

import java.util.Date;

public class Producto {
    private String nombre, descripcion;
    private double preVen;
    private int stock, id;
    public Date created_at, updated_at;

    public double getPreVen() {
        return preVen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setPreVen(double preVen) {
        this.preVen = preVen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto(String nombre, String descripcion, double preVen, int stock, int id, Date created_at, Date updated_at) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preVen = preVen;
        this.stock = stock;
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
