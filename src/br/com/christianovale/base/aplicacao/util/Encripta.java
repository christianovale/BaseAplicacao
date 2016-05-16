package br.com.christianovale.base.aplicacao.util;

/**
 * Classe que implementa algoritmo para criptografar e descriptografar textos.
 * 
 * @author Christiano Vale
 *
 */
public class Encripta implements Crypto {

	private static final long serialVersionUID = 1L;

	private static Encripta encripta;

	static {
		encripta = new Encripta();
	}

	/**
	 * Construtor privado: Singleton
	 * 
	 */
	private Encripta() {
		super();
	}

	public static final Crypto getInstancia() {
		return encripta;
	}

	/**
	 * Número inicial do algoritmo de criptografia
	 */
	public static final int STARTKEY = 256;

	/**
	 * Número a ser multiplicado no algoritmo de criptografia
	 */
	public static final int MULTKEY = 1;

	/**
	 * Número a ser somado no algoritmo de criptografia
	 */
	public static final int ADDKEY = 1;

	/**
	 * Realiza o tratamento de char de 2 bytes para 1 byte.
	 * 
	 * @param n
	 * @return char
	 */
	public char CHAR(int n) {
		int res = n % 256;
		if (res < 0)
			res = 256 + res; // como o n é negetivo vai subtrair
		return (char) res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sys.aug.cript.ICryptography#crypto(java.lang.String)
	 */
	public String criptografar(String value) {
		if(value==null)return null;	
		return this.crypto(value, STARTKEY, MULTKEY, ADDKEY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sys.aug.cript.ICryptography#decrypto(java.lang.String)
	 */
	public String descriptografar(String value) {
		if(value==null)return null;	
		return this.decrypto(value, STARTKEY, MULTKEY, ADDKEY);
	}

	/**
	 * Criptografa uma chave informada pelo paramentro valor. Utilizado mais
	 * para senhas.
	 * 
	 * @param valor
	 * @param start
	 * @param mult
	 * @param add
	 * @return
	 */
	public String crypto(String valor, int start, int mult, int add) {
			
		int I;
		byte aux; // valor ascii do caracter
		int aux2; // valor ascii do caracter apos a conversão e troca de bytes
		StringBuffer res = new StringBuffer(valor.length());

		I = 0;
		while (I < valor.length()) {
			aux = (byte) valor.charAt(I);
			aux2 = aux ^ (start >> 8);
			res.append(new Character(CHAR(aux2)).charValue());
			start = ((((int) res.toString().charAt(I)) % 256) + start) * mult
					+ add;
			I++;
		}

		return res.toString();
	}

	/**
	 * Descriptografa uma chave gerada pelo método cripto.
	 * 
	 * @param valor
	 * @param start
	 * @param mult
	 * @param add
	 * @return
	 */
	public String decrypto(String valor, int start, int mult, int add) {
		int I;
		byte aux; // valor ascii do caracter
		int aux2; // valor ascii do caracter apos a conversão e troca de bytes
		StringBuffer res = new StringBuffer(valor.length());

		I = 0;
		while (I < valor.length()) {
			aux = (byte) valor.charAt(I);
			aux2 = aux ^ (start >> 8);
			res.append(new Character(CHAR(aux2)).charValue());
			start = ((((int) valor.toString().charAt(I)) % 256) + start) * mult
					+ add;
			I++;
		}

		return res.toString();
	}

	/**
	 * Verifica valor de senha informada com o codigo de validacao
	 * 
	 * @param digitado
	 * @param codValidacao
	 * @return
	 */
	public boolean verificaSenha(String digitado, String codValidacao) {
		return descriptografar(codValidacao).equals(digitado);
	}

}
