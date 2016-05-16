package br.com.christianovale.base.aplicacao.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.christianovale.base.aplicacao.facade.IFacade;
import br.com.christianovale.base.aplicacao.facadeimpl.ControladorFacade;
import br.com.christianovale.base.aplicacao.web.mensagem.Mensagem;
import br.com.christianovale.base.aplicacao.web.mensagem.Mensagem1Botao;
import br.com.christianovale.base.aplicacao.web.mensagem.Mensagem2Botoes;
import br.com.christianovale.base.aplicacao.web.mensagem.Mensagem3Botoes;


/**
 * @author christiano.vale
 * 
 *  Servlet implementation class for Servlet: AppBaseServlet
 *  
 *	Servlet ancestral para todos os Servlets da aplicação
 */
 @SuppressWarnings("serial")
public class AppBaseServlet extends HttpServlet implements Servlet {
  	
	 	 /**
	     * Envia o usuário para uma determinada pagina.
	     * @param request HttpServletRequest A solicitacao da pagina web.
	     * @param response HttpServletResponse A resposta da pagina web.
	     * @param pagina String A pagina para onde será direcionada a solicitação.
	     * @throws ServletException
	     * @throws IOException
	     */
	    public void enviarPagina(HttpServletRequest request, HttpServletResponse response, String pagina) throws ServletException, IOException {
	        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/" + pagina);
	        rd.forward(request, response);
	    }
	    
	    /**
	     * Metodo para saber qual pagina será enviando a mensagem.
	     * Envia uma mensagem para o cliente na tela. Erro, Alerta ou Confirmação.
	     * @param request HttpServletRequest
	     * @param response HttpServletResponse
	     * @param msg Mensagem, tipo da mensagem
	     * @throws ServletException
	     * @throws IOException
	     */
	    public void enviarMensagem(HttpServletRequest request, HttpServletResponse response, Mensagem msg) throws ServletException, IOException {
	    	
	    	String pagina = null;
	        msg.formatarMensagem(request);
	        if (msg instanceof Mensagem1Botao) {
	            pagina = Mensagem.JSP_MSG_1_BOTAO;
	        }
	        else if (msg instanceof Mensagem2Botoes) {
	            pagina = Mensagem.JSP_MSG_2_BOTOES;
	        }
	        else if (msg instanceof Mensagem3Botoes) {
	            pagina = Mensagem.JSP_MSG_3_BOTOES;
	        }

	        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(pagina);
	        rd.forward(request, response);
	    }
	    
	    /**
	     * Retorna a instancia do Serviço do Façade.
	     * @return
	     */
	   public IFacade getFacade(){
		   return ControladorFacade.getInstance().getServicoFacade();
	   }
  	  	    
}