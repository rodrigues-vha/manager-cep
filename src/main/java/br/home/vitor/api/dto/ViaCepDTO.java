package br.home.vitor.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaCepDTO {

	private String cep;
	private String logradouro;
	private String complemento;
	private String unidade;
	private String bairro;
	private String localidade;
	private String uf;
	private String estado;
	private String regiao;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	private String dataConsulta;
	
	@Override
	public String toString() {
		return "ViaCepDTO [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", unidade="
				+ unidade + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + ", estado=" + estado
				+ ", regiao=" + regiao + ", ibge=" + ibge + ", gia=" + gia + ", ddd=" + ddd + ", siafi=" + siafi + "]";
	}
}




