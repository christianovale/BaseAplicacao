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
 */
public class Recurso {

    public static final String VERDADEIRO = "V";
    public static final String FALSO = "F";

    public static final String DRIVER_SGDB = "com.mysql.jdbc.Driver";

    public static final String URL_SGDB = "jdbc:mysql://localhost:3306/itradeti_";
    public static final String USUARIO_SGDB = "suporte";
    public static final String SENHA_SGDB = "1111";
    public static final String SGDB_NOME = "minhaBaseDeDados";

    /**
     * @todo retirar o teste de conexao;
     */
    public static int NUMERO_CONEXAO = 0;

    public static final String URL_APACHE = "jdbc:apache:commons:dbcp:";
    public static final String DRIVER_APACHE = "org.apache.commons.dbcp.PoolingDriver";
}
