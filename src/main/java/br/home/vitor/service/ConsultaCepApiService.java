package br.home.vitor.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.home.vitor.api.dto.ViaCepDTO;
import br.home.vitor.exception.RecursoNaoEncontradoException;
import br.home.vitor.mapper.ViaCepMapper;
import br.home.vitor.model.ViaCepModel;
import br.home.vitor.repository.ViaCepRepository;

@Service
public class ConsultaCepApiService {

	private final RestClient restClient;
	private final ViaCepRepository repository;
		
	public ConsultaCepApiService(RestClient restClient, ViaCepRepository repository) {
		this.restClient = restClient;
		this.repository = repository;
	}
	
	public ViaCepDTO buscarDadosExternos(String parametro) {
		ViaCepDTO resBodyCep = restClient.get()
                .uri("/{id}/json", parametro)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    throw new RecursoNaoEncontradoException("O CEP informado não existe na base nacional.");
                }).onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("Erro na API externa: " + response.getStatusCode());    
                }).onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RuntimeException("Erro no servidor externo: " + response.getStatusCode());
                })
                .body(ViaCepDTO.class);
        
		if(resBodyCep.getCep() != null && !resBodyCep.getCep().isEmpty()) {
			ViaCepModel model = ViaCepMapper.dtoToModel(resBodyCep);
			repository.save(model);
		} else {
			throw new RecursoNaoEncontradoException("O CEP informado não existe na base nacional.");
		}
        return resBodyCep;
    }
}
