package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.ProductoSencillo;
import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.IProductoRepository;


@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public void agregar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.insertar(factura);
	}

	@Override
	public void modificar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public Factura encontrar(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscar(numero);
	}

	@Override
	public List<ProductoSencillo> listaFactura(List<ProductoSencillo> misProductos, String numeroCedula) {
		// TODO Auto-generated method stub
				BigDecimal calculoTotal= new BigDecimal(0);
				Factura factura = new Factura();
				factura.setCedulaCliente(numeroCedula);
				factura.setFecha(LocalDate.now());
			
				
				for (ProductoSencillo productoS : misProductos) {
					for (Producto producto: iProductoRepository.buscarTodos()) {
						if(productoS.getCantidad()<= producto.getStock() && productoS.getCodBarra().equals(producto.getCodBarras())) {
					
							calculoTotal=calculoTotal.add(producto.getPrecio().multiply(new BigDecimal(productoS.getCantidad())));
							//me devuelve el Stock actual en cada uno de los Items
							Integer cantidad= producto.getStock();
							producto.setStock(cantidad-productoS.getCantidad());
							this.iProductoRepository.actualizar(producto);
							System.out.println("Actualizando Nuevo  registro Producto");
							
							
						}else {
							System.out.println("no existe en Stock");
						}
					}
				}
				
				factura.setTotalFactura(calculoTotal);
				this.facturaRepository.insertar(factura);
				return misProductos;
	}
}
