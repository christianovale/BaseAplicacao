package br.com.christianovale.base.aplicacao.util;

import java.io.Serializable;

/**
 * Interface para implementação de criptografia
 * 
 * @author Christiano Vale
 *
 */
public interface Crypto extends Serializable{
	/**
	 * Criptografa uma chave informada pelo paramentro valor
	 * @param value
	 * @return
	 */
	public String criptografar(String value);
	
	/**
	 * Descriptografa uma chave gerada pelo método criptografar.
	 * @param value
	 * @return
	 */
	public String descriptografar(String value);

}
