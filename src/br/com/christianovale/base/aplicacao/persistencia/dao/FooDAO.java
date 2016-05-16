package br.com.christianovale.base.aplicacao.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.christianovale.base.aplicacao.entidade.Foo;
import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;
import br.com.christianovale.base.aplicacao.persistencia.PoolConexao;
import br.com.christianovale.base.aplicacao.util.DateUtil;

public class FooDAO extends AppBaseDAO{

	/**
	 * *********************************************
	 * ---     E X E M P L O    F O O            ---
	 * *********************************************
	 * DAO de exemplo da BaseAplicação.		     ---
	 ***********************************************
	 *
	 *
	 *
	 * Insere os dados de um Objeto Foo em uma tabela chamada 'foo' no banco de dados.
	 * 
	 * @param conexao, a conexão com o banco de dados.
	 * @param foo, o Objeto a ser gravado.
	 * @return, o codigo do objeto Gravado.
	 * @throws PersistenciaException
	 */
	public int incluirFoo(Connection conexao, Foo foo) throws PersistenciaException {
        int codigoFoo = 0;
        PreparedStatement declaracao = null;
        
        try {
        	StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO Foo (codigo, nome, endereco, idade, nascimento");
            sql.append("VALUES (?,?,?,?,?)");

            declaracao = conexao.prepareStatement(sql.toString());
            codigoFoo = obterNovoCodigo(conexao, "foo");
            
            int i = 1;
            declaracao.setInt(i++, codigoFoo);
            declaracao.setString(i++, foo.getNome());
            declaracao.setString(i++, foo.getEndereco());
            declaracao.setInt(i++, foo.getIdade());
            declaracao.setDate(i++, DateUtil.deUtilParaSql(foo.getNascimento()));
            
            declaracao.executeUpdate();
        } catch (PersistenciaException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10301, ex);
        } catch (Exception ex) {
            throw new PersistenciaException(PersistenciaException.ERROR_10000, ex);
        } finally {
            PoolConexao.getInstancia().fecharDeclaracao(declaracao);
        }
        return codigoFoo;
    }
}
