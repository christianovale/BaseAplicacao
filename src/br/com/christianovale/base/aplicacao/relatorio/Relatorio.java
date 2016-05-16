package br.com.christianovale.base.aplicacao.relatorio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

/**
 * @author christiano vale
 * @version 1.0.2
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 * 
 * Descreve uma classe para geração de relatorios JasperReport. 
 */
public class Relatorio {
        /**
         * Construtor para a classe relatorio
         */
        public Relatorio() {
    }

    /**
     * Metodo para abrir a pagina de impressao em Formato PDF.
     * Exibe o relatorio em uma janela Popup chamada "imprimir.jsp"
     * 
     * @param response HttpServletResponse
     * @param array ArrayList a lista com os dados do Relatorio
     * @param parametros HashMap, os parametros do relatorio
     * @param path String, o caminho dos relatorios compilados (.jasper).
     * 		  [String path = getServletContext().getRealPath("/relatorio/grafico") + "/"]
     * @throws IOException
     * @throws RelatorioException
     * 
     * 		Relatorio relatorio = new Relatorio();
     *      relatorio.exibirPaginaImpressao(response, dadosRelatorio, hs, pathJasper);
     */
    public void exibirPaginaImpressao(HttpServletResponse response, ArrayList array, HashMap parametros, String path) throws IOException,
            RelatorioException {
        try {
            JRDataSource jrDataSourse = new JRBeanArrayDataSource(array.toArray());
            JasperPrint impressao = JasperFillManager.fillReport(path, parametros, jrDataSourse);

            byte[] bytes = null;

            bytes = JasperExportManager.exportReportToPdf(impressao);

            response.setContentType("application/pdf");
            response.encodeRedirectURL("imprimir.jsp");
            response.setContentLength(bytes.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();
            ouputStream.close();

        } catch (JRException ex) {
            throw new RelatorioException(RelatorioException.ERROR_31001, ex);
        }catch(Exception ex){
            throw new RelatorioException(RelatorioException.ERROR_30000, ex);
        }
    }

    /**
     * Metodo para salvar a pagina de impressao em Formato PDF
     * 
     * @param array ArrayList a lista com os dados do Relatorio
     * @param parametros HashMap, os parametros do relatorio
     * @param path String, o caminho dos relatorios compilados (.jasper)
     * @param pathDestino String, o caminho de destino onde o relatorio será salvo
     * @param nome String, o nome do Arquivo de destino
     * @throws IOException
     * @throws RelatorioException
     * 
     * 		Relatorio relatorio = new Relatorio();
     *      relatorio.salvarPaginaImpressao(array, parametros, path, pathDestino, nomeContrato.toString());
     */
    public void salvarPaginaImpressao(ArrayList array, HashMap parametros, String path, String pathDestino, String nome) throws IOException,
            RelatorioException {
        try {
            JRDataSource jrDataSourse = new JRBeanArrayDataSource(array.toArray());

            JasperPrint impressao = JasperFillManager.fillReport(path, parametros, jrDataSourse);

            JasperExportManager.exportReportToPdfFile(impressao, pathDestino + "/" + nome);

        } catch (JRException ex) {
            throw new RelatorioException(RelatorioException.ERROR_31002, ex);
        }catch(Exception ex){
            throw new RelatorioException(RelatorioException.ERROR_30000, ex);
        }
    }
}

