package br.com.preventsenior.sparkcdi.transformer;

import javax.inject.Inject;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer{

	@Inject
	private Gson gson;
	
	@Override
	public String render(Object model) throws Exception {
		return gson.toJson(model);
	}

}
