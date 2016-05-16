package br.com.christianovale.base.aplicacao.entidade;

import java.util.List;

public class Profissional {
	
	private Long id;
	private String nome;
	private String cpf;
	private String inscricaoConselho;
	private String email;
	private String telefone;
	private String fax;
	private String celular;
	private String iscricaoEstadual;
	private String endereco;
	private String bairro;
	private String cep;
	private String site;
	private String iniciais;
	private Municipio municipio;
	private List<InformacoesBancarias> infomacoesBancarias;
	private List<InformacoesAcademicas> informacoesAcademicas;
	private List<ExperienciaProfissional> experienciaProfissional;
	private List<DisponibilidadeHorario> listaDisponibilidadeHorario;
	private DisponibilidadeHorario[][] disponibilidadeHorario;
	private List<Disciplina> disciplina;
	

}
