package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.ProductoSencillo;
import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.IProductoRepository;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class EjercicioPaU3P4DcApplication implements CommandLineRunner{
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IFacturaService facturaService;

	private static final Logger LOG= LoggerFactory.getLogger(EjercicioPaU3P4DcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4DcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Producto p = new  Producto();
		p.setCodBarras("a123");
		p.setPrecio(new BigDecimal(5.20));
		p.setNombre("pañales");
		p.setStock(100);
		p.setCategoria("bebés");
		
		Producto p1= new  Producto();
		p1.setCodBarras("b123");
		p1.setPrecio(new BigDecimal(11.20));
		p1.setNombre("caja de neurobion");
		p1.setStock(23);
		p1.setCategoria("medicinas");
		
		Producto p2= new  Producto();
		p2.setCodBarras("c123");
		p2.setPrecio(new BigDecimal(21.20));
		p2.setNombre("caja de migradorixina");
		p2.setStock(12);
		p2.setCategoria("medicinas");
		
		//Punto 1 insertar Productos
		this.iProductoService.agregar(p);
		this.iProductoService.agregar(p1);
		this.iProductoService.agregar(p2);
		
		List<Producto> productos = new ArrayList<>();
		Producto pro = new Producto();
		pro.setStock(12);
		pro.setCodBarras("a123");
		productos.add(pro);
	
		//this.facturaService.listaFactura(productos, "1751457167");

		
		
		
	}

}
