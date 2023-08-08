package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Producto;



public interface IProductoService {
	public void agregar(Producto producto);
	public Producto buscarCodigoBarras(String codBarra);
	public void modificar(Producto producto);
	public void borrar(String codBarra);
	public List<Producto> reporte();

}
