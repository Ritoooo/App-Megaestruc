package com.megaestruc.megaestruc_app.modelo;

public class Cotizacion {
    private int id;
    private String raz_social;
    private double sub_total;
    private double igv;
    private double descuento;
    private double total;

    public Cotizacion(String raz_social, double sub_total, double igv, double descuento, double total) {
        this.raz_social = raz_social;
        this.sub_total = sub_total;
        this.igv = igv;
        this.descuento = descuento;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return raz_social;
    }

    public void setUser_id(String user_id) {
        this.raz_social = user_id;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
