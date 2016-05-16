package br.com.christianovale.base.aplicacao.businessobject;

import br.com.christianovale.base.aplicacao.controle.ControladorException;
import br.com.christianovale.base.aplicacao.entidade.Foo;
import br.com.christianovale.base.aplicacao.persistencia.PersistenciaException;

public class FooBO extends AppBaseBO {
	
	/**
	  * *********************************************
	  * ---     E X E M P L O    F O O            ---
	  * *********************************************
	  * Business Object de exemplo da BaseAplicação.
	  ***********************************************
	  *
	  *
	 * @param foo
	 * @throws PersistenciaException
	 * @throws ControladorException
	 * @throws RegraNegocioException 
	 */
	public void verificarDataNascimentoFoo(Foo foo) throws PersistenciaException, ControladorException, RegraNegocioException{
		
		System.out.println("Entrou no BO");
		
		if(foo.getNascimento() == null){
			throw new RegraNegocioException(RegraNegocioException.ERROR_20001);
		}
	}

}
