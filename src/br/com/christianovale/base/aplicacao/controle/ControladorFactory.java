package br.com.christianovale.base.aplicacao.controle;
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
 * Funciona com uma 'Fabrica' de objetos Controlador. 
 */
public class ControladorFactory {
	
	private static ControladorFactory instancia;
	
	/**
	 * Construtor privado para impedir a criação de novas instancias desta classe.
	 */
	private ControladorFactory() {
	}
	
	/**
	 * Singleton que retorna a instancia ativa da classe ControladorFactory
	 */
	public static ControladorFactory getInstancia(){
		if(instancia == null){
			instancia = new ControladorFactory();
		}
		return instancia;
	}
	
	/**
	 * Metodo que retorna a nova instancia de uma classe descentende de AppBaseControlador.
	 * @param classe, a classe que será retornada.
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public AppBaseControlador getControlador(Class classe) throws InstantiationException, IllegalAccessException{
		return (AppBaseControlador) classe.newInstance();
	}

}
