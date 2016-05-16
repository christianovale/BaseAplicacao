<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: BID Caf&eacute; - Principal :..</title>
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

<%
	String tipo = (String) request.getAttribute("tipo");
	String texto = (String) request.getAttribute("texto");
%>


<style type="text/css">@import url("css/principal.css");</style>
<script language="JavaScript" src="script/geral.js"></script>
<script language="JavaScript" src="script/pagina.js"></script>
<body>
	
	<div id="principal">
			<div id="bordaDireita" style="position:absolute; right:0px; width:1px; border-right:1px solid #336633; height:99.9%;"></div>
			<div id="bordaSuperior" style="position:absolute; top:0px; width:100%; border-top:1px solid #336633; height:1px;"></div>
			<div id="bordaInferior" style="position:absolute; bottom:0px; width:100%; border-bottom:1px solid #336633; height:1px;"></div>
			<div id="bordaEsquerda" style="position:absolute; left:0px; width:1px; border-left:1px solid #336633; height:99.9%;"></div>
			<div style="width:99.8%; background-color: #B3D095; height:13px; position:absolute; top:1px; left:1px; padding: 2px 2px 2px 5px;">..: Mensagem</div>

			<div align="center" style="position: absolute; top: 100px; left: 100px; width: 600px; height: 100px;">
				<img src="imagem/mensagem/<%=tipo%>.gif">
				<br><br><br><br><br><br>
				<font align="center"><strong><%=texto%></strong></font>
				<br><br><br><br><br><br>
				<a href="javascript:history.back();"><img src="imagem/botao/voltar.gif" border="0"></a>
			</div>
	</div>

</body>
</html>
