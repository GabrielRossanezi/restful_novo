package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
		
	private static EntityManagerFactory fabrica;
	
	public EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstance() {
		if(fabrica == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		    fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
}
