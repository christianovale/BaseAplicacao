package br.com.christianovale.base.aplicacao.facadeimpl;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.businessobject.BoFactory;
import br.com.christianovale.base.aplicacao.businessobject.FooBO;
import br.com.christianovale.base.aplicacao.businessobject.RegraNegocioException;
import br.com.christianovale.base.aplicacao.controle.ControladorException;
import br.com.christianovale.base.aplicacao.controle.ControladorFactory;
import br.com.christianovale.base.aplicacao.controle.ControladorFoo;
import br.com.christianovale.base.aplicacao.entidade.Foo;
import br.com.christianovale.base.aplicacao.facade.IFacade;
import br.com.christianovale.base.aplicacao.modelo.ModeloFoo;
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
 * Classe que implementa os métodos da Interface IFacade
 */
public class FacadeImpl implements IFacade{
	
	/**
	 ***********************************************
	 * ---     E X E M P L O    F O O            ---
	 * *********************************************
	 * Façade de exemplo da BaseAplicação.		 ---
	 ***********************************************
	 *
	 *
	 * O Controlador pode ser chamado diretamente pelo facade ou pode ser chamado pela classe BO,
	 * dependendo da situação.
	 * 
	 * OBS: O modelo de dados deve chegar somente até aqui (o Facade). 
	 *      Daqui em diante é preciso tranforma-lo na entidade equivalente.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public void medotoExemploFoo(ModeloFoo modelo) throws PersistenciaException, 
														  ControladorException, 
														  RegraNegocioException, 
														  AppBaseException, 
														  Exception{
		Foo foo = new Foo(modelo);
		FooBO bo = (FooBO) BoFactory.getInstancia().getBO(FooBO.class);
		bo.verificarDataNascimentoFoo(foo);
		
		ControladorFoo ctrl = (ControladorFoo) ControladorFactory.getInstancia().getControlador(ControladorFoo.class);
		ctrl.incluirFoo(foo);
	}
}
