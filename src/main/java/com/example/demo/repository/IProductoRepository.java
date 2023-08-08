package com.example.demo.repository;

import java.util.List;


import com.example.demo.modelo.Producto;

public interface IProductoRepository {
	
	public void insertar(Producto prodcuto);
	public Producto encontrarCodigoBarras(String codBarra);
	public void actualizar(Producto prodcuto);
	public void eliminar(String codBarra);
	public List<Producto> buscarTodos();

}
