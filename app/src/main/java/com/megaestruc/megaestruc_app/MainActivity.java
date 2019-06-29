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
import com.megaestruc.megaestruc_app.vista.ClienteView.Clientes;

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

        obtenerDatosVolley();
    }

    private void obtenerDatosVolley(){

        String url = "http://megaestruc.herokuapp.com/api/distrito/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response) {

                try{

                    Log.e("Error", "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE: ");

                    /*JSONArray mJsonArray = response.getJSONArray("contacts");
                    for(int i = 0; i < mJsonArray.length(); i++){
                        JSONObject mJsonObject = mJsonArray.getJSONObject(i);
                        String name = mJsonObject.getString("name");
                        Toast.makeText(MainActivity.this, "Nombre: "+name, Toast.LENGTH_SHORT).show();*/
                    JSONArray mJsonArray = new JSONArray(response);

                    for(int i = 0; i < mJsonArray.length(); i++){
                        JSONObject mJsonObject = mJsonArray.getJSONObject(i);
                        String name = mJsonObject.getString("nombre");
                        Toast.makeText(MainActivity.this, "Nombre: "+name, Toast.LENGTH_SHORT).show();

                    }
                }catch (JSONException e){
                    Toast.makeText(MainActivity.this, "ERRORRRRRRR: ", Toast.LENGTH_SHORT).show();
                    Log.e("Error", "ERROR: ");
                    //e.printStackTrace();
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

    public void irCoti(View view){
        Intent objCoti = new Intent(this,Cotizacion.class);
        startActivity(objCoti);
    }
    public void irProd(View view){
        Intent objCoti = new Intent(this,Producto.class);
        startActivity(objCoti);
    }
    public void irClie(View view){
        Intent objCoti = new Intent(this, Clientes.class);
        startActivity(objCoti);

    }
}