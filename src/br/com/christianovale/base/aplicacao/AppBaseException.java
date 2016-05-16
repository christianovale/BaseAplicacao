package br.com.christianovale.base.aplicacao;

/**
 * @author christiano.vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 */
@SuppressWarnings("serial")
public class AppBaseException extends Exception{
	
    public static final AppErroCodigo ERROR_00000 = new AppErroCodigo(00000, "AppBaseException", "Erro Inesperado.");
    public static final AppErroCodigo ERROR_00001 = new AppErroCodigo(00001, "AppBaseException", "Formato de Data Invalido.");
    private Exception excessaoAninhada;
    private AppErroCodigo erro = ERROR_00000;

    /**
     * Construtor para a classe AppBaseException
     */
    public AppBaseException() {

    }

    /**
     * Construtor para AppBaseException
     * @param mensagem String Mensagem de erro.
     */
    public AppBaseException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor para AppBaseException
     * @param ex Exception Exceção do erro.
     */
    public AppBaseException(Exception ex) {
        this.excessaoAninhada = ex;
    }

    /**
     * Construtor para AppBaseException
     * @param mensagem String Mensagem do erro.
     * @param ex Exception Exceção do erro.
     */
    public AppBaseException(String mensagem, Exception ex) {
        super(mensagem);
        this.excessaoAninhada = ex;
    }

    /**
     * Obtem a mensagem completa da excessao e, caso existam, de todas as outras aninhadas
     * @return Retorna uma String com a mensagem
     */
    public String toString() {
        if (excessaoAninhada == null) {
            return getMensagem();
        }
        else {
            return getMensagem() + System.getProperty("line.separator") + excessaoAninhada.toString();
        }
    }

    /**
     * Obtem apenas a mensagem da excessao e, caso existam, de todas as outras aninhadas
     * @return Retorna uma String com a mensagem
     */
    public String getMensagem() {
        if (super.getMessage() == null) {
            return erro.getMensagem();
        }
        else {
            return erro.getMensagem() + " - " + super.getMessage();
        }
    }

    public AppErroCodigo getErro() {
        return erro;
    }

    public Exception getExcessaoAninhada() {
        return excessaoAninhada;
    }

    public void setErro(AppErroCodigo erro) {
        this.erro = erro;
    }

    public void setExcessaoAninhada(Exception excessaoAninhada) {
        this.excessaoAninhada = excessaoAninhada;
    }
}
