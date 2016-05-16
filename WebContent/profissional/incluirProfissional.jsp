<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import = "java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>..: Incluir Contato Profissional :..</title>
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
<script language="javascript" src="script/pagina.js"></script>
<script language="javascript" src="script/contato.js"></script>
<!-- script type="text/javascript" language="javascript" src="script/calendar1.js"></script -->

<body onLoad="AlternarAbas('aba_dados', 'div_dados')">
	
	<div id="principal">
		<div id="abas" style="background-color:#FFFFFF;">
			<div id="aba_dados" class="abas" onClick="AlternarAbas('aba_dados', 'div_dados')">Dados principais</div>
			<div id="aba_adicionais" class="abas" style="left:121px;" onClick="AlternarAbas('aba_adicionais', 'div_adicionais')">Inf. Acadêmicas</div>
			<div id="aba_adicionais2" class="abas" style="left:242px;" onClick="AlternarAbas('aba_adicionais2', 'div_adicionais2')">Exp. Profissional</div>
			<div id="aba_adicionais3" class="abas" style="left:363px;" onClick="AlternarAbas('aba_adicionais3', 'div_adicionais3')">Disp. Horário</div>
			<div id="espacoRestante" style="height:20px; width:100%; position:absolute; left:242px; border-bottom:1px solid #336633;"></div>
		</div>
		<div id="conteudo">
		<form name="formConteudo" method="post" action="servletcontatopf">
		<input type="hidden" name="acao" id="acao">
		<input type="hidden" name="listaContatoInterno" id="listaContatoInterno">
		<input type="hidden" name="listaBanco" id="listaBanco">
		<input type="hidden" name="codigoContatoInterno" id="codigoContatoInterno">
		<input type="hidden" name="codigoBanco" id="codigoBanco">
		
			<div id="bordaDireita" style="position:absolute; right:0px; width:1px; border-right:1px solid #336633; top: 21px; height:573px;"></div>
			<div id="bordaInferior" style="position:absolute; bottom:0px; width:100%; border-bottom:1px solid #336633; height:1px;"></div>
			<div id="bordaEsquerda" style="position:absolute; left:0px; width:1px; border-left:1px solid #336633; height:100%;"></div>

			<div id="div_dados">
				<div style="width:98.8%; position: absolute; top: 21px; left:1px; background-color: #B3D095; height:13px; padding: 2px 2px 2px 5px;"><font class="data">..: Incluir Profissinal</font></div>
				
				<font id="ftNome" style="position: absolute; top: 50px; left: 13px;">Nome</font>
				<input name="nome" type="text" id="nome" onBlur="verificaCaracteresEspeciais(this.value, this.id)" tabindex="1" size="60" maxlength="80" style="width:435px; position: absolute; top: 63px; left: 12px;" value="">
				
				<font id="ftCnpj" style="position: absolute; top: 50px; left: 466px;">CPF</font>
				<input name="cnpj" type="text" id="cnpj" tabindex="2" size="16" maxlength="14" style="position: absolute; top: 63px; left: 465px; width:90px;" onKeyUp="mascaraCPF(this.value, 'formConteudo.cnpj')" value="">
				
				<font id="ftInscricaoConselho" style="position: absolute; top: 50px; left: 578px;">Inscrição no Conselho</font>
				<input name="inscricaoConselho" type="text" id="inscricaoConselho" tabindex="3" size="30" maxlength="40" style="position: absolute; top: 63px; left: 577px; width:223px;" value="">

				<font id="ftEmail" style="position: absolute; top: 85px; left: 13px;">E-mail</font>
				<input name="email" type="text" id="email" tabindex="4" size="38" maxlength="50" style="position: absolute; top: 98px; left: 13px; width:210px;" value="">
				
				<font id="ftTelefone" style="position: absolute; top: 85px; left: 246px;">Telefone</font>
				<input name="telefone" type="text" id="telefone" tabindex="5" size="15" maxlength="15" style="position: absolute; top: 98px; left: 245px; width:90px;" value="">
				
				<font id="ftFax" style="position: absolute; top: 85px; left: 359px;">Fax</font>
				<input name="fax" type="text" id="fax" tabindex="6" size="15" maxlength="15" style="position: absolute; top: 98px; left: 358px; width: 90px;" value="">
				
				<font id="ftCelular" style="position: absolute; top: 85px; left: 466px;">Celular</font>
				<input name="celular" type="text" id="celular" tabindex="7" size="15" maxlength="15" style="position: absolute; top: 98px; left: 465px; width:90px;" value="">
				
				<font id="ftInscricaoEstadual" style="position: absolute; top: 85px; left: 577px;">Inscrição Estadual</font>
				<input name="inscricaoEstadual" type="text" id="inscricaoEstadual" tabindex="8" size="16" maxlength="18" style="position: absolute; top: 98px; left: 576px; width:120px;" value="">
				
				<font id="ftEndereco" style="position: absolute; top: 120px; left: 13px;">Endereço</font>				
				<input name="endereco" type="text" id="endereco" tabindex="9" size="60" maxlength="100" style="position: absolute; width:435px; top: 133px; left: 13px;" value="">
				
				<font id="ftBairro" style="position: absolute; top: 120px; left: 466px;">Bairro</font>				
				<input name="bairro" type="text" id="bairro" tabindex="10" size="38" maxlength="30" style="position: absolute; width: 225px; top: 133px; left: 465px;" value="">
				
				<font id="ftCEP" style="position: absolute; top: 120px; left: 712px;">CEP</font>
				<input name="cep" type="text" id="cep" tabindex="11" size="15" maxlength="9" style="position: absolute; width: 90px; top: 133px; left: 711px;" onKeyUp="mascaraCEP(this.value, 'formConteudo.cep')" value="">

				<font id="ftUF" style="position: absolute; top: 155px; left: 13px;">Estado</font>
				<select name="uf" id="uf" tabindex="12" style="position: absolute; top: 168px; left: 13px;" onChange="filtrarMunicipios('idMunicipioCliente',this.id)">
					
				</select>
				<font id="ftMunicipio" style="position: absolute; top: 155px; left: 171px;">Município</font>
				<div id="idMunicipioCliente">
				<select name="municipio" id="municipio" tabindex="13" style="position: absolute; top: 168px; left: 170px; width: 285px;">
					<option value="0">(Selecione o municipio)</option>
				</select>
				</div>
				<font id="ftSite" style="position: absolute; top: 155px; left: 466px;">Site</font>				
				<input name="site" id="site" tabindex="13" type="text" size="30" maxlength="50" style="position: absolute; top: 168px; left: 465px; width:225px;" value="">
				
				<font id="ftAbreviacao" style="position: absolute; top: 155px; left: 712px;">Iniciais</font>
				<input name="abreviacao" type="text" id="abreviacao" tabindex="14" size="15" maxlength="15" style="position: absolute; top: 168px; left: 711px; width: 90px;" value="">

				<div class="separacao" style="top: 250px;"></div>
				
				<strong><font id="ftInfoBancaria" style="position: absolute; top: 250px; left: 12px; ">Informações Bancárias</font></strong>

				<font id="ftNomeBanco" style="position: absolute; top: 270px; left: 13px; ">Banco</font>
				<input name="nomeBanco" type="text" id="nomeBanco" tabindex="1" maxlength="30" style="width:160px; position: absolute; top: 283px; left: 13px;" value="">
				<font id="ftAgencia" style="position: absolute; top: 270px; left: 190px; ">Agência</font>
				<input name="agencia" type="text" id="agencia" maxlength="10" tabindex="2" style="width: 70px; position: absolute; top: 283px; left: 190px;" value="">
				<font id="ftConta" style="position: absolute; top: 270px; left: 277px; ">Conta</font>
				<input name="conta" type="text" id="conta" maxlength="12" tabindex="3" style="width: 80px; position: absolute; top: 283px; left: 276px;" value="">
				<img src="imagem/botao/limpar.gif" name="limparContato" id="limparContato" style="position:absolute; top:283px; left:375px; cursor:hand" onClick="limparContatoInterno()">
				
				<font id="ftUfBanco" style="position: absolute; top: 303px; left: 13px;">Estado</font>
				<select name="ufBanco" id="ufBanco" tabindex="4" style="position: absolute; top: 316px; left: 12px;" onChange="filtrarMunicipios('idMunicipioBanco',this.id)">
					
				</select>
				<font id="ftMunicipioBanco" style="position: absolute; top: 303px; left: 171px;">Município</font>
				<div id="idMunicipioBanco">
					<select name="municipioBanco" id="municipioBanco" tabindex="5" style="position: absolute; top: 316px; left: 170px; width: 260px;">
						<option value="0">(Selecione o municipio)</option>
					</select>
				</div>
				
				<div id="idBanco" class="especial" style="left:450px; top:250px; height:65px; width:43%;">
					<table id="tabelabanco" width="95%" class="tabelaLateral">
					</table>				
				</div>
				
				<img name="imgExcluirBanco" id="imgExcluirBanco" src="imagem/botao/excluir_pq.gif" style="position:absolute; top: 315px; left: 700px; cursor:hand" onClick="excluirBanco()">
				<div id="idBotoesBanco">
					<img name="imgIncluirBanco" id="imgIncluirBanco" src="imagem/botao/incluir_pq.gif" style="position:absolute; top: 316px; left: 460px; cursor:hand" onClick="incluirBanco()" >
					<img name="imgAlterarBanco" id="imgAlterarBanco" src="imagem/botao/alterar_pqDesabilitado.gif" style="position:absolute; top: 313px; left: 580px; cursor:hand" >				
				</div>
				

			</div>
			<!-- ------------------------------------------------------------------------------------ -->
			<div id="div_adicionais" style="display: none">
				<div style="width:98.8%; position: absolute; top: 21px; left:1px; background-color: #B3D095; height:13px; padding: 2px 2px 2px 5px;"><font class="data">..: Informações Curriculares</font></div>
				
				<strong><font id="ftInstrucao" style="position: absolute; top: 50px; left: 13px;">Grau de instrução</font></strong>
				<div id="idInstrucao">
					<select name="instrucao" id="instrucao" tabindex="13" style="position: absolute; top: 63px; left: 12px; width: 285px;">
						<option value="0">(Selecione)</option>
						<option value="1">Ensino fundamental completo</option>
						<option value="1">Ensino fundamental incompleto</option>
						<option value="1">Ensino medio completo</option>
						<option value="1">Ensino medio incompleto</option>
						<option value="1">Mestrado/Doutorado completo</option>
						<option value="1">Mestrado/Doutorado incompleto</option>
						<option value="1">Pos Doutorado completo</option>
						<option value="1">Pos Doutorado incompleto</option>
						<option value="1">Pos Graduação completo</option>
						<option value="1">Pos Graduação incompleto</option>
						<option value="1">Superior completo</option>
						<option value="1">Superior incompleto</option>
						<option value="1">Tecnico completo</option>
						<option value="1">Tecnico incompleto</option>
					</select>
				</div>
				
				<strong><font id="ftNomeCurso" style="position: absolute; top: 95px; left: 13px;">Nome do curso</font></strong>
				<div id="idINomeCurso">
					<select name="nomeCurso" id="nomeCurso" tabindex="13" style="position: absolute; top: 108px; left: 12px; width: 285px;">
						<option value="0">(Selecione)</option>
						
					</select>
				</div>
				
				<strong><font id="ftOutroCurso" style="position: absolute; top: 140px; left: 13px;">Outro curso</font></strong>
				<input name="outroCurso" type="text" id="outroCurso" tabindex="1" maxlength="30" style="width:160px; position: absolute; top: 153px; left: 13px;" value="">
			
				<strong><font id="ftInstituicao" style="position: absolute; top: 185px; left: 13px;">Instituicao de Ensino</font></strong>
				<input name="instituicao" type="text" id="instituicao" tabindex="1" maxlength="30" style="width:160px; position: absolute; top: 198px; left: 13px;" value="">
				
				<strong><font id="ftAnoInicio" style="position: absolute; top: 230px; left: 13px;">Ano de inicio</font></strong>
				<div id="idAnoInicio">
					<select name="anoInicio" id="anoInicio" tabindex="13" style="position: absolute; top: 230px; left: 92px; width: 85px;">
						<option value="0">(Selecione)</option>
						
					</select>
				</div>
				
				<strong><font id="ftAnoInicio" style="position: absolute; top: 230px; left: 190px;">Ano de término</font></strong>
				<div id="idAnoInicio">
					<select name="anoInicio" id="anoInicio" tabindex="13" style="position: absolute; top: 230px; left: 282px; width: 85px;">
						<option value="0">(Selecione)</option>
						
					</select>
				</div>
				
				<input name="adicionarCurso" type="image" id="adicionarCurso" onClick="adicionarCurso()" style="position:absolute; bottom:10px; top: 260px; left:200px;" src="imagem/botao/adicionar.gif" tabindex="46">
				
				<table id="tblCurso" align="center" width="65%" style="position:absolute; top:41px; left:400px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "22%"><span onClick="ordenar('Nome')" style="cursor:hand;"><u>Grau de instrução</u></span></td>
			            <td width = "16%"><span onClick="ordenar('Usuario')" style="cursor:hand;"><u>Nome do curso </u></span></td>
			            <td width = "20%"><span onClick="ordenar('Ativo')" style="cursor:hand;"><u>Instituição</u></span></td>
			            <td width = "10%"><span onClick="ordenar('Ativo')" style="cursor:hand;"><u>Período</u></span></td>
			            <td width = "10%">remover</td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td> <a href="servletusuario?acao=alterar&codigo=1">Ensino Medio Completo</a> </td>
            			<td>Ensino Medio</td>
            			<td align="center">E.E. Professor Fulano de tal</td>
            			<td align="center">1988 - 1998</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaPar" onMouseOver="this.className='linhaTabelaImpar'" onMouseOut="this.className='linhaTabelaPar'">
            			<td> <a href="servletusuario?acao=alterar&codigo=1">Superior Completo</a> </td>
            			<td>Fisica</td>
            			<td align="center">UFMG</td>
            			<td align="center">1999 - 2003</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td> <a href="servletusuario?acao=alterar&codigo=1">Pos Graduacao Completo</a> </td>
            			<td>Fisica</td>
            			<td align="center">UFMG</td>
            			<td align="center">2004 - 2005</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
		            
				</table>

				<div class="separacao" style="top: 295px;"></div>
				
				<strong><font id="ftOutroCurso" style="position: absolute; top: 320px; left: 13px;">Outro Curso</font></strong>
				<input name="outroCurso" type="text" id="outroCurso" tabindex="1" maxlength="30" style="width:160px; position: absolute; top: 333px; left: 13px;" value="">
				<input name="adicionarOutroCurso" type="image" id="adicionarOutroCurso" onClick="adicionarOutroCurso()" style="position:absolute; bottom:10px; top: 333px; left:200px;" src="imagem/botao/adicionar.gif" tabindex="46">
				
				<table id="tblOutroCurso" align="center" width="65%" style="position:absolute; top:320px; left:400px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "22%"><span onClick="ordenar('Nome')" style="cursor:hand;"><u>Nome do Curso</u></span></td>
			            <td width = "5%">remover</td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>Curso de alguma coisa</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		<tr class="linhaTabelaPar" onMouseOver="this.className='linhaTabelaImpar'" onMouseOut="this.className='linhaTabelaPar'">
            			<td>Curso de outra coisa</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
            	</table>

			</div>
			
			<!-- ------------------------------------------------------------------------------------ -->
			
			<div id="div_adicionais2" style="display: none">
				<div style="width:98.8%; position: absolute; top: 21px; left:1px; background-color: #B3D095; height:13px; padding: 2px 2px 2px 5px;"><font class="data">..: Histórico Profissional</font></div>
				
				<font id="ftEmpresa" style="position: absolute; top: 50px; left: 13px;">Empresa</font>
				<input name="empresa" type="text" id="empresa" onBlur="verificaCaracteresEspeciais(this.value, this.id)" tabindex="1" size="60" maxlength="80" style="width:335px; position: absolute; top: 63px; left: 12px;" value="">
				
				<font id="ftResponsavelEmpresa" style="position: absolute; top: 85px; left: 13px;">Responsavel pela Empresa</font>
				<input name="responsavelEmpresa" type="text" id=""responsavelEmpresa"" tabindex="4" size="38" maxlength="50" style="position: absolute; top: 98px; left: 13px; width:210px;" value="">
				
				<font id="ftTelefoneContato" style="position: absolute; top: 120px; left: 13px;">Telefone para contato</font>				
				<input name="telefoneContato" type="text" id="telefoneContato" tabindex="9" size="60" maxlength="100" style="position: absolute; width:235px; top: 133px; left: 13px;" value="">
				
				<font id="ftCargo" style="position: absolute; top: 155px; left: 13px;">Cargo</font>				
				<input name="cargo" type="text" id="cargo" tabindex="9" size="60" maxlength="100" style="position: absolute; width:235px; top: 168px; left: 13px;" value="">
				
				<font id="ftDataAdmissao" style="position: absolute; top: 190px; left: 13px;">Data de Admissao (mm/aaaa)</font>				
				<input name="dataAdmissao" type="text" id="dataAdmissao" tabindex="9" size="60" maxlength="100" style="position: absolute; width:85px; top: 203px; left: 13px;" value="">
				
				<font id="ftDataDemissao" style="position: absolute; top: 190px; left: 193px;">Data de Demissao (mm/aaaa)</font>				
				<input name="dataDemissao" type="text" id="dataDemissao" tabindex="9" size="60" maxlength="100" style="position: absolute; width:85px; top: 203px; left: 193px;" value="">
				
				<font id="ftTipoContratacao" style="position: absolute; top: 235px; left: 13px;">Tipo de Contratacao</font>
				<input type="radio" name="tpContratacao" id="contratacaoClt" value="CLT" style="position: absolute; top: 248px; left: 13px;"/>
				<font id="ftClt" style="position: absolute; top: 248px; left: 33px;">CLT</font>
				<input type="radio" name="tpContratacao" id="contratacaoConsultor" value="consultor" style="position: absolute; top: 248px; left: 113px;"/>
				<font id="ftConsultor" style="position: absolute; top: 248px; left: 133px;">Consultor</font>
				<input type="radio" name="tpContratacao" id="contratacaoEstagio" value="estagio" style="position: absolute; top: 248px; left: 213px;"/>
				<font id="ftEstagio" style="position: absolute; top: 248px; left: 233px;">Estagio</font>
				<input name="adicionarExpProfissional" type="image" id="adicionarExpProfissional" onClick="adicionarExpProfissional()" style="position:absolute; bottom:10px; top: 280px; left:100px;" src="imagem/botao/adicionar.gif" tabindex="46">
				
				<table id="tblExpProfissional" align="center" width="65%" style="position:absolute; top:41px; left:400px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "22%"><span onClick="ordenar('Nome')" style="cursor:hand;"><u>Empresa</u></span></td>
			            <td width = "16%"><span onClick="ordenar('Usuario')" style="cursor:hand;"><u>Cargo</u></span></td>
			            <td width = "20%"><span onClick="ordenar('Ativo')" style="cursor:hand;"><u>Periodo</u></span></td>
			            <td width = "10%"><span onClick="ordenar('Ativo')" style="cursor:hand;"><u>Tipo</u></span></td>
			            <td width = "10%">remover</td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>Faculdade ABCD</td>
            			<td>Professor de fisica</td>
            			<td align="center">mm/aaaa a mm/aaaa</td>
            			<td align="center">CLT</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaPar" onMouseOver="this.className='linhaTabelaImpar'" onMouseOut="this.className='linhaTabelaPar'">
            			<td>Empresa XYZ</td>
            			<td>Consultor de alguma coisa</td>
            			<td align="center">mm/aaaa a mm/aaaa</td>
            			<td align="center">Consultor</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>Empresa XYZ</td>
            			<td>Consultor de alguma coisa</td>
            			<td align="center">mm/aaaa a mm/aaaa</td>
            			<td align="center">Estagio</td>
            			<td align="center"><img src="imagem/botao/remover.gif"></td>
            		</tr>
		            
				</table>
			</div>
			
			<!-- ------------------------------------------------------------------------------------ -->
			
			<div id="div_adicionais3" style="display: none">
				<div style="width:98.8%; position: absolute; top: 21px; left:1px; background-color: #B3D095; height:13px; padding: 2px 2px 2px 5px;"><font class="data">..: Disponibilidade de Horários</font></div>
				
				<strong><font id="ftHorario" style="position: absolute; top: 50px; left: 200px;">Marque os horarios que tem disponível</font></strong>
				
				<table id="tblHorario" align="center" width="65%" style="position:absolute; top:80px; left:200px; padding: 0px 3px 0px 3px;">
				    <tr>
			            <td width = "17%"><span style="cursor:hand;"><u>Segunda</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Terça</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Quarta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Quinta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Sexta</u></span></td>
			            <td width = "17%"><span style="cursor:hand;"><u>Sabado</u></span></td>
		            </tr>
		            
		            <tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>07:00 a 07:40<input name="segunda" type="checkbox" id="segunda" tabindex="1"></td>
            			<td>07:00 a 07:40<input name="terca" type="checkbox" id="terca" tabindex="1"></td>
            			<td>07:00 a 07:40<input name="quarta" type="checkbox" id="quarta" tabindex="1"></td>
            			<td>07:00 a 07:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>07:00 a 07:40<input name="sexta" type="checkbox" id="sexta" tabindex="1"></td>
            			<td>07:00 a 07:40<input name="sabado" type="checkbox" id="sabado" tabindex="1"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>07:40 a 08:20<input name="segunda" type="checkbox" id="segunda" tabindex="1"></td>
            			<td>07:40 a 08:20<input name="terca" type="checkbox" id="terca" tabindex="1"></td>
            			<td>07:40 a 08:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>07:40 a 08:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>07:40 a 08:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>07:40 a 08:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td> 
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>08:20 a 09:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>08:20 a 09:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>08:20 a 09:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>08:20 a 09:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>08:20 a 09:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>08:20 a 09:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>09:00 a 09:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:00 a 09:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:00 a 09:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:00 a 09:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:00 a 09:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:00 a 09:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>09:40 a 10:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:40 a 10:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:40 a 10:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:40 a 10:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:40 a 10:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>09:40 a 10:20<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td> 
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>10:20 a 11:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>10:20 a 11:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>10:20 a 11:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>10:20 a 11:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>10:20 a 11:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>10:20 a 11:00<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            		</tr>
            		
            		<tr class="linhaTabelaImpar" onMouseOver="this.className='linhaTabelaPar'" onMouseOut="this.className='linhaTabelaImpar'">
            			<td>11:00 a 11:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>11:00 a 11:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>11:00 a 11:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>11:00 a 11:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>11:00 a 11:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            			<td>11:00 a 11:40<input name="quinta" type="checkbox" id="quinta" tabindex="1"></td>
            		</tr>
				</table>
			<!-- ------------------------------------------------------------------------------------ -->
			
		</form>
				<input name="cancelar" type="image" id="cancelar" src="imagem/botao/cancelar.gif" style="position:absolute; bottom:10px; left:500px;" onClick="cancelarContato()" tabindex="47">
				
				<input name="salvar" type="image" id="salvar" onClick="incluirClientePF()" style="position:absolute; bottom:10px; left:200px;" src="imagem/botao/salvar.gif" tabindex="46">
				
		</div>
	</div>


</body>
</html>
