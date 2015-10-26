package br.com.preventsenior.sparkcdi.dao;

import java.util.List;

import br.com.preventsenior.sparkcdi.model.Livro;

public interface LivroDAO {

	void insert(Livro livro);
	
	Livro get(Long id);
	
	List<Livro> getAll();
	
	void update(Livro livro);
	
	void delete(Long id);
}
