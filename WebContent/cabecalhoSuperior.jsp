<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: SISGRADE :..</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<meta name="resource-type" content="document" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta name="revisit-after" content="1" />
	<meta name="classification" content="Internet" />
	<meta name="robots" content="ALL" />
	<meta name="rating" content="General" />
	<meta name="author" content="iTrade" />
	<meta name="language" content="pt-br" />
	<meta name="doc-class" content="Completed" />
	<meta name="doc-rights" content="Public" />
</head>


<style type="text/css">@import url("css/principal.css");</style>
<script type="text/javascript" language="javascript" src="script/geral.js"></script>
<script type="text/javascript" language="javascript" src="script/login.js"></script>

<body onLoad="moveRelogio()">
	<div id="cabecalhoSuperior">
		<form name="formCabecalhoSuperior" method="post" action="servletlogin">
		<div id="logo">
			<img src="imagem/logoBIDCafe.gif">
			<input name="acao" type="hidden" id="acao" value="logoff">
		</div>
		<input name="sair" id="sair" type="image" src="imagem/botao/sair.gif" style="position:absolute; top:2px; right:2px;" onClick="efetuarLogoff()">
		</form>
	</div>
	
	<div id="cabecalhoInferior">
		<form name="formRelogio"> 
			<font name="relogio" id="relogio" style="position:absolute; left:40px; top:7px; color: #AEAEAE; padding:2px 2px 2px 2px; font-family : Verdana, Arial, Helvetica; font-size : 14pt;">00:00:00</font>
		</form> 
		<form name="formCabecalho" method="post" action="servletcabecalho" target="principalFrame">
		<input name="acao" type="hidden" id="acao">
		
		<div id="botaoContato" class="icones">
			<input type="image" src="imagem/menu/contato.gif" alt="Usuários" onClick="selecionarItem('profissional')">
		</div>
		
		<div id="botaoAmostra" class="icones">
			<input type="image" src="imagem/menu/contrato.gif" alt="Contatos" onClick="selecionarItem('horarios')">
		</div>
		
		<div id="botaoTarefa" class="icones">
			<input type="image" src="imagem/menu/tarefa.gif" alt="Amostras" onClick="selecionarItem('disciplina')">
		</div>
		<div id="botaoContrato" class="icones">
			<input type="image" src="imagem/menu/configuracoes.gif" alt="Fechamentos/Contratos" onClick="selecionarItem('gerarGrade')">
		</div><!--
		<div id="botaoTarefa" class="icones">
			<input type="image" src="imagem/menu/tarefa.gif" alt="Tarefas" onClick="selecionarItem('tarefa')">
		</div>
		<div id="botaoComissao" class="icones">
			<input type="image" src="imagem/menu/comissao.gif" alt="Comissões" onClick="selecionarItem('comissao')">
		</div>
		<div id="botaoAnalise" class="icones">
			<input type="image" src="imagem/menu/analise.gif" alt="Análises" onClick="selecionarItem('analise')">
		</div>
		<div id="botaoConfiguracoes" class="icones">
			<input type="image" src="imagem/menu/configuracoes.gif" alt="Configurações" onClick="selecionarItem('configuracoes')">
		</div>-->
		</form>
	</div>



</body>
</html>
