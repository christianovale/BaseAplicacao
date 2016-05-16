package br.com.christianovale.base.aplicacao.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Classe com mï¿½todos de formataï¿½ï¿½o de valores, nï¿½meros, texto, etc.
 */
public class FormatUtils  {
	private FormatUtils() {}

		private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

 	     /**
	     * Retira qualquer caracter nï¿½o numï¿½rico de uma String
	     * @param numero
	     * @return novoNumero
	     * @author eduardo.costa
	     */
		public static String retornarApenasDigitos(String numero){
			if (numero==null){return null;}
	    	StringBuffer novoNumero = new StringBuffer();
	    	for (int i = 0 ; i < numero.length() ; i++){
	    		if (Character.isDigit(numero.charAt(i))){
	    			novoNumero.append(numero.charAt(i));
	    		}
	    	}
	    	return novoNumero.toString();
	    }

		/**
	     * Colocar Mascara em CNPJ ou CPF
	     * @param numero
	     * @return novoNumero
	     * @author eduardo.costa
	     */
		public static String mascararCnpjCpf(String numero){
			String novoNumero = null;
			if (numero != null){
				
				if (numero.length()==11){
				   novoNumero = retornaCpfComMascara(numero);
			    } else 	if (numero.length()==14){
				   novoNumero = retornaCnpjComMascara(numero);
				}
			}
			
			return novoNumero;
		}
		
		/**
		* Retira a mï¿½scara de qualquer nï¿½mero passando uma Expressï¿½o Regular.
		* @return String caso o nï¿½mero esteja no formato adequado.
		* @param numero 
		* @param formato
		* @autor Gabriela Castanha
		*/
		public static String retirarMascaraNumero(String numero, String formato){
			String result = "";
			Pattern pattern = Pattern.compile(formato);
			Matcher matcher = pattern.matcher(numero);
			boolean correto = matcher.matches();
		
			if( correto ){
				StringBuffer numeroCompacto = new StringBuffer();
				for(int i=1; i<=matcher.groupCount(); i++){
					numeroCompacto.append(matcher.group(i));
				}
				result = numeroCompacto.toString();
			}else{
				result = null;	
			}
			return result;
		}
	
	/**
	 * Retira a mï¿½scara de CPF.
	 * @return String caso o nï¿½mero esteja no formato adequado.
	 * @param numero 	 
	 * @autor Gabriela Castanha
	 */
	 public static String retirarMascaraCpf(String numero){
		return retirarMascaraNumero(numero, "^(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})$");
	}
	
	/**
	 * Retira a mï¿½scara de RG.
	 * @return String
	 * @param rg 	 
	 * @autor Gabriela Castanha
	 */
	 public static String retirarMascaraRg(String rg){
		return rg.replaceAll("[^a-zA-Z0-9]","");
	}
	
	/**
	 * Retornar mï¿½scara de RG.
	 * @return String
	 * @param numero 	 
	 * @autor Gabriela Castanha
	 */
	 public static String retornarMascaraRg(String rg){
		return rg.replaceAll("\\d.*", "") + "-" + rg.replaceAll("([a-zA-Z]*)", "");
	}
	
	/**
	 * Retornar mï¿½scara de CEP.
	 * @return String
	 * @param numero 	 
	 * @autor Gabriela Castanha
	 */
	 public static String retornarMascaraCep(String cep){
		if (cep != null){
			return cep.substring(0,5) + "-" + cep.substring(5,8);
		}
		return "";
	}
 
	/**
	 * Retornar mï¿½scara de telefone FAX e TEL simples (9999-9999).
	 * @return String
	 * @param numero 	 
	 * @autor Lucas Ferreira
	 */
	 public static String retornarMascaraTelFax(String tel){
		if (tel != null && tel.length() == 8){
			return tel.substring(0,4) + "-" + tel.substring(4,8);
		}
		return "";
	}
	
	 
	/**
	 * Retornar mï¿½scara de numero de protocolo (X9999999/AAAA).
	 * X - caracter qualquer
	 * 9 - numeros
	 * AAAA - ano
	 * @return String
	 * @param numero 	 
	 * @autor Lucas Ferreira
	 */
	 public static String retornarMascaraNumProtocolo(String num){
		if (num != null){
			return num.substring(0,8) + "/" + num.substring(8,12);
		}
		return "";
	}	 

	 /**
	 * Retira mï¿½scara de numero de protocolo (X9999999/AAAA).
	 * X - caracter qualquer
	 * 9 - numeros
	 * AAAA - ano
	 * @return String diferente de null.
	 * @param Numero Protocolo
	 * @autor Lucas Ferreira
	 */
	 public static String retirarCaracter(String num, String caracter){
      String result = "";
			StringTokenizer tok = null;
			if (num != null) {
				// Retira a Maskara do numero de protocolo
				tok = new StringTokenizer(num, caracter, false);
				while (tok.hasMoreTokens()) {
					result += tok.nextToken();                
				}               
			} else {
				result = null;			
			}
   return result;
	 }	 
	 
	 
	/**
	 * Retira a mï¿½scara de CNPJ passando uma Expressï¿½o Regular.
	 * @return String caso o nï¿½mero esteja no formato adequado.
	 * @param numero 	 
	 * @autor Gabriela Castanha
	 */
	 public static String retirarMascaraCnpj(String numero){
		return retirarMascaraNumero(numero, "^(\\d{2})\\.(\\d{3})\\.(\\d{3})/(\\d{4})\\-(\\d{2})$");
	}
	 
	/**
	 * Retira a mï¿½scara do CEP .
	 * @return String caso CEP seja diferente de null.
	 * @param CEP NNNNN-NNN 
	 * @autor Gabriela Castanha
	 */
	 public static String retirarMascaraCEP (String cep){
      String result = "";
			StringTokenizer tok = null;
			if (cep != null) {
				// Retira a Maskara do CEP                
				tok = new StringTokenizer(cep, "-", false);
				while (tok.hasMoreTokens()) {
					result += tok.nextToken();                
				}               
			} else {
				result = null;			
			}
   return result;
	 }
   
    /**
	 * Retira mï¿½scara de telefone FAX e TEL simples (9999-9999).
	 * @return String caso FAX e TEL seja diferente de null.
	 * @param FAX e TEL  
	 * @autor Lucas Ferreira
	 */
	 public static String retirarMascaraTelFax(String telefone){
      String result = "";
			StringTokenizer tok = null;
			if (telefone != null) {
				// Retira a Maskara do Tel e Fax
				tok = new StringTokenizer(telefone, "-", false);
				while (tok.hasMoreTokens()) {
					result += tok.nextToken();                
				}               
			} else {
				result = null;			
			}
   return result;
	 }
		 
   /**
	 * Retira a mï¿½scara de TELEFONE/FAX .
	 * @return String caso TELEFONE/FAX seja diferente de null.
	 * @param 
	 * @autor Gabriela Castanha
	 */
	 public static String retirarMascaraTelefone (String telefone){
     String result = "";
			StringTokenizer tok = null;
			if (telefone != null) {
				// Retira a Maskara do Telefone                
				tok = new StringTokenizer(telefone, "(, ), -", false);
				while (tok.hasMoreTokens()) {
					result += tok.nextToken();                
				}               
			} else {
				result = null;			
			} 
   return result;
	 }
	 
	 
	 /**
     * Retorna um nï¿½mero de uma qualquer Integer formatada com 5 posiï¿½ï¿½es para o nï¿½mero.
     * Ou seja, completa com zeros a esquerda atï¿½ que o tamanho da String seja atendido.
     * Por exemplo, um Sequencial de valor 23, com numero de Casas igual a 4, ficarï¿½ 0023.
     * @return Nï¿½mero da Aglutinacao formatada
     * @param numAglutinacao Nï¿½mero da Aglutinacao do tipo Wrapper Integer
     * @param tamanhoString Tamanho da String para formataï¿½ï¿½o do Arquivo
     */
    public static String formataNumero(Integer numInteiro, Integer tamanhoString){
        if (numInteiro==null || tamanhoString==null) return null;
        String strTemp = numInteiro.toString();
        while (strTemp.length() < tamanhoString.intValue()){
            strTemp = "0" + strTemp;
        }
        return strTemp;
    }

	 /**
     * Retorna um nï¿½mero de uma qualquer Integer formatada com 5 posiï¿½ï¿½es para o nï¿½mero.
     * Ou seja, completa com zeros a esquerda atï¿½ que o tamanho da String seja atendido.
     * Por exemplo, um Sequencial de valor 23, com numero de Casas igual a 4, ficarï¿½ 0023.
     * @return Nï¿½mero da Aglutinacao formatada
     * @param numAglutinacao Nï¿½mero da Aglutinacao do tipo Wrapper Integer
     * @param tamanhoString Tamanho da String para formataï¿½ï¿½o do Arquivo
     */
    public static String formataNumero(String numInteiro, int tamanhoString){
        if (numInteiro != null && tamanhoString > 0 ){ 
        	while (numInteiro.length() < tamanhoString){
        		numInteiro = "0" + numInteiro;
        	}
        	return numInteiro;
        }else{
        	return null;
        }
    }
    
    /**
     * Substitue todos os espaï¿½os em branco do nome do arquivo com o caracter
     * '_' (underline). Foi adotado este procedimento para nï¿½o se peder a extensao
     * do arquivo na hora do download pois o browser nï¿½o reconhece espaï¿½os no nome
     * de um arquivo.
     * @return Nome do arquivo sem espaï¿½os em Branco
     * @param nomeArquivo Nome Original do Arquivo
     */
    public static String formataNomeArquivo(String nomeArquivo){
        if (nomeArquivo!=null && nomeArquivo.length()!=0){
			StringBuffer str = new StringBuffer(nomeArquivo);
			for (int i=0; i<str.length();i++){
				if (str.charAt(i)==' '){
					str.setCharAt(i,'_');
				}
			}
			return str.toString();
		}
		return "";
    }

 /**
     * Funï¿½ï¿½o que insere mï¿½scara de formataï¿½ï¿½o a um Cpf sem mï¿½scara.
     * @return String com o Cpf formatado
     * @param str String com um CPF vindo de um Objeto Persistente. Somente nï¿½meros.
     * 
     * @author Ricardo Terra
     */
    public static String retornaCpfComMascara(String str){
		if (str != null){
			return str.substring(0,3) + '.' + str.substring(3,6) + '.' + str.substring(6,9) + '-'  + str.substring(9,11); 
		}
		return "";
    }
    
    /**
     * Funï¿½ï¿½o que insere mï¿½scara de formataï¿½ï¿½o a um Cnpj sem mï¿½scara.
     * @return String com o Cnpj formatado
     * @param str String com um CNPJ vindo de um Objeto Persistente. Somente nï¿½meros.
     * 
     * @author Ricardo Terra
     */
    public static String retornaCnpjComMascara(String str){
		if (str != null){
			if (str.length() < 14){
				int dif  = 14 - str.length();
				for (int i = 0; i < dif ; i++ ){
					str = "0" + str; 
				}
			}
			return str.substring(0,2) + '.' + str.substring(2,5) + '.' + str.substring(5,8) +
			'/'  + str.substring(8,12) + '-' + str.substring(12,14);
		}
		return "";
    }

    /**
	 * Funnï¿½ï¿½o que insere formato Real(R$) em colunas da display-tag.
	 * @return String com o valor formatado para Real(R$).
	 * @param valor Objeto que deve receber a formataï¿½ï¿½o.
	 */
	public static String setFormatoReal(Object valor) {

		DecimalFormat formato = new DecimalFormat();
        Locale brLocale = new Locale("pt", "BR");
        formato = (DecimalFormat)DecimalFormat.getCurrencyInstance(brLocale);        
		valor = formato.format(valor);
		return valor.toString();
	}

    /**
     * Funï¿½ï¿½o que retira todos os caracteres nï¿½o numï¿½ricos de uma string qualquer.
     * @return String somente com os nï¿½meros
     * @param str String com um CPF ou CNPJ ou Inscriï¿½ï¿½o Estadual, etc
     * 
     * @author Ricardo Terra
     */
    public static String retiraCaracterNaoNumerico(String str){
        String resultado = "";
        for (int i=0; i<str.length();i++){
            if (Character.isDigit(str.charAt(i))){
                resultado += str.charAt(i);
            }
        }
        return resultado;
    }

	/**
     * Funï¿½ï¿½o que insere mï¿½scara de formataï¿½ï¿½o a um Telefone/Fax sem mï¿½scara.
     * @return String com o Telefone/Fax formatado
     * @param str String com um Telefone/Fax vindo de um Objeto Persistente. Somente nï¿½meros.
     * 
     * @author Gabriela Castanha
     */
	public static String retornaTelefoneComMascara(String str){
		if (str != null && str.length() == 10){
			return "(" + str.substring(0,2) + ")" + str.substring(2,6) + "-" + str.substring(6,10);
		}
		return str = "";
	}

	/**
	 * Formata um texto retirando as quebras de linha,
	 * alteranda as aspas para um tipo nï¿½o HTML e limitando
	 * a um tamanho mï¿½ximo.
	 * @return Texto formatado em JavaScript
	 * @param maxLength Tamanho mï¿½ximo de exibiï¿½ï¿½o do texto
	 * @param texto Texto a ser formatado
	 * @author Ricardo Terra
	 */
	public static String formataTextoExibicao(String texto, int maxLength){
		texto = formataTextoExibicao(texto);
		if (texto==null) return null;
		if (texto.length()<=maxLength){
			return texto;
		}
		return texto.substring(0,maxLength) + "...";
	}

	/**
	 * Formata um texto retirando as quebras de linha e
	 * alteranda as aspas para um tipo nï¿½o HTML
	 * @return Texto formatado em JavaScript
	 * @param texto Texto a ser formatado
	 * @author Ricardo Terra
	 */
	public static String formataTextoExibicao(String texto){
		if (texto==null) return null;
		return texto.replaceAll("\r","").replaceAll("\n","").replaceAll("'","ï¿½").replaceAll("\"","`");
		
	}
	
	/**
	 * Formata um texto substituindo as quebras de linha por
	 * quebra de linha HTML (BR) e alterando as aspas para um tipo nï¿½o HTML
	 * a fim de nï¿½o alterar a funcionalidade esperada.
	 * @return Texto formatado em HTML
	 * @param texto Texto a ser formatado
	 * @author Ricardo Terra
	 */
	public static String formataTextoExibicaoHTML(String texto){
		if (texto==null) return null;
		return texto.replaceAll("\r\n","<BR/>").replaceAll("\r","<BR/>").replaceAll("\n","<BR/>").replaceAll("'","ï¿½").replaceAll("\"","`");
		
	}	
	
	public static String formataInscricaoMunicipal(String texto){
		String sb = new String(texto);
		sb = sb.substring(0,3) + '.' + sb.substring(3,6) + '/' + sb.substring(6,9) + '-'  + sb.substring(9,10);
		while (sb.length()<13)
			sb = "0"+sb;	
		return sb;
	}	
	
	public static String formataInscricaoEstadual(String texto){
		String sb = new String(texto);
		sb = sb.substring(0,2) + '.' + sb.substring(2,5) + '.' + sb.substring(5,8) + '.' + sb.substring(8,10) + '.' + sb.substring(10,12) ;
		while (sb.length()<17)
			sb = "0"+sb;
		return sb;
	}	
	/**
	 * Formata nï¿½mero racional para formato double com ponto separador dos dï¿½gitos decimais.
	 * @author Ricardo Gusmï¿½o
	 */
	public static String desformataDoubleSimples(String numero){
		if(numero.lastIndexOf("E") != -1)
			numero = desformataNumeroCientifico(numero);
		
		return numero.replaceAll(",",".");	
	}
	
	/**
	 * Desformata nï¿½mero racional para formato double com vï¿½rgula separadora dos dï¿½gitos decimais.
	 * @author Ricardo Gusmï¿½o
	 * @param numero
	 * @return
	 */
	public static String formataDoubleSimples(String numero){
		if(numero.lastIndexOf("E") != -1)
			numero = desformataNumeroCientifico(numero);
		
		numero = numero.replaceAll("\\.",",");		
		return numero.indexOf(',') == -1 ? numero+",0" : numero;
	}
	
	/**
	 * 
	 * @author Ricardo Gusmï¿½o
	 */
	public static String desformataDecimal(String numero){
		return desformataFracionalComSeparadores(numero);
	}
	
	public static String desformataFracionalComSeparadores(String numero){
		if (numero != null){
			if(numero.lastIndexOf('E') != -1)
				numero = desformataNumeroCientifico(numero);
			
			numero = numero.replaceAll("\\.","");	
			numero = numero.replaceAll(",",".");
		}
		return numero;
	}
	
	/**
	 * Formata nï¿½mero em formato de notaï¿½ï¿½o cientï¿½fica para nï¿½mero fracional padrï¿½o.
	 * @param String nï¿½mero formato x.xxxxEx
	 * @return String nï¿½mero formato xxxxx.xxx
	 * @author Ricardo Gusmï¿½o
	 */
	public static String desformataNumeroCientifico(String numero){
		StringBuffer bufferNumero = new StringBuffer();
		
		bufferNumero.append(numero.substring(0,numero.lastIndexOf('E')));
		int numeroPotencia = new Integer(numero.substring(numero.lastIndexOf("E")+1)).intValue();
		int posicaoVirgula = numero.indexOf(".");
		
		bufferNumero.deleteCharAt(posicaoVirgula);
		
		bufferNumero.insert(posicaoVirgula + numeroPotencia,".");
		
		return bufferNumero.toString();
	}
	
	/**
	 * Formata nï¿½mero racional com separadores formato xxx.xxx.xxx,xxxx para formato double com ponto separador dos dï¿½gitos decimais.
	 * @author Ricardo Gusmï¿½o
	 */
		@SuppressWarnings("unchecked")
	public static String formataFracionalComSeparadores(String numero, int casasDecimais){
		
		if(numero.lastIndexOf("E") != -1)
			numero = desformataNumeroCientifico(numero);
		
		StringBuffer bufferInteiro = new StringBuffer();
		StringBuffer bufferFracional = new StringBuffer();
		
		if(numero.lastIndexOf(".") != -1){
			bufferInteiro.append(numero.substring(0,numero.lastIndexOf(".")));
			
			if(numero.lastIndexOf(".") + 1 < numero.length())
				bufferFracional.append(numero.substring(numero.lastIndexOf(".")+1));
		} else {
			bufferInteiro.append(numero);
			bufferFracional.append("00");
		}
				
		
		
		int tamanhoSeparacao = 3;
		List listaIndicesInseridos = new ArrayList();
		for(int i = 0; i < bufferInteiro.length(); i++)
			if(i != 0 && i % tamanhoSeparacao == 0)
				listaIndicesInseridos.add(0,new Integer(bufferInteiro.length()-i));
		
		int numeroInsersoes = 0;
		for (Iterator iter = listaIndicesInseridos.iterator(); iter.hasNext();) {
			Integer element = (Integer) iter.next();
			
			bufferInteiro.insert(element.intValue() + numeroInsersoes,".");
			
			numeroInsersoes ++;
		}
		
		while(bufferFracional.length() <  casasDecimais )
			bufferFracional.append("0");
		
		if(bufferFracional.length() > casasDecimais){
			String temp = bufferFracional.substring(0, casasDecimais);
			bufferFracional = new StringBuffer();
			bufferFracional.append(temp);
		}
		return bufferInteiro.append(",").append(bufferFracional).toString();
	}
	
	/**
	 * Retorna objeto date a partir data
	 * @param date
	 * @return
	 */
	public static Date getDate(String date) {
		try {
			return df.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * Retorna ano da data
	 * @param date
	 * @return
	 */
	public static String getYear(Date date){
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		return String.valueOf(cl.get(Calendar.YEAR));
	}
	/**
	 * Retira todos os pontos e troca virgula por ponto
	 * Ã‰ utilizado para formatar numero com 4 casas decimais e deixÃ¡-lo de forma para conversÃ£o para BigDecimal
	 * Exemplo 1.236.523,2310 vira 1236523.2310
	 * @param value
	 * @return
	 */
	public static Double converte(String value){
		if(value == null || value.equals("")){
			return null;
		}
		char[] val = value.toCharArray();
		char v;
		StringBuilder resultado = new StringBuilder();
		for (int i = 0; i < val.length; i++) {
			v = val[i];
			switch (v) {
			case '.':
				break;
			case ',':
				resultado.append('.');
				break;

			default:
				resultado.append(v);
				break;
			}
		}
		return new Double(resultado.toString());
	}
	/**
	 * Recebe um BigDecimal e retorna ele formatado para moeda brasileira
	 * @param valor - exemplo 123456.6985
	 * @return - exemplo 123.456,6985
	 */
	public static String formataBigDecimal(BigDecimal valor){
		NumberFormat num = NumberFormat.getInstance(new Locale("pt", "BR"));
		num.setGroupingUsed(true);
		num.setMinimumFractionDigits(4);
		
		String res = num.format(valor);
		
		return res;
	}
	
	/**
	 * Recebe um BigDecimal e retorna ele formatado para moeda brasileira
	 * @param valor - exemplo 123456.6985
	 * @return - exemplo 123.456,6985
	 */
	public static String formataDecimal(String valor, int digitos){
		NumberFormat num = NumberFormat.getInstance(new Locale("pt", "BR"));
		num.setGroupingUsed(true);
		num.setMinimumFractionDigits(digitos);
		
		String res;
		try {
			res = num.format(Double.valueOf(valor));
		} catch (NumberFormatException e) {
			System.out.println("Número em formato inválido");
			return "0,00";
		}
		return res;
	}
}