package br.home.vitor.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.home.vitor.api.ConfigAPI;
import br.home.vitor.api.dto.ViaCepDTO;
import br.home.vitor.mapper.ViaCepMapper;
import br.home.vitor.model.ViaCepModel;
import br.home.vitor.repository.ViaCepRepository;

@Service
public class RelatorioCepService {

    private final ConfigAPI configAPI;
	
	private final ViaCepRepository repository;
	
	public RelatorioCepService(ViaCepRepository repository, ConfigAPI configAPI) {
		this.repository = repository;
		this.configAPI = configAPI;
	}
	
	public String EstadoMaisAcessdo() {
		return repository.EstadoMaisAcessado();
	}
	
	public List<ViaCepDTO> ObterTodasConsultasFeitas(){
		List<ViaCepModel> modelos = repository.findAll();
		List<ViaCepDTO> consultas = modelos.stream().map(m -> ViaCepMapper.modelToDTO(m)).toList(); 
		return consultas;
	}
}
