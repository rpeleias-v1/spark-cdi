package br.com.preventsenior.sparkcdi;

import static spark.Spark.after;
import static spark.Spark.delete;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.google.gson.Gson;

import br.com.preventsenior.sparkcdi.dao.LivroDAO;
import br.com.preventsenior.sparkcdi.exceptions.NotFoundException;
import br.com.preventsenior.sparkcdi.model.Livro;
import br.com.preventsenior.sparkcdi.transformer.JsonTransformer;

public class LivrosAPISpark {
	
	@Inject
	private LivroDAO dao;
	
	@Inject
	private JsonTransformer jsonTransformer;
	
	@Inject
	private Gson gson;

	public void createAPI(@Observes ContainerInitialized event) {
		port(8080);
		get("/api/livros", (request, response) -> {
			return dao.getAll();
		}, jsonTransformer);
		
		get("/api/livros/:id", (request, response) -> {
			String pathId = request.params("id");
			Long id = Long.valueOf(pathId);
			Livro livro = dao.get(id);
			if (livro != null) {
				return livro;
			} else {
				throw new NotFoundException();
			}
		}, jsonTransformer); 
		
		post("/api/livros", (request, response) -> {			
			Livro livro = gson.fromJson(request.body(), Livro.class);
			dao.insert(livro);
			response.status(201);
			response.header("Location", request.pathInfo());
			return livro;
		}, jsonTransformer);
		
		/*put("/api/livros/:id", (request, reponse) -> {
			String pathId = request.params("id");
			Long id = Long.valueOf(pathId);
			Livro livro = dao.get(id);
			if (livro == null) {
				throw new NotFoundException();
			}
			if (request.) {
				
			}
		}, jsonTransformer);*/
		
		delete("/api/livros/:id", (request, response) -> {
			String pathId = request.params("id");
			Long id = Long.valueOf(pathId);
			Livro livro = dao.get(id);
			if (livro == null) {
				throw new NotFoundException();
			}
			dao.delete(id);
			response.status(204);
			return "Livros removed with success!";
		}, jsonTransformer);
		
		after((request, response) -> {
			response.type("application/json");
		});
		
		exception(NotFoundException.class, (e, request, response) -> {
			response.status(404);
			response.body("Resource not found");
		});
	}
}
