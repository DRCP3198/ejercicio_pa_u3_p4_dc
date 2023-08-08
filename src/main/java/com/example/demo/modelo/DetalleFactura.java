package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
	
	
	@Id
	@SequenceGenerator(name = "seq_detalle", sequenceName = "seq_detalle", allocationSize = 1)
	@GeneratedValue(generator = "seq_detalle", strategy = GenerationType.SEQUENCE)
	@Column(name = "deta_id")
	private Integer id;

	@Column(name = "deta_cantidad")
	private Integer cantidad;

	@Column(name = "deta_precio_unitario")
	private BigDecimal precioUnitario;

	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="detalle_id_producto")
	private Producto producto;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="detalle_id_factura")
	private Factura factura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + "]";
	}
	
	

}
