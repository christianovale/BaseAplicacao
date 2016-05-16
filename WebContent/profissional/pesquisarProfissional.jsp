<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import = "java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: SISGRADE - Pesquisar Contato :..</title>
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
<script language="JavaScript" src="script/pagina.js"></script>
<script language="JavaScript" src="script/contato.js"></script>
<body onLoad="javascript:document.formConteudo.nomePesquisado.focus()">

	<div id="principal">
		<form name="formConteudo" method="post" action="servletProfissional">
		<input name="acao" type="hidden" id="acao">

			<div id="bordaDireita" style="position:absolute; right:0px; width:1px; border-right:1px solid #336633; height:99.8%;"></div>
			<div id="bordaSuperior" style="position:absolute; top:0px; width:99.9%; border-top:1px solid #336633; height:1px;"></div>
			<div id="bordaInferior" style="position:absolute; bottom:0px; width:99.9%; border-bottom:1px solid #336633; height:1px;"></div>
			<div id="bordaEsquerda" style="position:absolute; left:0px; width:1px; border-left:1px solid #336633; height:99.9%;"></div>

			<div style="width:98.8%; background-color: #B3D095; height:13px; position:absolute; top:1px; left:1px; padding: 2px 2px 2px 5px;"><strong><font class="data">..: Pesquisar Profissional</font></strong></div>
			<font id="ftNome" style="position:absolute; top:30px; left:13px; ">Nome:</font>
			<input name="nomePesquisado" type="text" id="nomePesquisado" size="40" maxlength="60" tabindex="1" style="position:absolute; top:43px; left:12px;  width: 285px;" onKeyDown="if(event.keyCode == 13) event.returnValue = false;" value="">

			<input name="pesquisar" type="image" src="imagem/botao/pesquisar.gif" onClick="pesquisarContato()" tabindex="2" style="position:absolute; top: 38px; left:325px;">

			<font id="ftUF" style="position: absolute; top: 65px; left: 13px;">Estado</font>
			<select name="uf" id="uf" style="position: absolute; top: 78px; left: 13px;" onChange="filtrarMunicipios('idMunicipioPesquisaContato',this.id)">
			
			</select>
			<font id="ftMunicipio" style="position: absolute; top: 65px; left: 171px;">Município</font>
			<div id="idMunicipioPesquisaContato">
			<select name="municipio" id="municipio" style="position: absolute; top: 78px; left: 170px; width: 275px;">
				<option value="0">(Selecione o municipio)</option>
			</select>
			</div>


		</form>

			<input name="incluirNovo" type="image" id="incluirNovo" style="position:absolute; bottom:10px; left:350px; " src="imagem/botao/incluirNovo.gif" onClick="incluirNovoProfissional()" tabindex="3">

	</div>


</body>
</html>
