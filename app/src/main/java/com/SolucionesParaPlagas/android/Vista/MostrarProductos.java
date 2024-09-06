package com.SolucionesParaPlagas.android.Vista;

import java.util.List;
import android.os.Bundle;
import android.view.View;
import com.example.sol.R;
import android.content.Intent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.SolucionesParaPlagas.android.Controlador.Sesion;
import com.SolucionesParaPlagas.android.Controlador.ControladorCarrito;
import com.SolucionesParaPlagas.android.Controlador.ControladorProducto;
import com.SolucionesParaPlagas.android.Modelo.Entidad.Producto.Producto;
import com.SolucionesParaPlagas.android.Vista.Adaptador.AdaptadorProductos;

public class MostrarProductos extends AppCompatActivity implements AdaptadorProductos.OnProductoClickListener {

    ImageView btnCerrarSesion, btnMenu, btnCarrito;
    RecyclerView productos;
    Sesion sesion = new Sesion();
    private ControladorProducto controladorProducto = ControladorProducto.obtenerInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscarproducto);
        inicializarElementos();
        cargarProductos();
        configurarBotones();
    }

    private void cargarProductos() {
        List<Producto> listaProductos = controladorProducto.obtenerRepositorio();
        if (listaProductos != null && !listaProductos.isEmpty()) {
            AdaptadorProductos adaptador = new AdaptadorProductos(listaProductos, this);
            productos.setAdapter(adaptador);
        }
    }

    private void inicializarElementos() {
        btnCarrito = findViewById(R.id.iconocompra);
        btnMenu = findViewById(R.id.iconomenu);
        btnCerrarSesion = findViewById(R.id.iconocerrarsesion);
        productos = findViewById(R.id.listaProductos);
        productos.setLayoutManager(new LinearLayoutManager(this)); // Configura el LayoutManager
    }

    private void configurarBotones() {
        btnCarrito.setOnClickListener(this::irACarrito);
        btnMenu.setOnClickListener(this::irAMenu);
        btnCerrarSesion.setOnClickListener(this::irACerrarSesion);
    }

    private void irAMenu(View v) {
        Intent intent = new Intent(MostrarProductos.this, MenuPrincipal.class);
        startActivity(intent);
    }

    private void irACerrarSesion(View v) {
        sesion.limpiarSesion();
        Intent intent = new Intent(MostrarProductos.this, PaginaInicio.class);
        startActivity(intent);
    }

    private void irACarrito(View v) {
        Intent intent = new Intent(MostrarProductos.this, CarritoCompras.class);
        startActivity(intent);
    }

    private void irAProducto(View v, Producto producto){
        Intent intent = new Intent(MostrarProductos.this, MostrarProducto.class);
        intent.putExtra("producto", producto);
        startActivity(intent);
    }

    @Override
    public void onProductoClick(Producto producto) {
        irAProducto(null,producto);
    }

}
