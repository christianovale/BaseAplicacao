package br.com.christianovale.base.aplicacao.controle;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.AppErroCodigo;

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
@SuppressWarnings("serial")
public class ControladorException extends AppBaseException {

    public static final AppErroCodigo ERROR_20000 = new AppErroCodigo(20000, "ControladorException", "Erro Inesperado.");
    public static final AppErroCodigo ERROR_20001 = new AppErroCodigo(20001, "ControladorException", "Erro Ao mandar pra puta que pariu.");


    /**
     * Construtor para ControladorException
     */
    public ControladorException() {
        super();
        setErro(ERROR_20000);
    }

    /**
     * Construtor para ControladorException
     * @param mensagem String Mensagem de erro.
     */
    public ControladorException(String mensagem) {
        super(mensagem);
        setErro(ERROR_20000);
    }

    /**
     * Construtor para ControladorException
     * @param appErroCodigo AppErroCodigo Codigo do erro.
     */
    public ControladorException(AppErroCodigo appErroCodigo) {
        setErro(appErroCodigo);
    }

    /**
     * Construtor para ControladorException
     * @param appErroCodigo AppErroCodigo Codigo do erro.
     * @param ex Exception A exceçao.
     */
    public ControladorException(AppErroCodigo appErroCodigo, Exception ex) {
        super(ex);
        setErro(appErroCodigo);
    }

    /**
     * Construtor para ControladorException
     * @param appErroCodigo AppErroCodigo Codigo do erro.
     * @param mensagem String Mensagem do erro.
     */
    public ControladorException(AppErroCodigo appErroCodigo, String mensagem) {
        super(mensagem);
        setErro(appErroCodigo);
    }
}