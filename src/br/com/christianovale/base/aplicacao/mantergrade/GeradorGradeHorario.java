package br.com.christianovale.base.aplicacao.mantergrade;

import java.util.List;

import br.com.christianovale.base.aplicacao.entidade.PeriodosTrabalho;
import br.com.christianovale.base.aplicacao.entidade.Profissional;
import br.com.christianovale.base.aplicacao.entidade.ProfissionalHorario;

public class GeradorGradeHorario {
	
	public GeradorGradeHorario() {
		
	}
	
	public void gerarGradeHorario(int quantidadeFolhas, 
								  List<PeriodosTrabalho> periodoTrabalho, 
								  List<Profissional> listaProfessores){
		
		ProfissionalHorario[][][] gradeHorarioGerada = new ProfissionalHorario[quantidadeFolhas]
		                                                                      [quantidadeColunas()]
		                                                                      [quantidadeLinhas()];
		
	}
	
	/**
	 * Retorna a quantidade de colunas da matriz
	 * @return
	 */
	public int quantidadeColunas(){
		//TODO implementar metodo pra contar a qtde de dias da semana
		
		return 0;
	}
	
	/**
	 * Retorna a quantidade de linhas da matriz
	 * @return
	 */
	public int quantidadeLinhas(){
		//TODO implementar metodo pra contar a qtde de periodos de cada dia da semana
		return 0;
	}

}
