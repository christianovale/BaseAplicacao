<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import = "java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: SISGRADE - Cadastro de Disciplinas :..</title>
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
			
			
			<font id="ftNomeDisciplina" style="position: absolute; top: 50px; left: 13px;">Nome da Discilina</font>
			<input name="nomeDisciplina" type="text" id="nomeDisciplina" onBlur="verificaCaracteresEspeciais(this.value, this.id)" tabindex="1" size="60" maxlength="80" style="width:435px; position: absolute; top: 63px; left: 12px;" value="">
			
			<font id="ftCargaHoraria" style="position: absolute; top: 85px; left: 13px;">Carga Horaria (horas)</font>
			<input name="cargaHoraria" type="text" id="cargaHoraria" tabindex="4" size="10" maxlength="50" style="position: absolute; top: 98px; left: 13px; width:210px;" value="">
				
			<font id="ftVincularProfessor" style="position: absolute; top: 120px; left: 13px;">Vincular Professor</font>
			<select name="todosMotoristas" size="6" id="todosmotoristas" tabindex="9" style="position: absolute; top: 133px; left: 12px; width: 350px;">
				<option value="0">Prof Fulano</option>
				<option value="1">Prof Beotrano</option>
				<option value="2">Prof La Padite</option>
				<option value="3">Prof Tarantino</option>
			</select>
			
			<select name="motoristasVinculador" size="6" id="motoristasVinculador" tabindex="9" style="position: absolute; top: 133px; left: 412px; width: 350px;">
				
			</select>
			
			<img name="imgVincularMotorista" id="imgVincularMotorista" tabindex="10" src="imagem/botao/ultima.gif" style="position: absolute; top: 155px; left: 380px; cursor:hand" onClick="vincularMotorista()">
            <img name="imgDesvincularMotorista" id="imgDesvincularMotorista" src="imagem/botao/primeiraDesabilitada.gif" style="position: absolute; top: 185px; left: 380px;">


			<input name="adicionarDisciplina" type="image" id="adicionarDisciplina" onClick="adicionarDisciplina()" style="position:absolute; bottom:10px; top: 220px; left:18px;" src="imagem/botao/adicionar.gif" tabindex="46">
			
			<table id="tblDisciplina" align="center" width="55%" style="position:absolute; top:250px; left:240px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "20%"><span style="cursor:hand;"><u>Disciplina</u></span></td>
			            <td width = "20%"><span style="cursor:hand;"><u>Carga horaria</u></span></td>
			            <td width = "55%"><span style="cursor:hand;"><u>Professor(es)</u></span></td>
			            <td width = "5%"><span style="cursor:hand;"><u>Remover</u></span></td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>Fisica</td>
            			<td>20</td>
            			<td>Prof Fulano</td>
            			<td><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>Matematica</td>
            			<td>20</td>
            			<td>Prof La Padite</td>
            			<td><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>Ingles</td>
            			<td>20</td>
            			<td>Prof Beotrano</td>
            			<td><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		
				</table>
				
		</form>

	</div>


</body>
</html>