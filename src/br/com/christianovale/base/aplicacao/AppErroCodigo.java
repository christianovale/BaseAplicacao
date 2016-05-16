package br.com.christianovale.base.aplicacao;

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
public class AppErroCodigo {


    private int codigo;
    private String prefixo;
    private String descricao;

    /**
     * Construtor para a classe AppErroCodigo.
     * @param codigo int, O codigo do erro.
     * @param prefixo String, O prefixo do erro.
     * @param descicao String, A descricao do erro.
     */
    public AppErroCodigo(int codigo, String prefixo, String descricao) {
        this.codigo = codigo;
        this.prefixo = prefixo;
        this.descricao = descricao;
    }

    /**
     * Obtem a mensagem de erro.
     * @return String, Retorna a string com a mensagem de erro.
     */
    public String getMensagem() {
    	StringBuffer str = new StringBuffer();
    	str.append(this.prefixo).append(" ").append(this.codigo).append(":<BR>").append(this.descricao);
    	return str.toString();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
