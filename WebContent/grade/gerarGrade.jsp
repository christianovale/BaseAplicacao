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

			<input name="simularGrade" type="image" id="simularGrade" onClick="simularGrade()" style="position:absolute; bottom:10px; top: 35px; left:20px;" src="imagem/botao/gerarLista.gif" tabindex="46">
			
			<input name="imprimir" type="image" id="imprimir" onClick="imprimir()" style="position:absolute; bottom:10px; top: 33px; left:180px;" src="imagem/botao/imprimir.gif" tabindex="46">
			
			<table id="tblHorario" align="center" width="65%" style="position:absolute; top:90px; left:20px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "17%"><span style="cursor:hand;"><u>Segunda</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Terça</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Quarta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Quinta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Sexta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Sabado</u></span></td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>07:00 a 07:40 <br><br>Matematica</td>
            			<td>07:00 a 07:40 <br><br>Matematica</td>
            			<td>07:00 a 07:40 <br><br>Ingles</td>
            			<td>07:00 a 07:40 <br><br>Ingles</td>
            			<td>07:00 a 07:40 <br><br>Fisica</td>
            			<td>07:00 a 07:40 <br><br>Fisica</td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>07:40 a 08:20 <br><br>Historia</td>
            			<td>07:40 a 08:20 <br><br>Historia</td>
            			<td>07:40 a 08:20 <br><br>Biologia</td>
            			<td>07:40 a 08:20 <br><br>Matematica</td>
            			<td>07:40 a 08:20 <br><br>Matematica</td>
            			<td>07:40 a 08:20 <br><br>Biologia</td> 
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>08:20 a 09:00 <br><br>Matematica</td>
            			<td>08:20 a 09:00 <br><br>Matematica</td>
            			<td>08:20 a 09:00 <br><br>Ingles</td>
            			<td>08:20 a 09:00 <br><br>Ingles</td>
            			<td>08:20 a 09:00 <br><br>Historia</td>
            			<td>08:20 a 09:00 <br><br>Historia</td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>09:00 a 09:40<br><br> Fisica</td>
            			<td>09:00 a 09:40 <br><br>Fisica</td>
            			<td>09:00 a 09:40<br><br> Portugues</td>
            			<td>09:00 a 09:40 <br><br>Portugues</td>
            			<td>09:00 a 09:40 <br><br>Historia</td>
            			<td>09:00 a 09:40 <br><br>Historia></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>09:40 a 10:20 <br><br>Estatistica</td>
            			<td>09:40 a 10:20 <br><br>Estatistica</td>
            			<td>09:40 a 10:20 <br><br>Portugues</td>
            			<td>09:40 a 10:20<br><br> Portugues</td>
            			<td>09:40 a 10:20 <br><br>Ingles</td>
            			<td>09:40 a 10:20 <br><br>Ingles</td> 
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>10:20 a 11:00 <br><br>Estatistica</td>
            			<td>10:20 a 11:00 <br><br>Estatistica></td>
            			<td>10:20 a 11:00 <br><br>Portugues</td>
            			<td>10:20 a 11:00 <br><br>Portugues</td>
            			<td>10:20 a 11:00 <br><br>Fisica</td>
            			<td>10:20 a 11:00 <br><br>Fisica</td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>11:00 a 11:40 <br><br>Biologia</td>
            			<td>11:00 a 11:40 <br><br>Biologia</td>
            			<td>11:00 a 11:40</td>
            			<td>11:00 a 11:40</td>
            			<td>11:00 a 11:40</td>
            			<td>11:00 a 11:40</td>
            		</tr>
				</table>
				
		</form>

	</div>


</body>
</html>