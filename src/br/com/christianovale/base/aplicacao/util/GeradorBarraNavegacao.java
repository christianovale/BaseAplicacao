package br.com.christianovale.base.aplicacao.util;

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
 * Descreve uma classe para geração de barras de navegação. 
 */
public class GeradorBarraNavegacao {
	
	/**
	 * Metodo que gera a barra de navegacao na tabela de usuario
	 * @param pagAtual, a pagina atual da pesquisa.
	 * @param quantidadeTotalRegistrosEncontrados, a quantidade total de registros encontrados na pesquisa.
	 * @param quantidadeResultadoPorPagina, a quantidade de registros a exibir, por pagina
	 * @return,retorna a string com codigo jsp para montar a barra de navegacao
	 */
    public static String montarBarraNavegacao4Btn(int pagAtual, int quantidadeTotalRegistrosEncontrados, int quantidadeResultadoPorPagina) {
        StringBuffer barra = new StringBuffer();
        
        //o multiplo da quantidade de usuario definido por tabela
        int posicao = quantidadeResultadoPorPagina * (pagAtual - 1);

        int diferenca = quantidadeTotalRegistrosEncontrados - quantidadeResultadoPorPagina;

        if (quantidadeTotalRegistrosEncontrados < quantidadeResultadoPorPagina) {
        	barra.append("<img name=\"primeiro\" id=\"primeiro\" src=\"imagem/botao/primeiraDesabilitada.gif\" style=\"position:absolute; top:78px; left:550px; \">\n");
            barra.append("<img name=\"anterior\" id=\"anterior\" src=\"imagem/botao/anteriorDesabilitada.gif\" style=\"position:absolute; top:78px; left:580px; \">\n");
            barra.append("<img name=\"proximo\" id=\"proximo\" src=\"imagem/botao/proximaDesabilitada.gif\" style=\"position:absolute; top:78px; left:620px; \" >\n");
            barra.append("<img name=\"ultima\" id=\"ultima\" src=\"imagem/botao/ultimaDesabilitada.gif\" style=\"position:absolute; top:78px; left:650px; \">\n");
        
            return barra.toString();
        }
        else {
            if ((posicao + quantidadeResultadoPorPagina) == quantidadeResultadoPorPagina || posicao < 0) {
            	barra.append("<img name=\"primeiro\" id=\"primeiro\" src=\"imagem/botao/primeiraDesabilitada.gif\" style=\"position:absolute; top:78px; left:550px; \">\n");
                barra.append("<img name=\"anterior\" id=\"anterior\" src=\"imagem/botao/anteriorDesabilitada.gif\" style=\"position:absolute; top:78px; left:580px; \">\n");
                barra.append("<input type=\"image\" name=\"proximo\" id=\"proximo\" src=\"imagem/botao/proxima.gif\" style=\"position:absolute; top:78px; left:620px;\" onClick=\"proximoPagContato()\">\n");
                barra.append("<input type=\"image\" name=\"ultima\" id=\"ultima\" src=\"imagem/botao/ultima.gif\" style=\"position:absolute; top:78px; left:650px;\" onClick=\"ultimoPagContato()\">\n");
            
                return barra.toString();
            }
            else if (posicao < quantidadeResultadoPorPagina) {
            	barra.append("<img name=\"primeiro\" id=\"primeiro\" src=\"imagem/botao/primeiraDesabilitada.gif\" style=\"position:absolute; top:78px; left:550px; \">\n");
                barra.append("<img name=\"anterior\" id=\"anterior\" src=\"imagem/botao/anteriorDesabilitada.gif\" style=\"position:absolute; top:78px; left:580px; \">\n");
                barra.append("<input type=\"image\" name=\"proximo\" id=\"proximo\" src=\"imagem/botao/proxima.gif\" style=\"position:absolute; top:78px; left:620px;\" onClick=\"proximoPagContato()\">\n");
                barra.append("<input type=\"image\" name=\"ultima\" id=\"ultima\" src=\"imagem/botao/ultima.gif\" style=\"position:absolute; top:78px; left:650px;\" onClick=\"ultimoPagContato()\">\n");
            
                return barra.toString();
            }
            else if (posicao >= diferenca) {
            	barra.append("<input type=\"image\" name=\"primeiro\" id=\"primeiro\" src=\"imagem/botao/primeira.gif\" style=\"position:absolute; top:78px; left:550px;\" onClick=\"primeiroPagContato()\">\n");
                barra.append("<input type=\"image\" name=\"anterior\" id=\"anterior\" src=\"imagem/botao/anterior.gif\" style=\"position:absolute; top:78px; left:580px; \" onClick=\"anteriorPagContato()\" >\n");
                barra.append("<img name=\"proximo\" id=\"proximo\" src=\"imagem/botao/proximaDesabilitada.gif\" style=\"position:absolute; top:78px; left:620px; \" >\n");
                barra.append("<img name=\"ultima\" id=\"ultima\" src=\"imagem/botao/ultimaDesabilitada.gif\" style=\"position:absolute; top:78px; left:650px; \">\n");
            
                return barra.toString();
            }
            else {
            	barra.append("<input type=\"image\" name=\"primeiro\" id=\"primeiro\" src=\"imagem/botao/primeira.gif\" style=\"position:absolute; top:78px; left:550px;\" onClick=\"primeiroPagContato()\">\n");
                barra.append("<input type=\"image\" name=\"anterior\" id=\"anterior\" src=\"imagem/botao/anterior.gif\" style=\"position:absolute; top:78px; left:580px;\" onClick=\"anteriorPagContato()\">\n");
                barra.append("<input type=\"image\" name=\"proximo\" id=\"proximo\" src=\"imagem/botao/proxima.gif\" style=\"position:absolute; top:78px; left:620px;\" onClick=\"proximoPagContato()\">\n");
                barra.append("<input type=\"image\" name=\"ultima\" id=\"ultima\" src=\"imagem/botao/ultima.gif\" style=\"position:absolute; top:78px; left:650px;\" onClick=\"ultimoPagContato()\">\n");
            
                return barra.toString();
            }
        }
    }

}
