package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto prodcuto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(prodcuto);
	}

	@Override
	public Producto encontrarCodigoBarras(String codBarra) {
		// TODO Auto-generated method stub

		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Producto> query = myBuilder.createQuery(Producto.class);

		Root<Producto> miTablaFrom = query.from(Producto.class); // FROM Item
		Predicate condicionCodBarra = myBuilder.equal(miTablaFrom.get("codBarra"), codBarra);
		query.select(miTablaFrom).where(condicionCodBarra);
		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(query);

		try {
			return myQueryFinal.getSingleResult();
		} catch (Exception e) {
			System.out.println("No existe un producto con ese cod_barra");
			return null;
		}
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);

	}

	@Override
	public void eliminar(String codBarra) {
		// TODO Auto-generated method stub
        this.entityManager.remove(this.encontrarCodigoBarras(codBarra));
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> typedQuery= this.entityManager.createQuery("SELECT i FROM Item i", Producto.class);
		return typedQuery.getResultList();
	}



}
