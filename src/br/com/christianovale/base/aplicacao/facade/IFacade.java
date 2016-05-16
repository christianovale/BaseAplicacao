package br.com.christianovale.base.aplicacao.facade;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.businessobject.RegraNegocioException;
import br.com.christianovale.base.aplicacao.controle.ControladorException;
import br.com.christianovale.base.aplicacao.modelo.ModeloFoo;
import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;


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
 * Interface do Fa�ade. Declara��o e documenta��o dos m�todos.
 */
public interface IFacade {
	
	/**
	 * *********************************************
	 * ---     E X E M P L O    F O O            ---
	 * *********************************************
	 * Fa�ade de exemplo da BaseAplica��o.		 ---
	 ***********************************************
	 *
	 *
	 * @param modelo
	 * @throws PersistenciaException
	 * @throws ControladorException
	 * @throws RegraNegocioException
	 * @throws AppBaseException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void medotoExemploFoo(ModeloFoo modelo) throws PersistenciaException, 
					  									  ControladorException, 
														  RegraNegocioException, 
														  AppBaseException, 
														  Exception;
}
