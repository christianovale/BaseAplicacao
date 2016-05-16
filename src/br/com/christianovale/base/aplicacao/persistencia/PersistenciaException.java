package br.com.christianovale.base.aplicacao.persistencia;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.AppErroCodigo;


/**
 * @author christiano vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplica��o</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 */
@SuppressWarnings("serial")
public class PersistenciaException extends AppBaseException {

    public static final AppErroCodigo ERROR_10000 = new AppErroCodigo(10000, "PersistenciaException", "Erro Inesperado.");

    //PoolConexao
    public static final AppErroCodigo ERROR_10100 = new AppErroCodigo(10100, "PersistenciaException", "Existe conexao aberta. Favor avisar para fechar.");
    public static final AppErroCodigo ERROR_10101 = new AppErroCodigo(10101, "PersistenciaException", "Erro ao criar o Pool de Conex�o com o banco de dados.");
    public static final AppErroCodigo ERROR_10102 = new AppErroCodigo(10102, "PersistenciaException", "Erro ao instanciar o drive de conex�o com o banco de dados.");
    public static final AppErroCodigo ERROR_10103 = new AppErroCodigo(10103, "PersistenciaException", "Erro ao obter a conex�o com o banco de dados.");
    public static final AppErroCodigo ERROR_10104 = new AppErroCodigo(10104, "PersistenciaException", "Erro ao cancelar a conex�o com o banco de dados.");
    public static final AppErroCodigo ERROR_10105 = new AppErroCodigo(10105, "PersistenciaException", "Erro ao fechar a conex�o com o banco de dados.");
    public static final AppErroCodigo ERROR_10106 = new AppErroCodigo(10106, "PersistenciaException", "Erro ao fechar a declaracao com o banco de dados.");
    public static final AppErroCodigo ERROR_10107 = new AppErroCodigo(10107, "PersistenciaException", "Erro ao fechar a declaracao e o resultado com o banco de dados.");

    //SequenciaDAO
    public static final AppErroCodigo ERROR_10201 = new AppErroCodigo(10201, "PersistenciaException", "Erro ao pesquisar c�digo da tabela no banco de dados.");
    public static final AppErroCodigo ERROR_10202 = new AppErroCodigo(10202, "PersistenciaException", "Erro ao incluir o registro no banco de dados.");
    public static final AppErroCodigo ERROR_10203 = new AppErroCodigo(10203, "PersistenciaException", "Erro ao atualizar o novo c�digo no banco de dados.");
    
    //FooDAO
    public static final AppErroCodigo ERROR_10301 = new AppErroCodigo(10301, "PersistenciaException", "Erro ao inserir FOO tabela no banco de dados.");

    /**
     * Construtor para PersistenciaException
     */
    public PersistenciaException() {
        super();
        setErro(ERROR_10000);
    }

    /**
     * Construtor para PersistenciaException
     * @param mensagem String Mensagem de erro.
     */
    public PersistenciaException(String mensagem) {
        super(mensagem);
        setErro(ERROR_10000);
    }

    /**
     * Construtor para PersistenciaException
     * @param appErroCodico AppErroCodigo Codigo do erro.
     */
    public PersistenciaException(AppErroCodigo appErroCodico) {
        setErro(appErroCodico);
    }

    /**
     * Construtor para PersistenciaException
     * @param appErroCodico AppErroCodigo, Codigo do erro.
     * @param ex Exception A exce�ao.
     */
    public PersistenciaException(AppErroCodigo appErroCodico, Exception ex) {
        super(ex);
        setErro(appErroCodico);
    }

    /**
     * Construtor para PersistenciaException
     * @param appErroCodico AppErroCodigo, Codigo do erro.
     * @param mensagem String Mensagem do erro.
     */
    public PersistenciaException(AppErroCodigo appErroCodico, String mensagem) {
        super(mensagem);
        setErro(appErroCodico);
    }
}

