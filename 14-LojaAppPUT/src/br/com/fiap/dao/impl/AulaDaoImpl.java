package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AulaDAO;
import br.com.fiap.entity.AulaTO;

public class AulaDaoImpl extends GenericDaoImpl<AulaTO, Integer> implements AulaDAO{

	public AulaDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
}
