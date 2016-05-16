package br.com.christianovale.base.aplicacao.web.foo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.christianovale.base.aplicacao.AppBaseException;
import br.com.christianovale.base.aplicacao.businessobject.RegraNegocioException;
import br.com.christianovale.base.aplicacao.controle.ControladorException;
import br.com.christianovale.base.aplicacao.facade.IFacade;
import br.com.christianovale.base.aplicacao.modelo.ModeloFoo;
import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;
import br.com.christianovale.base.aplicacao.web.AppBaseServlet;
import br.com.christianovale.base.aplicacao.web.mensagem.Mensagem;
import br.com.christianovale.base.aplicacao.web.mensagem.Mensagem1Botao;
import br.com.christianovale.base.aplicacao.web.mensagem.MensagemWeb;

/**
 * Servlet implementation class for Servlet: ServletFoo
 * 
 * *********************************************
 * ---     E X E M P L O    F O O            ---
 * *********************************************
 * Servlet de exemplo da BaseAplicação.		 ---
 ***********************************************
 *
 * E T A P A S:
 * 
 *	1- Este Servlet recebe a requisição;
 *	2- Atraves do paramento 'acao' o servlet direciona para o devido metodo;
 *	3- O serviço é entregue ao Façade;
 *	4- O Façade delega a chamada para os Business Objects e para o Controlador;
 *	5- Controlador recebe a entidade e a repassa para o DAO;
 *	6- O DAO será responsavel pela persistencia dos dados;
 *
 */
 public class ServletFoo extends AppBaseServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equals("incluirFoo")){
			this.incluirFoo(request, response);
		}else if(acao.equals("pesquisarEndereco")){
			this.pesquisarEndereco(request, response);
		}
	}  	
	

	private void incluirFoo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			ModeloFoo modelo = new ModeloFoo();
			modelo.getDadosPagina(request);
			
			IFacade facade = super.getFacade();
		
			facade.medotoExemploFoo(modelo);
			
			Mensagem1Botao msg = new Mensagem1Botao();
            msg.setTipo(Mensagem.MSG_CONFIRMA);
            msg.setTexto(MensagemWeb.MSG_1001);
            msg.setServlet1("ServletFoo");
            msg.setAcao1("");
            msg.setBotao1(Mensagem.BTN_OK);
            super.enviarMensagem(request, response, msg);
		} catch (PersistenciaException e) {
			e.printStackTrace();
            Mensagem1Botao msg = new Mensagem1Botao();
            msg.setTipo(Mensagem.MSG_ERRO);
            msg.setTexto(e.getMensagem());
            msg.setServlet1("ServletFoo");
            msg.setAcao1("");
            msg.setBotao1(Mensagem.BTN_OK);
            super.enviarMensagem(request, response, msg);
		} catch (ControladorException ex) {
			ex.printStackTrace();
            Mensagem1Botao msg = new Mensagem1Botao();
            msg.setTipo(Mensagem.MSG_ERRO);
            msg.setTexto(ex.getMensagem());
            msg.setServlet1("ServletFoo");
            msg.setAcao1("");
            msg.setBotao1(Mensagem.BTN_OK);
            this.enviarMensagem(request, response, msg);
		} catch (RegraNegocioException ex) {
			ex.printStackTrace();
            Mensagem1Botao msg = new Mensagem1Botao();
            msg.setTipo(Mensagem.MSG_ERRO);
            msg.setTexto(ex.getMensagem());
            msg.setServlet1("ServletFoo");
            msg.setAcao1("");
            msg.setBotao1(Mensagem.BTN_OK);
            this.enviarMensagem(request, response, msg);
		} catch (AppBaseException ex) {
			ex.printStackTrace();
            Mensagem1Botao msg = new Mensagem1Botao();
            msg.setTipo(Mensagem.MSG_ERRO);
            msg.setTexto(ex.getMensagem());
            msg.setServlet1("ServletFoo");
            msg.setAcao1("");
            msg.setBotao1(Mensagem.BTN_OK);
            this.enviarMensagem(request, response, msg);
		} catch (Exception ex) {
			ex.printStackTrace();
            Mensagem1Botao msg = new Mensagem1Botao();
            msg.setTipo(Mensagem.MSG_ERRO);
            msg.setTexto(MensagemWeb.MSG_0000);
            msg.setServlet1("ServletFoo");
            msg.setAcao1("");
            msg.setBotao1(Mensagem.BTN_OK);
            this.enviarMensagem(request, response, msg);
		}
	}
	
	private void pesquisarEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
        StringBuffer xmlSaida = new StringBuffer();

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/xml");

        xmlSaida.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
        xmlSaida.append("<itens>\n");
        
        for(int i=0 ; i<=10 ; i++){
        	xmlSaida.append("<item codCliente=\"" + i + "\">>\n");
            xmlSaida.append("<nome>Endereço " + i + "</nome>\n");
            xmlSaida.append("</item>\n");
        }
        
        xmlSaida.append("</itens>");
        out.print(xmlSaida.toString());
        System.out.print(xmlSaida.toString());
        out.flush();
        out.close();
	}

}