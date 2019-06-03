package com.megaestruc.megaestruc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irCoti(View view){
        Intent objCoti = new Intent(this,Cotizacion.class);
        startActivity(objCoti);
    }
    public void irProd(View view){
        Intent objCoti = new Intent(this,Producto.class);
        startActivity(objCoti);
    }
    public void irClie(View view){
        Intent objCoti = new Intent(this,Clientes.class);
        startActivity(objCoti);
    }
}
