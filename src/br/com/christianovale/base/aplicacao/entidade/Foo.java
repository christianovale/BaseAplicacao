package br.com.christianovale.base.aplicacao.entidade;

import java.text.ParseException;
import java.util.Date;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.modelo.ModeloFoo;
import br.com.christianovale.base.aplicacao.util.DateUtil;
/**********************************************
* ---     E X E M P L O    F O O            ---
* *********************************************
* Entidade de exemplo da BaseAplicação.	    ---
***********************************************
*/
public class Foo extends AppBaseVO{
	
	private int codigo;
	private String nome;
	private String endereco;
	private int idade;
	private Date nascimento;
	
	public Foo(String nome, String endereco, int idade, Date nascimento) {
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
		this.nascimento = nascimento;
	}
	
	public Foo(ModeloFoo modeloFoo) throws AppBaseException{
		this.nome = modeloFoo.getNome();
		this.endereco = modeloFoo.getEndereco();
		this.idade = Integer.parseInt(modeloFoo.getIdade());
		if(this.existeCodigo(modeloFoo)){
			this.codigo = Integer.parseInt(modeloFoo.getCodigo());
		}
		try {
			this.nascimento = DateUtil.deStringParaUtil(modeloFoo.getNascimento());
		} catch (ParseException e) {
			throw new AppBaseException(DateUtil.ERRO_PARSE_DATE);
		}
	}
	
	/**
	 * Verifica se existe um codigo (ID) para o objeto em questão.
	 * @param modeloFoo
	 * @return
	 */
	private boolean existeCodigo(ModeloFoo modeloFoo){
		return modeloFoo.getCodigo() != null && modeloFoo.getCodigo().trim().length()>0;
	}
	
	/**
	 * Metodo que retorna um objeto ModeloFoo com os dados de Foo.
	 * @return
	 */
	public ModeloFoo getModeloFoo(){
		ModeloFoo modelo = new ModeloFoo();
		modelo.setCodigo(String.valueOf(this.codigo));
		modelo.setEndereco(this.endereco);
		modelo.setIdade(String.valueOf(this.idade));
		modelo.setNascimento(DateUtil.deUtilParaString(this.nascimento));
		modelo.setNome(this.nome);
		return modelo;
	}
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}


