package br.com.christianovale.base.aplicacao.facadeimpl;

import br.com.christianovale.base.aplicacao.facade.IFacade;

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
 * Esta classe reprenta o Controlador do Façade
 * responsavel por retornar o Serviço ao Cliente.
 */
public class ControladorFacade {
	
	private static ControladorFacade ctrl;
	private IFacade facade;
	
	private ControladorFacade(){ }
	
	/**
	 * Singleton que retorna a instancia ativa da classe ContoladorFacade
	 */
	public static ControladorFacade getInstance(){
		if (ctrl == null){
			ctrl = new ControladorFacade();
		}
		return ctrl;
	}
	
	/**
	 * Retorna a instancia de Façade 
	 */
	public IFacade getServicoFacade(){
		if(this.facade == null){
			this.facade = new FacadeImpl();
		}
		return this.facade;
	}
}
