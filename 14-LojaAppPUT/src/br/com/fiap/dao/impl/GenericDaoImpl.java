package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.AulaTO;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDaoImpl<T, K>
				implements GenericDAO<T, K>{
	
	@PersistenceContext
	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		// TODO Auto-generated method stub
		em.persist(em);
	}

	@Override
	public void atualizar(T entidade) {
	
		em.merge(entidade);
		
	}

	@Override
	public T pesquisar(K chave) throws CodigoInexistenteException {
		// TODO Auto-generated method stub
		T entidade = em.find(clazz, chave);
		if(entidade == null) {
			throw new CodigoInexistenteException();
		}
		return entidade;
	}

	@Override
	public void deletar(K chave){
		try {
			T entidade = pesquisar(chave);
			em.remove(entidade);
		} catch (CodigoInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}
	
	
}
