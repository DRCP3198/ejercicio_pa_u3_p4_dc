package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepository;

@Service
public class IProductoServiceImpl implements IProductoService{
	
	private IProductoRepository iProductoRepository;

	@Override
	public void agregar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public Producto buscarCodigoBarras(String codBarra) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.encontrarCodigoBarras(codBarra);
	}

	@Override
	public void modificar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	public void borrar(String codBarra) {
		// TODO Auto-generated method stub
		this.iProductoRepository.eliminar(codBarra);
	}

	@Override
	public List<Producto> reporte() {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarTodos();
	}



}
