package br.home.vitor.service;

import org.springframework.stereotype.Service;

import br.home.vitor.repository.ViaCepRepository;

@Service
public class RelatorioCepService {
	
	private final ViaCepRepository repository;
	
	public RelatorioCepService(ViaCepRepository repository) {
		this.repository = repository;
	}
	
	public String EstadoMaisAcessdo() {
		return repository.EstadoMaisAcessado();
	}
}
