package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.dao.impl.AulaDaoImpl;
import br.com.fiap.entity.AulaTO;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/aula")
public class AulaResource {
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AulaTO buscar(@PathParam("id") int codigo) throws CodigoInexistenteException{
		EntityManager em = fabrica.createEntityManager();
		AulaDaoImpl aulaDao = new AulaDaoImpl(em);
		return aulaDao.pesquisar(codigo);
	}
	
	
}
