package br.home.vitor.mapper;

import java.time.format.DateTimeFormatter;

import br.home.vitor.api.dto.ViaCepDTO;
import br.home.vitor.model.ViaCepModel;

public class ViaCepMapper {
	
	public static ViaCepModel dtoToModel(ViaCepDTO dto) {
		ViaCepModel entity = new ViaCepModel();
		entity.setCep(dto.getCep());
		entity.setLogradouro(dto.getLogradouro());
		entity.setComplemento(dto.getComplemento());
		entity.setUnidade(dto.getUnidade());
		entity.setBairro(dto.getBairro());
		entity.setLocalidade(dto.getLocalidade());
		entity.setUf(dto.getUf());
		entity.setEstado(dto.getEstado());
		entity.setRegiao(dto.getRegiao());
		entity.setIbge(dto.getIbge());
		entity.setGia(dto.getGia());
		entity.setDdd(dto.getDdd());
		entity.setSiafi(dto.getSiafi());
		return entity;
	}
	
	public static ViaCepDTO modelToDTO(ViaCepModel model) {
		ViaCepDTO dto = new ViaCepDTO();
		dto.setCep(model.getCep());
		dto.setLogradouro(model.getLogradouro());
		dto.setComplemento(model.getComplemento());
		dto.setUnidade(model.getUnidade());
		dto.setBairro(model.getBairro());
		dto.setLocalidade(model.getLocalidade());
		dto.setUf(model.getUf());
		dto.setEstado(model.getEstado());
		dto.setRegiao(model.getRegiao());
		dto.setIbge(model.getIbge());
		dto.setGia(model.getGia());
		dto.setDdd(model.getDdd());
		dto.setSiafi(model.getSiafi());
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		dto.setDataConsulta(model.getData_consulta().format(f));
		return dto;
	}
}
