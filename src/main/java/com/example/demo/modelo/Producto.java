package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@SequenceGenerator(name = "seq_prod", sequenceName = "seq_prod", allocationSize = 1)
	@GeneratedValue(generator = "seq_prod", strategy = GenerationType.SEQUENCE)
	@Column(name = "prod_id")
	private Integer id;

	@Column(name = "prod_codBarras")
	private String codBarras;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_categoria")
	private String categoria;

	@Column(name = "prod_stock")
	private Integer stock;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "producto")
	private List<DetalleFactura> detalleFacturas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codBarras=" + codBarras + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}

	

}
