package com.example.demo.modelo;

public class ProductoSencillo {
	
	private String codBarra;
	private Integer cantidad;
	
	
	public ProductoSencillo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductoSencillo(String codBarra, Integer cantidad) {
		super();
		this.codBarra = codBarra;
		this.cantidad = cantidad;
	}

	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	} 
	
	

}
