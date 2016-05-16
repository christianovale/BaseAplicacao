package br.com.christianovale.base.aplicacao.businessobject;

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
 * Funciona com uma 'Fabrica' de objetos BO. 
 */
public class BoFactory {
	
	private static BoFactory instancia;
	
	/**
	 * Construtor privado para impedir a criação de novas instancias desta classe.
	 */
	private BoFactory(){
	}
	
	/**
	 * Singleton que retorna a instancia ativa da classe BoFactory
	 */
	public static BoFactory getInstancia(){
		if(instancia == null){
			instancia = new BoFactory();
		}
		return instancia;
	}

	/**
	 * Metodo que retorna a nova instancia de uma classe descentende de AppBaseBO.
	 * @param classe, a classe que será retornada
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public AppBaseBO getBO(Class classe) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (AppBaseBO) classe.newInstance();
	}
}
