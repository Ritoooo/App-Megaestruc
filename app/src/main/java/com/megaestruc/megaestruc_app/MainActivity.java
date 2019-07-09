package com.megaestruc.megaestruc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.megaestruc.megaestruc_app.vista.ClienteView.ListaCliente;
import com.megaestruc.megaestruc_app.vista.CotizacionView.Cotizacion;
import com.megaestruc.megaestruc_app.vista.ProductoView.ListaProductos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);

        //obtenerDatosVolley();
    }

    private void obtenerDatosVolley(){

        String url = "http://megaestruc.herokuapp.com/api/producto/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray mJsonArray = response.getJSONArray("productos");
                    for(int i = 0; i < mJsonArray.length(); i++){
                        JSONObject mJsonObject = mJsonArray.getJSONObject(i);
                        String name = mJsonObject.getString("nombre");
                        String descripcion = mJsonObject.getString("descripcion");
                        int stock = mJsonObject.getInt("stock");
                        double preVen = mJsonObject.getDouble("preVen");
                        Toast.makeText(MainActivity.this, "Nombre: "+name+"\nDescripción: "+descripcion+"\nStock: "+stock+"\nPrecio de Venta: "+preVen, Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "onErrorResponse: ", error);
            }
        }
        );
        queue.add(request);
    }

    public void irCoti(View view){  navegar(Cotizacion.class);    }
    public void irProd(View view){  navegar(ListaProductos.class);    }
    public void irClie(View view){  navegar(ListaCliente.class);    }

    public void navegar(Class activity){startActivity(new Intent(this, activity));}
}