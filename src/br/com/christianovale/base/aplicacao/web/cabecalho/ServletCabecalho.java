package br.com.christianovale.base.aplicacao.web.cabecalho;

import br.com.christianovale.base.aplicacao.web.AppBaseServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCabecalho
 */
public class ServletCabecalho extends AppBaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletCabecalho() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

        if (acao.equals("profissional")) {
            this.abrirPaginaPesquisaProfissional(request, response);
        }else if (acao.equals("horarios")) {
            this.abrirPaginaCadastroHorarios(request, response);
        }else if (acao.equals("disciplina")) {
            this.abrirPaginaCadastroDisciplina(request, response);
        }else if (acao.equals("gerarGrade")) {
            this.abrirPaginaGerarGrade(request, response);
        }
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void abrirPaginaPesquisaProfissional(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.enviarPagina(request, response, "profissional/pesquisarProfissional.jsp");
	}
	
	
	private void abrirPaginaCadastroHorarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.enviarPagina(request, response, "horarios/cadastroHorario.jsp");
	}
	
	private void abrirPaginaCadastroDisciplina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.enviarPagina(request, response, "disciplina/cadastroDisciplina.jsp");
	}
	
	private void abrirPaginaGerarGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.enviarPagina(request, response, "grade/gerarGrade.jsp");
	}

}
