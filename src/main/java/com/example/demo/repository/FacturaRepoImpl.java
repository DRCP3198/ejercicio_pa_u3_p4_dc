package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepository {
	
	@PersistenceContext
     private EntityManager entityManager;
	
	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public Factura buscar(String numero) {
		TypedQuery<Factura> typedQuery = this.entityManager.createNamedQuery("Factura.buscarNumero", Factura.class);
		typedQuery.setParameter("datoNumero", numero);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(numero));
	}

}
