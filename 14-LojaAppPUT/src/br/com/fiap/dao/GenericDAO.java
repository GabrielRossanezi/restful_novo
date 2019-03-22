package br.com.fiap.dao;

import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	T pesquisar(K chave) throws CodigoInexistenteException;
	
	void deletar(K chave);
	
	void commit() throws CommitException;
}
