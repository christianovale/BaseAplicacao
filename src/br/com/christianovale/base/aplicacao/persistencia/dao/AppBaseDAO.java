package br.com.christianovale.base.aplicacao.persistencia.dao;

import java.sql.Connection;

import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;


/**
 * @author christiano vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 * 
 * Descreve uma classe ancestral para as demais classes de persistencia do sistema.
 * Deve conter os métodos em comum a pelo menos mais de um DAO. 
 */
public class AppBaseDAO {
	
	/**
	 * Metodo para retornar o novo Codigo sequencial de chave primaria.
	 * 
	 * @param conexao, a conexão com o banco de dados.
	 * @param tabela, a tabela que se deseja obter o novo codigo.
	 * @return, o novo codigo de chave primaria solicitado.
	 * @throws PersistenciaException
	 */
	public int obterNovoCodigo(Connection conexao, String tabela) throws PersistenciaException{
		return SequenciaDAO.obterInstancia().obterProximoCodigo(conexao, tabela);
	}

}
