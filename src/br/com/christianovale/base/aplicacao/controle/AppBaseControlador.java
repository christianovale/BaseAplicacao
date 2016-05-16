package br.com.christianovale.base.aplicacao.controle;

import java.sql.Connection;

import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;
import br.com.christianovale.base.aplicacao.persistencia.PoolConexao;


/**
 * @author christiano vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplica��o</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 * 
 * Descreve uma classe ancestral para as demais classes de Controlador do CRUD do sistema.
 * Deve conter os m�todos em comum a pelo menos mais de um Controlador. 
 */
public class AppBaseControlador {
	
	/**
	 * Metodo para retornar a instacia de Conex�o com banco de dados.
	 * @return, a conex�o aberta.
	 * @throws PersistenciaException
	 */
	public Connection getConexao() throws PersistenciaException{
		return PoolConexao.getInstancia().getConexao();
	}
	
	/**
	 * Cancela a Conexao com o banco, em caso de erro.
	 * @param conexao
	 * @throws PersistenciaException
	 */
	public void cancelarConexao(Connection conexao) throws PersistenciaException{
		PoolConexao.getInstancia().cancelarConexao(conexao);
	}
	
	/**
	 * Fecha a conex�o com o banco de dados apos o termino do servi�o.
	 * @param conexao
	 * @throws PersistenciaException
	 */
	public void fecharConexao(Connection conexao) throws PersistenciaException{
		PoolConexao.getInstancia().fecharConexao(conexao);
	}

}
