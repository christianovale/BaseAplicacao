package br.com.christianovale.base.aplicacao.businessobject;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.AppErroCodigo;

@SuppressWarnings("serial")
public class RegraNegocioException extends AppBaseException{

	    public static final AppErroCodigo ERROR_20000 = new AppErroCodigo(20000, "RegraDeNegocio", "Erro Inesperado.");
	    
	    public static final AppErroCodigo ERROR_20001 = new AppErroCodigo(20001, "RegraDeNegocio", "A data de nascimento não deve ser vazia.");


	    /**
	     * Construtor para RegraNegocioException
	     */
	    public RegraNegocioException() {
	        super();
	        setErro(ERROR_20000);
	    }

	    /**
	     * Construtor para RegraNegocioException
	     * @param mensagem String Mensagem de erro.
	     */
	    public RegraNegocioException(String mensagem) {
	        super(mensagem);
	        setErro(ERROR_20000);
	    }

	    /**
	     * Construtor para RegraNegocioException
	     * @param appErroCodigo AppErroCodigo Codigo do erro.
	     */
	    public RegraNegocioException(AppErroCodigo appErroCodigo) {
	        setErro(appErroCodigo);
	    }

	    /**
	     * Construtor para RegraNegocioException
	     * @param appErroCodigo AppErroCodigo Codigo do erro.
	     * @param ex Exception A exceçao.
	     */
	    public RegraNegocioException(AppErroCodigo appErroCodigo, Exception ex) {
	        super(ex);
	        setErro(appErroCodigo);
	    }

	    /**
	     * Construtor para RegraNegocioException
	     * @param appErroCodigo AppErroCodigo Codigo do erro.
	     * @param mensagem String Mensagem do erro.
	     */
	    public RegraNegocioException(AppErroCodigo appErroCodigo, String mensagem) {
	        super(mensagem);
	        setErro(appErroCodigo);
	    }
	}
