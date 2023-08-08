package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.ProductoSencillo;



public interface IFacturaService {
	
	public void agregar(Factura factura);
	public void modificar(Factura factura);
	public Factura encontrar(String numero);
	public List<ProductoSencillo> listaFactura(List<ProductoSencillo>misProductos,String numeroCedula);
	


}
