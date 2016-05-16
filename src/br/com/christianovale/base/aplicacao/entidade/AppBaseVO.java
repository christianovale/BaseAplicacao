package br.com.christianovale.base.aplicacao.entidade;

import java.util.Date;

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
 * Esta classe reprenta um Value Object ancestral com propriedades 
 * que devem ser comuns às demais entidades do sistema.
 */
public class AppBaseVO {
	
	private Date dataCadastro;
	private int codigoUsuarioResponsavel;
	
	public int getCodigoUsuarioResponsavel() {
		return codigoUsuarioResponsavel;
	}

	public void setCodigoUsuarioResponsavel(int codigoUsuarioResponsavel) {
		this.codigoUsuarioResponsavel = codigoUsuarioResponsavel;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public AppBaseVO() {
	}

}
