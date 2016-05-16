<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: SISGRADE - Index</title>
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
    <style type="text/css">
<!--
.style6 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
}
.style8 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
	color: #FFFFFF;
}
-->
    </style>
</head>
<script language="JavaScript" src="script/geral.js"></script>
<script language="JavaScript" src="script/login.js"></script>
<script language="JavaScript" src="script/pagina.js"></script>
<body onLoad="abrirSistema('usuario')">
<%

	session.setAttribute("pagIndex","pagIndex");
%>

<table width="303" border="0" cellpadding="0" cellspacing="0" bgcolor="#F1F1F1" style="position:absolute; top:5px;">
  <!--DWLayoutTable-->
  <form name="formLogin" method="post" action="servletlogin">
  <tr>
    <td height="23" colspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#699C30">
      <!--DWLayoutTable-->
      <tr>
        <td width="303" height="23" align="center" valign="middle"><span class="style8">Entrar no Sistema SISGRADE </span></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  	<td><input name="acao" type="hidden" id="acao" value="logon"></td>

  </tr>
  <tr>
    <td width="52" height="30" align="right" valign="middle" class="style6">E-mail:</td>
    <td width="221" valign="middle"><input name="usuario" type="text" id="usuario" size="35" maxlength="50" value="aaaaaaaaaaaa"></td>
  </tr>
  <tr>
    <td height="30" align="right" valign="middle" class="style6">Senha:</td>
    <td valign="middle"><input name="senha" type="password" id="senha" size="35" maxlength="20" value="aaaaaaaaaa" onKeyDown="if(event.keyCode == 13) efetuarLogon();"></td>
  </tr>

  </form>
  <tr align="center" valign="middle">
    <td height="30" colspan="2">
	<input type="image" src="imagem/botao/entrar.gif" width="120" height="19" onClick="efetuarLogon()"></td>
  </tr>
  <!--
  <tr valign="middle">
  	<td colspan="2">&nbsp;<span style="color:#FF0000; cursor:hand; 	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 12px;" onClick="esqueciSenha()"><u>Esqueci minha senha</u></span></td>
  </tr>
  -->
</table>
</body>
</html>
