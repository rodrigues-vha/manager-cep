package br.home.vitor.mapper;

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
}
