package br.com.preventsenior.sparkcdi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String isbn;
	private int quantidadePaginas;

	public Livro() {
	}

	public Livro(Long id, String nome, String isbn, int quantidadePaginas) {
		super();
		this.id = id;
		this.nome = nome;
		this.isbn = isbn;
		this.quantidadePaginas = quantidadePaginas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", isbn=" + isbn + ", quantidadePaginas=" + quantidadePaginas
				+ "]";
	}
}
