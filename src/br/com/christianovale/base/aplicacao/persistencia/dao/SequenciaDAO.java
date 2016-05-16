package br.com.christianovale.base.aplicacao.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;
import br.com.christianovale.base.aplicacao.persistencia.PoolConexao;


/**
 * @author christiano vale
 * @version 1.0
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 */
public class SequenciaDAO extends AppBaseDAO{

    private static SequenciaDAO seqDAO;

    private SequenciaDAO() {
    }

    /**
     * Singleton que retorna a instancia ativa da classe SequenciaDAO
     */
    public static SequenciaDAO obterInstancia() {
        if (seqDAO == null) {
            seqDAO = new SequenciaDAO();
        }
        return seqDAO;
    }

    /**
     * Metodo para obter o proximo codigo da tabela no banco de dados.
     * @param tabela String O nome da tabela no banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @return int O novo codigo da tabela no banco de dados.
     * @throws PersistenciaException Erro caso haja algum problema ao obter a tabela no banco de dados.
     */
    public int obterProximoCodigo(Connection conexao, String tabela) throws PersistenciaException {
        int proximoCodigo = 0;
        try {
            proximoCodigo = this.pesquisarNovoCodigo(conexao, tabela);
            if (proximoCodigo == 0) {
                this.incluirPrimeiroCodigo(conexao, tabela);
                return 1;
            }
            else {
                proximoCodigo++;
                this.atualizarCodigo(conexao, tabela, proximoCodigo);
            }
        } catch (PersistenciaException pEx) {
            throw pEx;
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000, ex);
        }
        return proximoCodigo;
    }

    /**
     * Pesquisa o novo codigo da tabela de sequencia.
     * @param tabela String A tabela
     * @param conexao Connection A conexao com o banco de dado.s
     * @return int O codigo.
     * @throws PersistenciaException Caso ocorra algum erro ao pesquisar o novo codigo.
     */
    private int pesquisarNovoCodigo(Connection conexao, String tabela) throws PersistenciaException {
        int proximoCodigo = 0;
        PreparedStatement declaracao = null;
        ResultSet resultado = null;
        try {
            String sql = "SELECT codigo FROM Sequencia WHERE tabela = ?";
            declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, tabela);
            resultado = declaracao.executeQuery();
            while (resultado.next()) {
                proximoCodigo = resultado.getInt("codigo");
            }
            return proximoCodigo;
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10201, sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000, ex);
        } finally {
            PoolConexao.getInstancia().fecharDeclaracaoResultado(declaracao, resultado);
        }
    }

    /**
     * Inclui o primeiro codigo na tabela de sequencia.
     * @param tabela String A tabela.
     * @param conexao Connection A conexao com banco de dados.
     * @throws PersistenciaException
     */
    private void incluirPrimeiroCodigo(Connection conexao, String tabela) throws PersistenciaException {
        PreparedStatement declaracao = null;
        try {
            String sql = "INSERT INTO Sequencia (tabela, codigo) VALUES (?, 1)";
            declaracao = conexao.prepareStatement(sql);
            declaracao.setString(1, tabela);
            declaracao.executeUpdate();
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10202, sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000, ex);
        } finally {
            PoolConexao.getInstancia().fecharDeclaracao(declaracao);
        }
    }

    /**
     * Metodo para atualizar o codigo de sequencia de uma tabela.
     * @param tabela String A tabela
     * @param novoCodigo int O novo codigo.
     * @param conexao Connection A conexao com o banco de dados.
     * @throws PersistenciaException Caso ocorra algum erro ao atualizar o codigo de sequencia.
     */
    private void atualizarCodigo(Connection conexao, String tabela, int novoCodigo) throws PersistenciaException {
        PreparedStatement declaracao = null;
        String sql = "UPDATE Sequencia SET codigo = ? WHERE tabela = ? ";
        try {
            declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, novoCodigo);
            declaracao.setString(2, tabela);
            declaracao.executeUpdate();
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10203, sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000, ex);
        } finally {
            PoolConexao.getInstancia().fecharDeclaracao(declaracao);
        }
    }
}

