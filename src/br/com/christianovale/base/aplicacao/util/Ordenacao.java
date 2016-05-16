package br.com.christianovale.base.aplicacao.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author christiano vale
 * @version 1.0.1
 * 
 * Description: Christiano Vale - Base Aplicação
 *
 * Copyright: Copyright (c) 2008
 *
 * Company: Christiano Vale Sistemas
 * 
 * Descreve uma classe (que implementa a interface Comparator) responsavel por
 * ordenar uma lista de VOs (value objetc) de acordo com a ordenação desejada
 * pelo cliente. Implementa um construtor privado somente para prevenir
 * tentativas de instância direta da classe.
 * 
 * ***********************************************************************************************
 * ****************** EXEMPLO DE UTILIZAÇÃO: *****************************************************
 * ---Para ordenar uma lista de VO's: 
 * Ordenacao.ordenarLista(<Lista> ,<propriedadeOrdenacaoDesejada> , <tipoDeOrdenação>);
 * 
 * ---Para ordenar uma lista de: Strings, Numeros ou Datas:
 * Ordenacao.ordenarLista(<Lista> ,<null> , <tipoDeOrdenação>);
 * ************************************************************************************************
 * ************************************************************************************************
 */
public class Ordenacao implements Comparator {

	private String propriedade;

	private static Ordenacao instance;

	public static final boolean ORDENACAO_ASC = false;
	
	public static final boolean ORDENACAO_DESC = true;


	/**
	 * Construtor privado.
	 */
	private Ordenacao() {
		super();
	}

	/**
	 * retorna a instancia ativa da classe Ordenacao.
	 */
	private synchronized static Ordenacao getInstance() {
		if (instance == null) {
			instance = new Ordenacao();
		}
		return instance;
	}

	/**
	 * Metodo de implementação obrigatoria quando se implementa a interface Comparator. 
	 * 
	 * Adaptado para comparações entre: - Integer, Float, Double,
	 * Byte, Long, String e java.util.Date
	 */
	public int compare(Object primeiro, Object segundo) {
		try {
			if (!objetosSaoNulos(primeiro, segundo)) {
				Object o1 = null;
				Object o2 = null;
				
				if (ordenarListaVOs()) {
					Method metodoBean = recuperarMetodoDoBean(primeiro);
					o1 = metodoBean.invoke(primeiro, null);
					o2 = metodoBean.invoke(segundo, null);
				}else{
					o1 = primeiro;
					o2 = segundo;
				}

				if (objetosSaoNumericos(o1, o2)) {
					return (compararNumerico(o1, o2));
				}
				if (objetosSaoData(o1, o2)) {
					return (compararDate(o1, o2));
				}
				if (objetosSaoString(o1, o2)) {
					return compararString(o1, o2);
				}
			}
		} catch (NoSuchMethodException noSuchMethodException) {
			throw new RuntimeException(noSuchMethodException);
		} catch (InvocationTargetException invocationTargetException) {
			throw new RuntimeException(invocationTargetException);
		} catch (IllegalAccessException illegalAccessException) {
			throw new RuntimeException(illegalAccessException);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return -1;
	}

	/**
	 * @param o1
	 * @param o2
	 * @return, true caso ambos os Objetos não sejam nulos.
	 */
	private boolean objetosSaoNulos(Object o1, Object o2) {
		return (o1 == null || o2 == null);
	}

	/**
	 * @param o1
	 * @param o2
	 * @return, true caso os objetos sejam instancias de String
	 */
	private boolean objetosSaoString(Object o1, Object o2) {
		return ((o1 != null && o2 != null) && (o1 instanceof String && o2 instanceof String));
	}

	/**
	 * @param o1
	 * @param o2
	 * @return, true caso os objetos sejam instancias numericas.
	 */
	private boolean objetosSaoNumericos(Object o1, Object o2) {
		return (o1 != null && o2 != null && o1 instanceof Integer
				|| o1 instanceof Float || o1 instanceof Double
				|| o1 instanceof Byte || o1 instanceof Long);
	}

	/**
	 * @param o1
	 * @param o2
	 * @return, true caso os objetos sejam instancias de java.util.Date
	 */
	private boolean objetosSaoData(Object o1, Object o2) {
		return ((o1 != null && o2 != null) && (o1 instanceof Date && o2 instanceof Date));
	}

	/**
	 * @return, true caso a propriedade do Bean (VO) tenha sido informada.
	 */
	private boolean ordenarListaVOs() {
		return (propriedade != null && (propriedade.trim().length() > 0));
	}

	/**
	 * @return, true caso a lista não esteja vazia.
	 */
	private static boolean listaContemObjetos(List lista) {
		return (lista != null && !lista.isEmpty());
	}

	/**
	 * @return o resultado da comparação entre numeros
	 */
	private int compararNumerico(Object o1, Object o2) {
		return (new Double(String.valueOf(o1))).compareTo(new Double(String.valueOf(o2)));
	}

	/**
	 * @return o resultado da comparação entre datas
	 */
	private int compararDate(Object o1, Object o2) {
		return ((Date) o1).compareTo((Date) o2);
	}

	/**
	 * @return o resultado da comparação entre Strings
	 */
	private int compararString(Object o1, Object o2) {
		return ((String) o1).compareToIgnoreCase((String) o2);
	}

	/**
	 * Recupera o metodo 'getXXX()' da classe cuja propriedade será a ordenação
	 * desejada.
	 * 
	 * @param primeiro
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	private Method recuperarMetodoDoBean(Object primeiro)
			throws SecurityException, NoSuchMethodException {
		return primeiro.getClass().getDeclaredMethod("get".concat(propriedade.substring(0, 1).toUpperCase()).concat(propriedade.substring(1)), null);
	}

	/**
	 * Método responsável por retornar uma lista de Object ordenada pela propriedade do VO informada.
	 * 
	 * @param List lista, a lista que se deseja ordenar.
	 * @param String propriedadeOrdenacaoDesejada, a propriedade de ordenação desejada.
	 * @param tipoOrdenacao, o tipo de ordenação desejada [Ascendente(false) ou Descendente(true)]
	 * @return a lista ordenada pela propriedade desejada.
	 */
	@SuppressWarnings("unchecked")
	public static List ordenarLista(List lista, String propriedadeOrdenacaoDesejada, boolean tipoOrdenacao) {
		if (listaContemObjetos(lista)) {
			getInstance().propriedade = propriedadeOrdenacaoDesejada;
			Collections.sort(lista, getInstance());

			if (tipoOrdenacao) {
				Collections.reverse(lista);
			}
		}
		return lista;
	}

	// *-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-***-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	// *-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-***-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	// *-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-***-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	// *-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-***-*-*-**-*--*-*-*-**--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	//	class Foo {
	//		private String nome;
	//		private String endereco;
	//		private int idade;
	//		private Date nascimento;
	//		}
	//
	// Metodo de teste da classe Ordenacao.java
	//
	//
	/*public static void main(String[] args) throws ParseException, AppBaseException{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = df.parse("12/10/1978");
		Date d2 = df.parse("25/11/1985");
		Date d3 = df.parse("12/10/1980");
		Date d4 = df.parse("26/10/1980");
		
		Foo c0 = new Foo(new ModeloFoo("Batista", "Rua Preguça", "40", "12/10/1978"));
		Foo c1 = new Foo(new ModeloFoo("Andre", "Rua XYZ", "18", "25/08/1985"));
		Foo c2 = new Foo(new ModeloFoo("Bruna", "Rua Abc", "20", "12/10/1980"));
		Foo c3 = new Foo(new ModeloFoo("Christiano", "Rua bha", "12", "26/10/1980"));

		ArrayList ar = new ArrayList();
		ar.add(c0);
		ar.add(c1);
		ar.add(c2);
		ar.add(c3);

		System.out.println("----Ordenção por nome");
		ar = (ArrayList) Ordenacao.ordenarLista(ar, "nome", Ordenacao.ORDENACAO_ASC);

		for (Iterator iter = ar.iterator(); iter.hasNext();) {
			Foo c = (Foo) iter.next();
			System.out.println(c.getNome() + " - " + c.getEndereco() + " - "
					+ c.getIdade() + " - " + c.getNascimento().toString());
		}

		// -----------
		System.out.println();
		System.out.println("----Ordenção por endereço");
		ar = (ArrayList) Ordenacao.ordenarLista(ar, "endereco", Ordenacao.ORDENACAO_ASC);

		for (Iterator iter = ar.iterator(); iter.hasNext();) {
			Foo c = (Foo) iter.next();
			System.out.println(c.getNome() + " - " + c.getEndereco() + " - "
					+ c.getIdade() + " - " + c.getNascimento().toString());
		}

		// ---------
		System.out.println();
		System.out.println("----Ordenção por idade");
		ar = (ArrayList) Ordenacao.ordenarLista(ar, "idade", Ordenacao.ORDENACAO_ASC);

		for (Iterator iter = ar.iterator(); iter.hasNext();) {
			Foo c = (Foo) iter.next();
			System.out.println(c.getNome() + " - " + c.getEndereco() + " - "
					+ c.getIdade() + " - " + c.getNascimento().toString());
		}

		// ---------
		System.out.println();
		System.out.println("----Ordenção por data de nascimento");
		ar = (ArrayList) Ordenacao
				.ordenarLista(ar, "nascimento", Ordenacao.ORDENACAO_ASC);

		for (Iterator iter = ar.iterator(); iter.hasNext();) {
			Foo c = (Foo) iter.next();
			System.out.println(c.getNome() + " - " + c.getEndereco() + " - " + c.getIdade() + " - " + df.format(c.getNascimento()));
		}

		// -*-*-*-*-*-*-*-*-*-*-*-

		System.out.println();
		System.out.println();
		System.out.println("----Ordenção de lista de Strings");
		ArrayList ar2 = new ArrayList();
		ar2.add("Christiano Rodarte Vale");
		ar2.add("Luciano Rodarte Vale");
		ar2.add("Alberto Roberto");
		ar2.add("Chico Anisio");
		ar2.add("Ayrton Senna");
		ar2 = (ArrayList) Ordenacao.ordenarLista(ar2, null, Ordenacao.ORDENACAO_ASC);
		for (Iterator iter = ar2.iterator(); iter.hasNext();) {
			String s = (String) iter.next();
			System.out.println(s);
		}

		// -*-*-*-*-*-*-*-*-*-*-*-

		System.out.println();
		System.out.println();
		System.out.println("----Ordenção de lista de Integer");
		ArrayList ar3 = new ArrayList();
		ar3.add(12);
		ar3.add(54);
		ar3.add(42);
		ar3.add(425);
		ar3.add(427);
		ar3.add(4);
		ar3 = (ArrayList) Ordenacao.ordenarLista(ar3, null, Ordenacao.ORDENACAO_ASC);
		for (Iterator iter = ar3.iterator(); iter.hasNext();) {
			Integer i = (Integer) iter.next();
			System.out.println(i.intValue());
		}

		// -*-*-*-*-*-*-*-*-*-*-*-

		System.out.println();
		System.out.println();
		System.out.println("----Ordenção de lista de Data");
		ArrayList ar4 = new ArrayList();
		ar4.add(d1);
		ar4.add(d2);
		ar4.add(d3);
		ar4.add(d4);
		ar4 = (ArrayList) Ordenacao.ordenarLista(ar4, null, Ordenacao.ORDENACAO_ASC);
		for (Iterator iter = ar4.iterator(); iter.hasNext();) {
			Date d = (Date) iter.next();
			System.out.println(df.format(d));
		}
	}*/

}
