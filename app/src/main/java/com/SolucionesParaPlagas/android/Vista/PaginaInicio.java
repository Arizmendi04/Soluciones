package com.SolucionesParaPlagas.android.Vista;

import com.example.sol.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.SolucionesParaPlagas.android.Controlador.Controlador;
import com.SolucionesParaPlagas.android.Controlador.ControladorJsonProducto;
import com.SolucionesParaPlagas.android.Modelo.Entidad.Producto.JsonProducto;

public class PaginaInicio extends AppCompatActivity {

    private Button botonIniciarSesion;
    private ImageView btnUbicacion, btnSitioWeb;
    private TextView ubicacion, botonCrearCuenta;
    private Controlador<JsonProducto> controladorJsonProducto = new ControladorJsonProducto();

    // Metodos de manipulacion de la interfaz (layout)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenida);
        inicializarElementos();
        configurarBotones();
    }

    @Override
    protected void onStart() {
        super.onStart();
        cargarProductos();
    }

    private void cargarProductos(){
        controladorJsonProducto.realizarSolicitud();
    }

    // Metodos para configurar los elementos dentro de los layout y que se usaran por el usuario
    private void inicializarElementos() {
        botonIniciarSesion = findViewById(R.id.btnInicioSesion);
        botonCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnSitioWeb = findViewById(R.id.iconopaginaweb);
        btnUbicacion = findViewById(R.id.iconodireccion);
        ubicacion = findViewById(R.id.txtDireccion);
    }

    private void configurarBotones() {
        // Configura el listener del botón Iniciar Sesión
        botonIniciarSesion.setOnClickListener(this::irALogin);
        botonCrearCuenta.setOnClickListener(this::irACrearCuenta);
        btnUbicacion.setOnClickListener(this::irAMaps);
        btnSitioWeb.setOnClickListener(this::irASitioWeb);
        ubicacion.setOnClickListener(this::irAMaps);
    }

    private void irALogin(View v) {
        Intent intent = new Intent(PaginaInicio.this, Login.class);
        startActivity(intent);
    }

    private void irACrearCuenta(View v){
        Intent intent = new Intent(PaginaInicio.this, RegistroDatos.class);
        startActivity(intent);
    }

    private void irASitioWeb(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse("https://solucionesparaplagas.com"));
        startActivity(intent);
    }

    private void irAMaps(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse("https://maps.app.goo.gl/JqhgPaVzdzTY6Lzj7"));
        startActivity(intent);
    }

}
