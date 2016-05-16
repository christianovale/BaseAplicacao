package br.com.christianovale.base.aplicacao.modelo;

import javax.servlet.http.HttpServletRequest;

/**********************************************
* ---     E X E M P L O    F O O            ---
* *********************************************
* Modelo de exemplo da BaseAplicação.		---
***********************************************
*/
public class ModeloFoo extends AppBaseModelo{

	private String codigo;
	private String nome;
	private String endereco;
	private String idade;
	private String nascimento;
	
	public ModeloFoo(String codigo, String nome, String endereco, String idade, String nascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.nascimento = nascimento;
	}

	public ModeloFoo(){
		
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void getDadosPagina(HttpServletRequest request){
		this.codigo = request.getParameter("codigo");
		this.endereco = request.getParameter("endereco");
		this.idade = request.getParameter("idade");
		this.nascimento = request.getParameter("nascimento");
		this.nome = request.getParameter("nome");
	}
	
	public void setDadosPagina(HttpServletRequest request){
		request.setAttribute("codigo", this.codigo);
		request.setAttribute("endereco", this.endereco);
		request.setAttribute("idade", this.idade);
		request.setAttribute("nascimento", this.nascimento);
		request.setAttribute("nome", this.nome);
	}
}
