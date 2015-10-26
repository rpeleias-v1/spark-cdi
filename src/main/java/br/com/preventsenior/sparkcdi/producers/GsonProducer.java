package br.com.preventsenior.sparkcdi.producers;

import javax.enterprise.inject.Produces;

import com.google.gson.Gson;

public class GsonProducer {

	@Produces
	public Gson createGson() {
		return new Gson();
	}
	
}
