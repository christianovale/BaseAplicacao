package br.com.christianovale.base.aplicacao.entidade;

public class InformacoesBancarias {
	
	private Long id;
	private Long idProfissional;
	private String nomeBanco;
	private String agencia;
	private String numeroConta;
	private Municipio municipio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProfissional() {
		return idProfissional;
	}
	public void setIdProfissional(Long idProfissional) {
		this.idProfissional = idProfissional;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	

}
