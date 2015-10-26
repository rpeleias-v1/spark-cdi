package br.com.preventsenior.sparkcdi.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.preventsenior.sparkcdi.model.Livro;

public class JPALivroDao implements LivroDAO {

	private EntityManager manager;

	@Deprecated
	JPALivroDao() {
	}

	@Inject
	public JPALivroDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void insert(Livro livro) {
		manager.getTransaction().begin();
		manager.persist(livro);
		manager.getTransaction().commit();
	}

	@Override
	public Livro get(Long id) {
		return manager.find(Livro.class, id);
	}

	@Override
	public List<Livro> getAll() {
		TypedQuery<Livro> query = manager.createQuery("select l from Livro l", Livro.class);
		return query.getResultList();
	}

	@Override
	public void update(Livro livro) {
		manager.getTransaction().begin();
		manager.merge(livro);
		manager.getTransaction().commit();
	}

	@Override
	public void delete(Long id) {
		manager.getTransaction().begin();
		manager.remove(this.get(id));
		manager.getTransaction().commit();
	}

}
