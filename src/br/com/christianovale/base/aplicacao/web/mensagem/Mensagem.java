package br.com.christianovale.base.aplicacao.web.mensagem;

import javax.servlet.http.HttpServletRequest;

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
 * Classe Abstrata que serve como base para as mensagens do sistema
 */
public abstract class Mensagem {

    //Tipo de paginas JSP
    public static final String JSP_MSG_1_BOTAO = "/mensagem/mensagem1Botao.jsp";
    public static final String JSP_MSG_2_BOTOES = "/mensagem/mensagem2Botoes.jsp";
    public static final String JSP_MSG_3_BOTOES = "/mensagem/mensagem3Botoes.jsp";
    public static final String JSP_MSG_VOLTAR = "/mensagem/mensagemVoltar.jsp";

    //Tipo de mensagens
    public static final String MSG_ALERTA = "alerta";
    public static final String MSG_CONFIRMA = "confirma";
    public static final String MSG_ERRO = "erro";

    //Tipo de boteos
    public static final String BTN_VOLTAR = "voltar";
    public static final String BTN_OK = "ok";
    public static final String BTN_INCLUIR_NOVO = "incluirNovo";

    protected String tipo;
    protected String texto;

    public Mensagem() {
    }
    
    /**
     * Este método deve, obrigatoriamente, ser implementado nos descendentes.
     */
    public abstract void formatarMensagem(HttpServletRequest request);

    public String getTexto() {
        return texto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

