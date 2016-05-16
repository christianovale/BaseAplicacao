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
 */
public class StringUtil {
	
    public StringUtil() {
    }

    /**
     * Retorna uma String de tamanho máximo reduzido de acordo com a necessidade do usuario.
     * @param aString, A String a exibir.
     * @param tamanhoMaximo, o tamanho máximo da String que será retornado.
     * @return
     */
    public static String encurtarTamanhoString(String aString, int tamanhoMaximo) {
        StringBuffer str = new StringBuffer();

        if (aString.length() >= tamanhoMaximo) {
            for (int i = 0; i < tamanhoMaximo - 3; i++) {
                char c = aString.charAt(i);
                str.append(String.valueOf(c));
            }
            String adicionar = "...";
            str.append(adicionar);
        }
        else {
            str.append(aString);
        }
        return str.toString();
    }
    
    /**
     * 
     * @param valor
     * @return
     */
    public static String formatarTextoWeb(String valor) {
        valor = valor.replaceAll("á", "&aacute;");
        valor = valor.replaceAll("é", "&eacute;");
        valor = valor.replaceAll("í", "&iacute;");
        valor = valor.replaceAll("ó", "&oacute;");
        valor = valor.replaceAll("ú", "&uacute;");
        valor = valor.replaceAll("Á", "&Aacute;");
        valor = valor.replaceAll("É", "&Eacute;");
        valor = valor.replaceAll("Í", "&Iacute;");
        valor = valor.replaceAll("Ó", "&Oacute;");
        valor = valor.replaceAll("Ú", "&Uacute;");
        valor = valor.replaceAll("â", "&acirc;");
        valor = valor.replaceAll("ê", "&ecirc;");
        valor = valor.replaceAll("ô", "&ocirc;");
        valor = valor.replaceAll("Â", "&Acirc;");
        valor = valor.replaceAll("Ê", "&Ecirc;");
        valor = valor.replaceAll("Ô", "&Ocirc;");
        valor = valor.replaceAll("ç", "&ccedil;");
        valor = valor.replaceAll("ã", "&atilde;");
        valor = valor.replaceAll("õ", "&otilde;");
        valor = valor.replaceAll("à", "&agrave;");

        return valor;
    }
}


