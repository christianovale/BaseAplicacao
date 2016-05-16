package br.com.christianovale.base.aplicacao.util;


/**
 * @author christiano vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplica��o</p>
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
     * Retorna uma String de tamanho m�ximo reduzido de acordo com a necessidade do usuario.
     * @param aString, A String a exibir.
     * @param tamanhoMaximo, o tamanho m�ximo da String que ser� retornado.
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
        valor = valor.replaceAll("�", "&aacute;");
        valor = valor.replaceAll("�", "&eacute;");
        valor = valor.replaceAll("�", "&iacute;");
        valor = valor.replaceAll("�", "&oacute;");
        valor = valor.replaceAll("�", "&uacute;");
        valor = valor.replaceAll("�", "&Aacute;");
        valor = valor.replaceAll("�", "&Eacute;");
        valor = valor.replaceAll("�", "&Iacute;");
        valor = valor.replaceAll("�", "&Oacute;");
        valor = valor.replaceAll("�", "&Uacute;");
        valor = valor.replaceAll("�", "&acirc;");
        valor = valor.replaceAll("�", "&ecirc;");
        valor = valor.replaceAll("�", "&ocirc;");
        valor = valor.replaceAll("�", "&Acirc;");
        valor = valor.replaceAll("�", "&Ecirc;");
        valor = valor.replaceAll("�", "&Ocirc;");
        valor = valor.replaceAll("�", "&ccedil;");
        valor = valor.replaceAll("�", "&atilde;");
        valor = valor.replaceAll("�", "&otilde;");
        valor = valor.replaceAll("�", "&agrave;");

        return valor;
    }
}


