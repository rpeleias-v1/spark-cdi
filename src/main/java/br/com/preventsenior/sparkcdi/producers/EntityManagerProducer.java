package br.com.preventsenior.sparkcdi.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	@Produces
	@ApplicationScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("spark-cdi");
	}

	@Produces
	@ApplicationScoped
	public EntityManager createEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	public void closeEntityManagerFactory(@Disposes EntityManagerFactory factory) {
		factory.close();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
