package br.home.vitor.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cep")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@Column(name = "dt_consulta")
	private LocalDateTime data_consulta = LocalDateTime.now().withNano(0);
}
