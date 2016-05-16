package br.com.christianovale.base.aplicacao.util;

import java.util.List;

/**
 * @author christiano.vale
 * @version 1.0.1
 * 
 * Implementação do Pattern "Value List Handler" para paginação de resultados
 * 
 * Executa a pesquisa para obter os resultados da consulta, os quais ele
 * gerencia em uma coleção armazanada privativamente representada pelo objeto
 * List valueList.
 * 
 * Cria e manipula a coleção valueList normalmente usando DAO e armazenando o 
 * resultado da busca em cache para rápida recuperação.
 *  
 * Quando o cliente solicita os resultados, o ValueListHandler cria uma sublista
 * a partir do valueList original e a envia para o Cliente.
 * 
 * ************************************************************************************************
	 * Metodo chamado quando o cliente clica nos botoes: PROXIMO, ANTERIOR, PRIMEIRO, ULTIMO.
	 * 
	 * Verifica se existe a lista com os resultados em cache e caso não exista,
	 * chama o DAO para realizar a pesquisa e armazenar o resultado em cache.
	 * 
	 * @param pagina, o numero da pagina que vai ser exibida.
	 * @throws Exception
	 **********************************************************************************************
	public void exibirResultados(int pagina) throws Exception{
		//Necessario pois a primeira pagina é 0 (zero)------
		if(pagina > 0){
			pagina--;
		}
		
		//Verifica se a lista existe em Cache---------------
		List lista = this.listaResultados;
		if(lista == null){
			executarBusca();
			lista = this.listaResultados;
		}
		
		//Calculo dos indices Inicial e Final---------------
		int indiceInicial = QUANTIDADE_RESULTADOS_PAGINA * pagina;
		int indiceFinal = indiceInicial + QUANTIDADE_RESULTADOS_PAGINA;
		
		//Cria o objeto ValueListHandler--------------------
		ValueListHandler valueListHandler = new ValueListHandler(lista);
		
		//Informações de Numero de Pagina, Total de Registros Encontrados e Total de Paginas.-----
		String numeroPagina = String.valueOf(++pagina);
		String totalRegistros = String.valueOf(valueListHandler.getTotalRegistros());
		int totalDePaginas = (int) Math.ceil(((float)valueListHandler.getTotalRegistros())/((float) QUANTIDADE_RESULTADOS_PAGINA));
		
		//Exibe os resultados na tela------------------------
		System.out.println("Foram encontrados " + totalRegistros +
		              " registros.   Mostrando pagina " + numeroPagina + 
		              " de " + totalDePaginas);
		List listaResultados = valueListHandler.getNextElements(indiceInicial, indiceFinal);
		for (Iterator iter = listaResultados.iterator(); iter.hasNext();) {
			String s = (String) iter.next();
			System.out.println(s);
		}
	}

 */

public class ValueListHandler {
	
	private List valueList;
	
	//Construtores para a classe ValueListHandler------
		public ValueListHandler(){ 
		}
		
		public ValueListHandler(List valueList){
			this.valueList = valueList;
		}
	//-------
	
	public void setList(List valueList){
		this.valueList = valueList;
	}
	
	public List getList(){
		return this.valueList;
	}
	
	public List getNextElements(int posicaoInicial, int posicaoFinal){
		if(posicaoFinal > this.getTotalRegistros()){
			posicaoFinal = this.getTotalRegistros();
		}
		return this.valueList.subList(posicaoInicial, posicaoFinal);
	}
	
	public Object getObjeto(int index){
		return this.valueList.get(index);
	}
	
	public int getTotalRegistros(){
		return this.valueList.size();
	}
}

