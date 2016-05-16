package br.com.christianovale.base.aplicacao.persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

import br.com.christianovale.base.aplicacao.util.Recurso;

public class PoolConexao {

    private static PoolConexao poolConexao;

    /**
     * Contrutor para a classe PoolConexao.
     */
    public PoolConexao() {
    }

    /**
     * Singleton que retorna a instancia ativa da classe PoolConexao
     */
    @SuppressWarnings("static-access")
	public static PoolConexao getInstancia() throws PersistenciaException {
        if (poolConexao == null) {
            poolConexao = new PoolConexao();
            poolConexao.criarPoolConexao();
        }
        return poolConexao;
    }

    /**
     * Cria o pool de conexao.
     */
    private static void criarPoolConexao() throws PersistenciaException {
        try {
            Class.forName(Recurso.DRIVER_SGDB);
            ObjectPool connectionPool = new GenericObjectPool(null);
            ConnectionFactory connectionFactory = new  DriverManagerConnectionFactory(Recurso.URL_SGDB, Recurso.USUARIO_SGDB, Recurso.SENHA_SGDB);
            new PoolableConnectionFactory(connectionFactory, connectionPool, null, null, false, true);
            Class.forName(Recurso.DRIVER_APACHE);
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver(Recurso.URL_APACHE);
            driver.registerPool(Recurso.SGDB_NOME, connectionPool);
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10101, sqlEx);
        } catch (ClassNotFoundException cnfEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10101, cnfEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000, ex);
        }
    }

    /**
     * Obtem a conexao com o banco de dados.
     * @return Connection
     * @throws PersistenciaException
     */
    public Connection getConexao() throws PersistenciaException {
        Connection conexao = null;
        try {
            if (Recurso.NUMERO_CONEXAO == 0) {
                Recurso.NUMERO_CONEXAO = 1;
                conexao = DriverManager.getConnection(Recurso.URL_APACHE + Recurso.SGDB_NOME);
                conexao.setAutoCommit(false);
            }
            else {
                throw new PersistenciaException(PersistenciaException.ERROR_10100);
            }
            return conexao;
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10103,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }

    /**
     * Cancela a conexa com o banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @throws PersistenciaException
     */
    public void cancelarConexao(Connection conexao) throws
            PersistenciaException {
        try {
            if(conexao != null){
                if (!conexao.isClosed()) {
                    System.out.println("Conexao cancelada.");
                    conexao.rollback();
                    conexao.close();
                }
            }
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10104,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }

    /**
     * Fechar a conexao com o banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @throws PersistenciaException
     */
    public void fecharConexao(Connection conexao) throws PersistenciaException {
        try {
            if (!conexao.isClosed()) {
                conexao.commit();
                conexao.close();
                Recurso.NUMERO_CONEXAO = 0;
            }
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10105,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }

    /**
     * Fechar a conexao com o banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @param declaracao Statement A declaracao com o banco de dados.
     * @throws PersistenciaException
     */
    public void fecharDeclaracao(Statement declaracao) throws
            PersistenciaException {
        try {
            if (declaracao != null) {
                declaracao.close();
            }
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10106,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }

    /**
     * Fechar a conexao com o banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @param declaracao Statement A declaracao com o banco de dados.
     * @throws PersistenciaException
     */
    public void fecharDeclaracao(PreparedStatement declaracao) throws
            PersistenciaException {
        try {
            declaracao.close();
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10106,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }

    /**
     * Fechar a declaracao e o resultado com o banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @param declaracao Statement A declaracaom com o banco de dados.
     * @param resultado ResultSet O resultado do banco de dados.
     * @throws PersistenciaException
     */
    public void fecharDeclaracaoResultado(Statement declaracao,
                                          ResultSet resultado) throws
            PersistenciaException {
        try {
            resultado.close();
            declaracao.close();
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10107,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }

    /**
     * Fechar a declaracao e o resultado com o banco de dados.
     * @param conexao Connection A conexao com o banco de dados.
     * @param declaracao Statement A declaracaom com o banco de dados.
     * @param resultado ResultSet O resultado do banco de dados.
     * @throws PersistenciaException
     */
    public void fecharDeclaracaoResultado(PreparedStatement declaracao,ResultSet resultado) throws
            PersistenciaException {
        try {
            resultado.close();
            declaracao.close();
        } catch (SQLException sqlEx) {
            throw new PersistenciaException(PersistenciaException.ERROR_10107,sqlEx);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000,ex);
        }
    }
}
