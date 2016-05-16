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
 * Mensagem para o usuário com apenas 1 Botão de Ação.
 */
public class Mensagem1Botao extends Mensagem {

    private String servlet1;
    private String acao1;
    private String botao1;

    public Mensagem1Botao() {
    }

    public void formatarMensagem(HttpServletRequest request) {
        request.setAttribute("tipo", this.getTipo());
        request.setAttribute("texto", this.getTexto());
        request.setAttribute("servlet1", this.getServlet1());
        request.setAttribute("acao1", this.getAcao1());
        request.setAttribute("botao1", this.getBotao1());
    }

    public String getAcao1() {
        return acao1;
    }

    public String getBotao1() {
        return botao1;
    }

    public String getServlet1() {
        return servlet1;
    }

    public void setServlet1(String servlet1) {
        this.servlet1 = servlet1;
    }

    public void setBotao1(String botao1) {
        this.botao1 = botao1;
    }

    public void setAcao1(String acao1) {
        this.acao1 = acao1;
    }

}

