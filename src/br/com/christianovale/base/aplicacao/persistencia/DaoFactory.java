package br.com.christianovale.base.aplicacao.persistencia;

import br.com.christianovale.base.aplicacao.persistencia.dao.AppBaseDAO;

/**
 * @author christiano vale
 * @version 1.0.3
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 * 
 * Implementação do Design Pattern 'Factory Method'.
 * 
 * Funciona com uma 'Fabrica' de objetos DAO. 
 */
public class DaoFactory {
	
	private static DaoFactory instancia;
	
	/**
	 * Construtor privado para impedir a criação de novas instancias desta classe.
	*/
	private DaoFactory() {
	}
	
	/**
	 * Singleton que retorna a instancia ativa da classe DaoFactory
	 */
	public static DaoFactory getInstancia(){
		if(instancia == null){
			instancia = new DaoFactory();
		}
		return instancia;
	}
	
	/**
	 * Metodo que retorna a nova instancia de uma classe descentende de AppBaseDao.
	 * @param classe, a classe que será retornada
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public AppBaseDAO getDao(Class classe) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (AppBaseDAO) classe.newInstance();
	}

}
