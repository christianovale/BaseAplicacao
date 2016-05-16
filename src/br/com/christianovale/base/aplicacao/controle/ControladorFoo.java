package br.com.christianovale.base.aplicacao.controle;

import java.sql.Connection;

import br.com.christianovale.base.aplicacao.entidade.Foo;
import br.com.christianovale.base.aplicacao.persistencia.DaoFactory;
import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;
import br.com.christianovale.base.aplicacao.persistencia.dao.FooDAO;

public class ControladorFoo extends AppBaseControlador {
	
	/**
	  * *********************************************
	  * ---     E X E M P L O    F O O            ---
	  * *********************************************
	  * Controlador de exemplo da BaseAplicação.  ---
	  ***********************************************
	 * 
	 * 
	 * A conexão aberta deve ser utilizada em todas as transações do metodo, pois, caso haja
	 * algum erro, toda a operação deve ser desfeita.
	 *  
	 * @param modelo, o modelo de entidade a ser gravado.
	 * @return, o codigo (chave primaria) do objeto inserido.
	 * @throws PersistenciaException
	 * @throws ControladorException
	 */
	public int incluirFoo(Foo foo) throws PersistenciaException, ControladorException {
        Connection conexao = null;
        int codigoFoo = 0;
        try {
            conexao = getConexao();
            FooDAO dao = (FooDAO) DaoFactory.getInstancia().getDao(FooDAO.class);
            
            codigoFoo = dao.incluirFoo(conexao, foo);
        } catch (PersistenciaException ex) {
            cancelarConexao(conexao);
            throw ex;
        } catch (Exception ex) {
            cancelarConexao(conexao);
            throw new ControladorException(ControladorException.ERROR_20000, ex);
        } finally {
            fecharConexao(conexao);
        }
        return codigoFoo;
    }

}
