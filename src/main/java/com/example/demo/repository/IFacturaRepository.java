package com.example.demo.repository;

import com.example.demo.modelo.Factura;

public interface IFacturaRepository {

	public void insertar(Factura factura);

	public void actualizar(Factura factura);

	public Factura buscar(String numero);

	public void eliminar(String numero);

}
