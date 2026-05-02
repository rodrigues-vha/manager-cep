package br.home.vitor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.home.vitor.api.dto.ViaCepDTO;
import br.home.vitor.service.ConsultaCepApiService;
import br.home.vitor.service.RelatorioCepService;

@RestController
public class ConsultaCepController {
	
	ConsultaCepApiService apiService;
	RelatorioCepService relatorioCepService;
	
	public ConsultaCepController(ConsultaCepApiService apiService, RelatorioCepService relatorioCepService) {
		this.apiService = apiService;
		this.relatorioCepService = relatorioCepService;
	}
	
	@GetMapping("/viacep/{codigoCep}")
    public ResponseEntity<ViaCepDTO> viacep(@PathVariable("codigoCep") String codigoCep) {
		System.out.println("Oi! Acessou Servidor");
		System.out.println(codigoCep);
		ViaCepDTO vc = apiService.buscarDadosExternos(codigoCep);
		System.out.println(vc.toString());
        return new ResponseEntity<>(vc, HttpStatus.OK);
    }
	
	@GetMapping("/relatoriocep/estado-mais-acessado")
	public ResponseEntity<String> estadoMais(){
		String estado = relatorioCepService.EstadoMaisAcessdo();
		return new ResponseEntity<>(estado, HttpStatus.OK);
	}
	
	@GetMapping("/relatoriocep/todas-consultas-feitas")
	public ResponseEntity<List<ViaCepDTO>> todasConsultas(){
		List<ViaCepDTO> consultas = relatorioCepService.ObterTodasConsultasFeitas();
		return new ResponseEntity<>(consultas, HttpStatus.OK);
	}
}

