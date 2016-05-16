package br.com.christianovale.base.aplicacao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author christiano vale
 * @version 1.0.3
 * 
 * <p>Description: Christiano Vale - Base Aplicação</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: Christiano Vale Sistemas</p>
 * 
 * Descreve uma classe para manipulação de Datas. 
 */
public class DateUtil {
	
	public final static String ERRO_PARSE_DATE = "Não foi possivel converter a Data. Formato Invalido.";
   
	/**
	 * Transforma um Data no formato java.sql.Date ------> formato java.util.Date
	 * @param d, a data no formato java.sql.Date
	 * @return
	 */
    public static java.util.Date deSqlParaUtil(java.sql.Date d){
        return new java.util.Date(d.getTime());
    }
   
    /**
     * Transforma um Data no formato java.util.Date ------> formato java.sql.Date
     * @param d, a data no formato java.util.Date
     * @return
     */
    public static java.sql.Date deUtilParaSql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }
   
    /**
     * Transforma um Data no formato String (dd/MM/yyyy)------> formato java.util.Date
     * @param d, a data no formato String.
     * @return
     * @throws ParseException
     */
    public static java.util.Date deStringParaUtil(String d) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(d);
    }
    
    /**
     * Transforma um Data no formato java.util.Date------> String (dd/MM/yyyy) 
     * @param d, a data no formato java.util.Date
     * @return
     */
    public static String deUtilParaString(java.util.Date d){
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	return sdf.format(d);
    }
    
    /**
     * Metodo que incrementa dias a uma data.
     * @param d, a data no formato String.
     * @param dias, a quantidade de dias a acrescentar. Caso seja negativo, subtrai a quantidade de dias.
     * @return
     * @throws ParseException
     */
    private static String incrementarData(String d, int dias) throws ParseException {
        java.util.Date data = deStringParaUtil(d);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, dias);

        data = calendar.getTime();

        return deUtilParaString(data);
    }
    
    /**
     * Método para comparar as datas e retornar o numero de dias de diferença entre elas.
     * @param primeiraData String
     * @param segundaData String
     * @return int
     * @throws ParseException
     */
    public static int calcularDiferencaEntreDatas(String primeiraData, String segundaData) throws ParseException {
        java.util.Date data1 = deStringParaUtil(primeiraData);
        java.util.Date data2 = deStringParaUtil(segundaData);

        GregorianCalendar startTime = new GregorianCalendar();
        GregorianCalendar endTime = new GregorianCalendar();
        GregorianCalendar curTime = new GregorianCalendar();
        GregorianCalendar baseTime = new GregorianCalendar();

        startTime.setTime(data1);
        endTime.setTime(data2);

        int dif_multiplier = 1;

        // Verifica a ordem de inicio das datas
        if (data1.compareTo(data2) < 0) {
            baseTime.setTime(data2);
            curTime.setTime(data1);
            dif_multiplier = 1;
        }
        else {
            baseTime.setTime(data1);
            curTime.setTime(data2);
            dif_multiplier = -1;
        }

        int result_years = 0;
        int result_months = 0;
        int result_days = 0;

        // Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando
        // no total de dias. Ja leva em consideracao ano bissesto
        while (curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR) ||
               curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)) {
            int max_day = curTime.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
            result_months += max_day;
            curTime.add(GregorianCalendar.MONTH, 1);
        }

        // Marca que é um saldo negativo ou positivo
        result_months = result_months * dif_multiplier;

        // Retirna a diferenca de dias do total dos meses
        result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));

        return result_years + result_months + result_days;
    }
    
    /**
     * Metodo que calcula a idade, em dias, a partir de uma data inicial.
     * @param data, a data inicial.
     * @return, a quantiodade de dias entre a data passada e o dia de hoje.
     * @throws ParseException
     */
    public static int calculaIdade(String data) throws ParseException{
    	java.util.Date d = deStringParaUtil(data);
        Calendar dataDeNascimento = new GregorianCalendar();
        dataDeNascimento.setTime(d);
        
        // Cria um objeto calendar com a data atual
        Calendar hoje = Calendar.getInstance();
        
        // Obtém a idade baseado no ano
        int idade = hoje.get(Calendar.YEAR) - dataDeNascimento.get(Calendar.YEAR);
        
        dataDeNascimento.add(Calendar.YEAR, idade);
        
        //se a data de hoje é antes da data de Nascimento, então diminui 1(um)
        if (hoje.before(dataDeNascimento)) {
        	idade--;
        }
        return idade;
    }


    
 /*   public static void main(String[] args) {
		String s = "25/10/1980";
		String s1= "10/10/2008";
		try {
			System.out.println(s);
			//System.out.println(s1);
			System.out.println(calculaIdade(s));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
