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
 * Mensagem para o usuário com 4 Botões de Ação.
 */
public class Mensagem4Botoes extends Mensagem {

    private String servlet1;
    private String servlet2;
    private String servlet3;
    private String servlet4;
    private String acao1;
    private String acao2;
    private String acao3;
    private String acao4;
    private String botao1;
    private String botao2;
    private String botao3;
    private String botao4;

    public Mensagem4Botoes() {
    }

    public void formatarMensagem(HttpServletRequest request) {
        request.setAttribute("tipo", this.getTipo());
        request.setAttribute("texto", this.getTexto());
        request.setAttribute("servlet1", this.getServlet1());
        request.setAttribute("acao1", this.getAcao1());
        request.setAttribute("botao1", this.getBotao1());
        request.setAttribute("servlet2", this.getServlet2());
        request.setAttribute("acao2", this.getAcao2());
        request.setAttribute("botao2", this.getBotao2());
        request.setAttribute("servlet3", this.getServlet3());
        request.setAttribute("acao3", this.getAcao3());
        request.setAttribute("botao3", this.getBotao3());
        request.setAttribute("servlet4", this.getServlet4());
        request.setAttribute("acao4", this.getAcao4());
        request.setAttribute("botao4", this.getBotao4());
    }

    public String getAcao1() {
        return acao1;
    }

    public String getAcao2() {
        return acao2;
    }

    public String getAcao3() {
        return acao3;
    }

    public String getAcao4() {
        return acao4;
    }

    public String getBotao1() {
        return botao1;
    }

    public String getBotao2() {
        return botao2;
    }

    public String getBotao3() {
        return botao3;
    }

    public String getBotao4() {
        return botao4;
    }

    public String getServlet1() {
        return servlet1;
    }

    public String getServlet2() {
        return servlet2;
    }

    public String getServlet3() {
        return servlet3;
    }

    public String getServlet4() {
        return servlet4;
    }

    public void setAcao1(String acao1) {
        this.acao1 = acao1;
    }

    public void setAcao2(String acao2) {
        this.acao2 = acao2;
    }

    public void setAcao3(String acao3) {
        this.acao3 = acao3;
    }

    public void setAcao4(String acao4) {
        this.acao4 = acao4;
    }

    public void setBotao1(String botao1) {
        this.botao1 = botao1;
    }

    public void setBotao2(String botao2) {
        this.botao2 = botao2;
    }

    public void setServlet1(String servlet1) {
        this.servlet1 = servlet1;
    }

    public void setBotao4(String botao4) {
        this.botao4 = botao4;
    }

    public void setBotao3(String botao3) {
        this.botao3 = botao3;
    }

    public void setServlet2(String servlet2) {
        this.servlet2 = servlet2;
    }

    public void setServlet3(String servlet3) {
        this.servlet3 = servlet3;
    }

    public void setServlet4(String servlet4) {
        this.servlet4 = servlet4;
    }

}
