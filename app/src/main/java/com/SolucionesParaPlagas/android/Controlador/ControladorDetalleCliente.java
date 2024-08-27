package com.SolucionesParaPlagas.android.Controlador;

import java.util.List;
import com.SolucionesParaPlagas.android.Modelo.Entidad.Cliente.DetalleCliente;
import com.SolucionesParaPlagas.android.Modelo.Repositorio.Repositorio;
import com.SolucionesParaPlagas.android.Modelo.Repositorio.RepositorioDetalleCliente;

public class ControladorDetalleCliente {

    private Repositorio<DetalleCliente> repositorioCliente = RepositorioDetalleCliente.obtenerInstancia();

    public List<DetalleCliente> obtenerRepositorio() {
        return repositorioCliente.getDatos();
    }

    public void enviarDatosRepositorio(List<DetalleCliente> listaDetalleClientes){
        repositorioCliente.setDatos(listaDetalleClientes);
    }

    public void enviarDatoRepositorio(DetalleCliente detalleCliente){
        repositorioCliente.setDato(detalleCliente);
    }

    public DetalleCliente obtenerCliente(){
        return repositorioCliente.getDato();
    }

    public void limpiarRepositorio(){
        repositorioCliente.clearList();
    }

}