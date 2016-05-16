package br.com.christianovale.base.aplicacao.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

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
 */
public class FormatadorNumero {
	
	 /**
     * Coloca um numero com formato decimal com duas casas decimais.
     * @param valor String, a String com o numero a formatar.
     * @return String
     */
    public static String formatarNumeroDuasCasasDecimais(String valor) {
        if (valor.equals("")) {
            return valor;
        }
        else {
            Locale ptBR = new Locale("pt", "BR");
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(ptBR);
            NumberFormat nf = new DecimalFormat("#,##0.00", dfs);
            valor = nf.format(Double.parseDouble(valor));
            return valor;
        }
    }
    
    /*public static void main(String[] args) {
		System.out.println(formatarNumeroDuasCasasDecimais("1.56"));
		System.out.println(formatarNumeroDuasCasasDecimais("156"));
	}*/

}
