package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@SequenceGenerator(name = "seq_fact", sequenceName = "seq_fact", allocationSize = 1)
	@GeneratedValue(generator = "seq_fact", strategy = GenerationType.SEQUENCE)
	@Column(name = "fact_id")
	private Integer id;
	
	@Column(name = "fact_cedula_cliente")
	private String cedulaCliente;
	
	@Column(name ="fact_fecha")
	private LocalDate fecha;
	
	@Column(name ="fact_total_factura")
	private BigDecimal totalFactura;
	
	@OneToMany(mappedBy = "factura",cascade = CascadeType.PERSIST)
	private List<DetalleFactura> detalleFacturas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}
	

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cedulaCliente=" + cedulaCliente + ", totalFactura=" + totalFactura + "]";
	}


}
