package br.com.christianovale.base.aplicacao.relatorio;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.AppErroCodigo;

/**
 * @author christiano vale
 * @version 1.0.2
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 */
@SuppressWarnings("serial")
public class RelatorioException extends AppBaseException {

    public static final AppErroCodigo ERROR_30000 = new AppErroCodigo(30000, "RelatorioException", "Erro Inesperado.");

    public static final AppErroCodigo ERROR_31001 = new AppErroCodigo(31001, "RelatorioException", "Ocorreu Um Erro Ao Tentar Abrir A Pagina De Impressao.");

    public static final AppErroCodigo ERROR_31002 = new AppErroCodigo(31002, "RelatorioException", "Ocorreu Um Erro Ao Tentar Salvar A Pagina De Impressao.");

    /**
     * Construtor para RelatorioException
     */
    public RelatorioException() {
        super();
        setErro(ERROR_30000);
    }

    /**
     * Construtor para RelatorioException
     * @param ec AppErroCodigo Codigo do erro.
     * @param ex Exception A exceçao
     */
    public RelatorioException(AppErroCodigo ec, Exception ex) {
        super(ex);
        setErro(ec);
    }

}

