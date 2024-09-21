package com.SolucionesParaPlagas.android.Vista;

import android.os.Bundle;
import android.view.View;
import com.example.sol.R;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.SolucionesParaPlagas.android.Controlador.Sesion;
import com.SolucionesParaPlagas.android.Controlador.ControladorDetalleCliente;
import com.SolucionesParaPlagas.android.Modelo.Entidad.Cliente.DetalleCliente;

public class EditarDatosP extends AppCompatActivity {

    private EditText campo;
    private String dato,titulo;
    private TextView tit;
    private Button btnConfirmar;
    private ImageView btnMenu, btnCerrarSesion, btnProductos, btnAtras;
    private DetalleCliente clienteCompleto = new DetalleCliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editardatocliente);
        inicializarElementos();
        configurarBotones();
    }

    private void inicializarElementos() {
        btnConfirmar = findViewById(R.id.btnConfirmacion);
        btnMenu = findViewById(R.id.iconoMenu);
        btnCerrarSesion = findViewById(R.id.iconoCerrarSesion);
        btnProductos = findViewById(R.id.iconoVerProductos);
        btnAtras = findViewById(R.id.iconoAtras);
    }

    private void inicializarCliente() {
        // Obtenemos el cliente ya que es el unico que es el unico en el repositorio
        ControladorDetalleCliente controladorDetalleCliente = ControladorDetalleCliente.obtenerInstancia();
        clienteCompleto = controladorDetalleCliente.obtenerCliente();
    }

    private void recibirElementos(){
        Intent intent = getIntent();
        if(intent != null){
            dato = intent.getStringExtra("campo");
            titulo = intent.getStringExtra("titulo");
            campo.setText(dato);
            tit.setText(titulo);
        }
    }

    private void configurarBotones() {
        btnProductos.setOnClickListener(this::regresarAProductos);
        btnMenu.setOnClickListener(this::irAMenu);
        btnCerrarSesion.setOnClickListener(this::irACerrarSesion);
        btnAtras.setOnClickListener(this::regresarAEditarPerfil);
    }

    private void regresarAProductos(View v){
        Intent intent = new Intent(EditarDatosP.this, MostrarProductos.class);
        startActivity(intent);
    }

    private void irAMenu(View v){
        Intent intent = new Intent(EditarDatosP.this, MenuPrincipal.class);
        startActivity(intent);
    }

    private void irACerrarSesion(View v) {
        Sesion sesion = new Sesion();
        sesion.confirmarCerrarSesion(this);
    }

    private void regresarAEditarPerfil(View v){
        Intent intent = new Intent(EditarDatosP.this, ConsultarPerfil.class);
        intent.putExtra("campo", dato);
        intent.putExtra("titulo", tit.getText().toString());
        startActivity(intent);
    }

}