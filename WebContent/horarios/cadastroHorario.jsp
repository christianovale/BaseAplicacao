<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import = "java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: SISGRADE - Cadastro de Horários :..</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<meta name="resource-type" content="document" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta name="revisit-after" content="1" />
	<meta name="classification" content="Internet" />
	<meta name="description" content="BID Café" />
	<meta name="keywords" content="bid, cafe, itrade, scopo, bid cafe, café, bid café" />
	<meta name="robots" content="ALL" />
	<meta name="rating" content="General" />
	<meta name="author" content="iTrade" />
	<meta name="language" content="pt-br" />
	<meta name="doc-class" content="Completed" />
	<meta name="doc-rights" content="Public" />
</head>


<style type="text/css">@import url("css/principal.css");</style>
<script language="javascript" src="script/geral.js"></script>
<script language="javascript" src="script/tarefa.js"></script>

<body>
	<div id="principal">
		<form name="formConteudo" method="post" action="servlettarefa">
			<input type="hidden" name="acao" id="acao">
			
			<strong><font id="ftDiaSemana" style="position: absolute; top: 50px; left: 13px;">Dia da Semana</font></strong>
			
			<input name="segunda" type="checkbox" id="segunda" tabindex="1" style="position: absolute; top: 85px; left: 13px;" >
			<font id="ftSegunda" style="position: absolute; top: 85px; left: 33px;">Segunda</font>
			
			<input name="terca" type="checkbox" id="terca" tabindex="1" style="position: absolute; top: 85px; left: 103px;" >
			<font id="ftTerca" style="position: absolute; top: 85px; left: 123px;">Terça</font>
			
			<input name="quarta" type="checkbox" id="quarta" tabindex="1" style="position: absolute; top: 85px; left: 193px;" >
			<font id="ftQuarta" style="position: absolute; top: 85px; left: 213px;">Quarta</font>
			
			<input name="quinta" type="checkbox" id="quinta" tabindex="1" style="position: absolute; top: 85px; left: 283px;" >
			<font id="ftQuinta" style="position: absolute; top: 85px; left: 303px;">Quinta</font>
			
			<input name="sexta" type="checkbox" id="sexta" tabindex="1" style="position: absolute; top: 85px; left: 373px;" >
			<font id="ftSexta" style="position: absolute; top: 85px; left: 393px;">Sexta</font>
			
			<input name="sabado" type="checkbox" id="sabado" tabindex="1" style="position: absolute; top: 85px; left: 463px;" >
			<font id="ftSabado" style="position: absolute; top: 85px; left: 483px;">Sabado</font>
			
			<strong><font id="ftHoraInicial" style="position: absolute; top: 155px; left: 13px;">Hora Inicial</font></strong>
			<div id="idHoraInicial">
				<select name="horaInicial" id="horaInicial" tabindex="13" style="position: absolute; top: 185px; left: 13px; width: 50px;">
					<option value="0">01</option>
					<option value="0">02</option>
					<option value="0">03</option>
					<option value="0">04</option>
					<option value="0">05</option>
				</select>
			</div>
			<strong><font id="ftHHInicial" style="position: absolute; top: 185px; left: 70px;">:</font></strong>
			<div id="idHoraInicial">
				<select name="minutoInicial" id="minutoInicial" tabindex="13" style="position: absolute; top: 185px; left: 80px; width: 50px;">
					<option value="0">10</option>
					<option value="0">20</option>
					<option value="0">30</option>
					<option value="0">40</option>
					<option value="0">50</option>
				</select>
			</div>
			
			<strong><font id="ftHoraFinal" style="position: absolute; top: 155px; left: 200px;">Hora Final</font></strong>
			<div id="idHoraFinal">
				<select name="horaFinal" id="horaFinal" tabindex="13" style="position: absolute; top: 185px; left: 200px; width: 50px;">
					<option value="0">01</option>
					<option value="0">02</option>
					<option value="0">03</option>
					<option value="0">04</option>
					<option value="0">05</option>
				</select>
			</div>
			<strong><font id="ftHHFinal" style="position: absolute; top: 185px; left: 257px;">:</font></strong>
			<div id="idHoraFinal">
				<select name="minutoFinal" id="minutoFinal" tabindex="13" style="position: absolute; top: 185px; left: 267px; width: 50px;">
					<option value="0">10</option>
					<option value="0">20</option>
					<option value="0">30</option>
					<option value="0">40</option>
					<option value="0">50</option>
				</select>
			</div>

			<input name="adicionarHorario" type="image" id="adicionarHorario" onClick="adicionarHorario()" style="position:absolute; bottom:10px; top: 185px; left:400px;" src="imagem/botao/adicionar.gif" tabindex="46">
			
			<table id="tblHorario" align="center" width="55%" style="position:absolute; top:41px; left:540px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "17%"><span style="cursor:hand;"><u>Segunda</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Terça</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Quarta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Quinta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Sexta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Sabado</u></span></td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>07:00 a 07:40<img src="imagem/botao/remover.gif"></td>
            			<td>07:00 a 07:40<img src="imagem/botao/remover.gif"></td>
            			<td>07:00 a 07:40<img src="imagem/botao/remover.gif"></td>
            			<td>07:00 a 07:40<img src="imagem/botao/remover.gif"></td>
            			<td>07:00 a 07:40<img src="imagem/botao/remover.gif"></td>
            			<td>07:00 a 07:40<img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>07:40 a 08:20<img src="imagem/botao/remover.gif"></td>
            			<td>07:40 a 08:20<img src="imagem/botao/remover.gif"></td>
            			<td>07:40 a 08:20<img src="imagem/botao/remover.gif"></td>
            			<td>07:40 a 08:20<img src="imagem/botao/remover.gif"></td>
            			<td>07:40 a 08:20<img src="imagem/botao/remover.gif"></td>
            			<td>07:40 a 08:20<img src="imagem/botao/remover.gif"></td> 
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>08:20 a 09:00<img src="imagem/botao/remover.gif"></td>
            			<td>08:20 a 09:00<img src="imagem/botao/remover.gif"></td>
            			<td>08:20 a 09:00<img src="imagem/botao/remover.gif"></td>
            			<td>08:20 a 09:00<img src="imagem/botao/remover.gif"></td>
            			<td>08:20 a 09:00<img src="imagem/botao/remover.gif"></td>
            			<td>08:20 a 09:00<img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>09:00 a 09:40<img src="imagem/botao/remover.gif"></td>
            			<td>09:00 a 09:40<img src="imagem/botao/remover.gif"></td>
            			<td>09:00 a 09:40<img src="imagem/botao/remover.gif"></td>
            			<td>09:00 a 09:40<img src="imagem/botao/remover.gif"></td>
            			<td>09:00 a 09:40<img src="imagem/botao/remover.gif"></td>
            			<td>09:00 a 09:40<img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>09:40 a 10:20<img src="imagem/botao/remover.gif"></td>
            			<td>09:40 a 10:20<img src="imagem/botao/remover.gif"></td>
            			<td>09:40 a 10:20<img src="imagem/botao/remover.gif"></td>
            			<td>09:40 a 10:20<img src="imagem/botao/remover.gif"></td>
            			<td>09:40 a 10:20<img src="imagem/botao/remover.gif"></td>
            			<td>09:40 a 10:20<img src="imagem/botao/remover.gif"></td> 
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>10:20 a 11:00<img src="imagem/botao/remover.gif"></td>
            			<td>10:20 a 11:00<img src="imagem/botao/remover.gif"></td>
            			<td>10:20 a 11:00<img src="imagem/botao/remover.gif"></td>
            			<td>10:20 a 11:00<img src="imagem/botao/remover.gif"></td>
            			<td>10:20 a 11:00<img src="imagem/botao/remover.gif"></td>
            			<td>10:20 a 11:00<img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>11:00 a 11:40<img src="imagem/botao/remover.gif"></td>
            			<td>11:00 a 11:40<img src="imagem/botao/remover.gif"></td>
            			<td>11:00 a 11:40<img src="imagem/botao/remover.gif"></td>
            			<td>11:00 a 11:40<img src="imagem/botao/remover.gif"></td>
            			<td>11:00 a 11:40<img src="imagem/botao/remover.gif"></td>
            			<td>11:00 a 11:40<img src="imagem/botao/remover.gif"></td>
            		</tr>
				</table>
				
		</form>

	</div>


</body>
</html>