var XMLHttp;
function criarXmlHttp(){
	try{
		XMLHttp = new XMLHttpRequest();	
	}catch(e1){
		try{
			XMLHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e2){
			try{
				XMLHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e3){
				alert("Problemas criando obejto XMLHttpRequest :"+ e3.description);
			}		
		}
	}
}

//Verifica a validade do dado inserido e pesquisa
function pesquisarContato() {
  if(document.formConteudo.clientePJ.checked == false &&
    document.formConteudo.clientePF.checked == false &&
    document.formConteudo.armazem.checked == false &&
    document.formConteudo.transportadora.checked == false &&
    document.formConteudo.motorista.checked == false) {
      mostrarMensagem("Favor marcar pelo menos um tipo de contato.", document.formConteudo.clientePJ);
	  event.returnValue = false;
  }
  else {
    document.formConteudo.acao.value = "pesquisar";
  }
}

//Abre o cadastro para a inclusão de um novo contato
function incluirNovoProfissional() {
   document.formConteudo.acao.value = "incluirNovo";
   document.formConteudo.submit();
}

//Chama a pagina de relatorio de contatos
function gerarLista() {
   document.formConteudo.acao.value = "gerarLista";
   document.formConteudo.submit();
}

//Avanca para inclusao de um contato, que foi escolhido
function avancarNovoContato() {
   document.formConteudo.acao.value = "avancarNovo";
   document.formConteudo.submit();
}

//Cancela a inclusão e retorna para a página de pesquisa
function cancelarContato() {
  if (confirm("Deseja cancelar este cadastro?")) {
    document.formConteudo.acao.value = "cancelar";
    document.formConteudo.submit();
  }
  else event.returnValue = false;
}

//Inclui um contato interno da empresa (cliente PJ e PF, armazem e transportadora)
function incluirContatoInterno (){
  if (checarDadoContatoInterno()) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idContatoInterno').innerHTML = XMLHttp.responseText;
				limparContatoInterno();
			}
		}
	};
	var contato = new Array();
	if (document.getElementById('nomeContatoInterno').value != '')
		contato[0] = document.getElementById('nomeContatoInterno').value;
	else
		contato[0] = '-1';
	if (document.getElementById('cargo').value != '')
		contato[1] = document.getElementById('cargo').value;
	else
		contato[1] = '-1';
	if (document.getElementById('canalPreferencial').value != '0')
		contato[2] = document.getElementById('canalPreferencial').value;
	else
		contato[2] = '0';
	if (document.getElementById('telefoneContatoInterno').value != '')
		contato[3] = document.getElementById('telefoneContatoInterno').value;
	else
		contato[3] = '-1';
	if (document.getElementById('ramal').value != '')
		contato[4] = document.getElementById('ramal').value;
	else
		contato[4] = '-1';
	if (document.getElementById('celularContatoInterno').value != '')
		contato[5] = document.getElementById('celularContatoInterno').value;
	else
		contato[5] = '-1';
	if (document.getElementById('emailContatoInterno').value != '')
		contato[6] = document.getElementById('emailContatoInterno').value;
	else
		contato[6] = '-1';
	if (document.getElementById('faxContatoInterno').value != '')
		contato[7] = document.getElementById('faxContatoInterno').value;
	else
		contato[7] = '-1';
		
	XMLHttp.open("GET",document.formConteudo.action+"?acao=incluirContatoInterno&contatoInterno="+contato,true);
	XMLHttp.send(null);
  }
  else event.returnValue = false;
}

//Altera um contato interno da empresa (cliente PJ e PF, armazem e transportadora)
function alterarContatoInterno(){
  if (document.formConteudo.nomeContatoInterno.value == "") {
    mostrarMensagem("Informe o nome do contato interno.", document.formConteudo.nomeContatoInterno);
	event.returnValue = false;
  }
  else if ((document.formConteudo.emailContatoInterno.value != "") && (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.formConteudo.emailContatoInterno.value)))) {
      mostrarMensagem("Favor informar um e-mail válido.", document.formConteudo.emailContatoInterno);
   	  event.returnValue = false;
  }
  else {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idContatoInterno').innerHTML = XMLHttp.responseText;
				limparContatoInterno();
			}
		}
	};
	var contato = new Array();
	if (document.getElementById('nomeContatoInterno').value != '')
		contato[0] = document.getElementById('nomeContatoInterno').value;
	else
		contato[0] = '-1';
	if (document.getElementById('cargo').value != '')
		contato[1] = document.getElementById('cargo').value;
	else
		contato[1] = '-1';
	if (document.getElementById('canalPreferencial').value != '0')
		contato[2] = document.getElementById('canalPreferencial').value;
	else
		contato[2] = '0';
	if (document.getElementById('telefoneContatoInterno').value != '')
		contato[3] = document.getElementById('telefoneContatoInterno').value;
	else
		contato[3] = '-1';
	if (document.getElementById('ramal').value != '')
		contato[4] = document.getElementById('ramal').value;
	else
		contato[4] = '-1';
	if (document.getElementById('celularContatoInterno').value != '')
		contato[5] = document.getElementById('celularContatoInterno').value;
	else
		contato[5] = '-1';
	if (document.getElementById('emailContatoInterno').value != '')
		contato[6] = document.getElementById('emailContatoInterno').value;
	else
		contato[6] = '-1';
	if (document.getElementById('faxContatoInterno').value != '')
		contato[7] = document.getElementById('faxContatoInterno').value;
	else
		contato[7] = '-1';
		
	XMLHttp.open("GET",document.formConteudo.action+"?acao=alterarContatoInterno&contatoInterno="+contato,true);
	XMLHttp.send(null);
  }
}

function limparContatoInterno() {
	document.formConteudo.nomeContatoInterno.value = "";
	document.formConteudo.cargo.value = "";
	document.formConteudo.telefoneContatoInterno.value = "";
	document.formConteudo.celularContatoInterno.value = "";
	document.formConteudo.canalPreferencial.options[0].selected = true;
	document.formConteudo.ramal.value = "";
	document.formConteudo.faxContatoInterno.value = "";
	document.formConteudo.emailContatoInterno.value = "";
	var botaoIncluir = '';
	var botaoAlterar = '';
	if (document.formConteudo.action == 'servletcontatopf'){
		botaoIncluir = "<img name=\"imgIncluirContatoInterno\" id=\"imgIncluirContatoInterno\" src=\"imagem/botao/incluir.gif\" style=\"position:absolute; top:347px; left:375px; cursor:hand\" onClick=\"incluirContatoInterno()\" >";
		botaoAlterar = "<img name=\"imgAlterarContatoInterno\" id=\"imgAlterarContatoInterno\" src=\"imagem/botao/alterarDesabilitado.gif\" style=\"position:absolute; top:344px; left:525px; cursor:hand\" >";
	}else{
		botaoIncluir = "<img name=\"imgIncluirContatoInterno\" id=\"imgIncluirContatoInterno\" src=\"imagem/botao/incluir.gif\" style=\"position:absolute; top:377px; left:375px; cursor:hand\" onClick=\"incluirContatoInterno()\" >";
		botaoAlterar = "<img name=\"imgAlterarContatoInterno\" id=\"imgAlterarContatoInterno\" src=\"imagem/botao/alterarDesabilitado.gif\" style=\"position:absolute; top:374px; left:525px; cursor:hand\" >";
	}
	document.getElementById('idBotoesContatoInterno').innerHTML = botaoIncluir+botaoAlterar;
}

//vetor com os itens selecionados de contato interno e banco
var selectedArray = new Array();

//Seta a variável com o vetor de contatos internos selecionados para exclusão
function vetorSelecionados (codLinha) {
  i = selectedArray.length;
  caixaSelecao = document.getElementById(codLinha).firstChild.firstChild;
  nomeContatoInterno = document.getElementById(codLinha).childNodes[1].firstChild.firstChild.nodeValue;
  if(caixaSelecao.checked) {
  	selectedArray[i] = nomeContatoInterno;
  }
  else {
  	for (j = 0;j < i; j++) {
		if(selectedArray[j] == nomeContatoInterno) {
			selectedArray.splice(j, 1);
		}
	}
  }
  document.formConteudo.listaContatoInterno.value = selectedArray;
}

//Exclui um contato interno da empresa (cliente PJ e PF, armazem e transportadora)
function excluirContatoInterno() {
  if(document.formConteudo.listaContatoInterno.value == "") {
    alert("Favor selecionar um contato");
	event.returnValue = false;
  }
  else if(confirm("Deseja excluir o contato interno permanentemente?")) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idContatoInterno').innerHTML = XMLHttp.responseText;
				limparContatoInterno();
			}
		}
	};
	var lista = document.formConteudo.listaContatoInterno.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=excluirContatoInterno&listaContatoInterno="+lista,true);
	XMLHttp.send(null);
  }
  else event.returnValue = false;
}

//Selecionar Contato Interno
function selecionarContatoInterno() {
  document.formConteudo.acao.value = "selecionarContato";
  document.formConteudo.submit();
}

function carregarContatoInterno(id){
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				var botaoIncluir = '';
				var botaoAlterar = '';
				if (document.formConteudo.action == 'servletcontatopf'){
					botaoIncluir = "<img name=\"imgIncluirContatoInterno\" id=\"imgIncluirContatoInterno\" src=\"imagem/botao/incluirDesabilitado.gif\" style=\"position:absolute; top:347px; left:375px; cursor:hand\" >";
					botaoAlterar = "<img name=\"imgAlterarContatoInterno\" id=\"imgAlterarContatoInterno\" src=\"imagem/botao/alterar.gif\" style=\"position:absolute; top:344px; left:525px; cursor:hand\" onClick=\"alterarContatoInterno()\" >";
				}else{
					botaoIncluir = "<img name=\"imgIncluirContatoInterno\" id=\"imgIncluirContatoInterno\" src=\"imagem/botao/incluirDesabilitado.gif\" style=\"position:absolute; top:377px; left:375px; cursor:hand\"  >";
					botaoAlterar = "<img name=\"imgAlterarContatoInterno\" id=\"imgAlterarContatoInterno\" src=\"imagem/botao/alterar.gif\" style=\"position:absolute; top:374px; left:525px; cursor:hand\" onClick=\"alterarContatoInterno()\" >";
				}				
				document.getElementById('idBotoesContatoInterno').innerHTML = botaoIncluir+botaoAlterar;				 
				var contato = XMLHttp.responseText.split(',');
				
				document.getElementById('nomeContatoInterno').value = substituiCaracteresHTML(contato[0]);
				document.getElementById('cargo').value = substituiCaracteresHTML(contato[1]);
				var i = 0;
				if (contato[2] == '0'){
					i = 0;
				}else if (contato[2] == 'celular'){
					i = 1;
				}else if (contato[2] == 'correio'){
					i = 2;
				}else if (contato[2] == 'email'){
					i = 3;	
				}else if (contato[2] == 'fax'){
					i = 4;
				}else if (contato[2] == 'telefone'){
					i = 5;
				}
				document.getElementById('canalPreferencial').options[i].selected = true;
				document.getElementById('telefoneContatoInterno').value = contato[3];
				document.getElementById('ramal').value = contato[4];
				document.getElementById('celularContatoInterno').value = contato[5];
				document.getElementById('emailContatoInterno').value = contato[6];
				document.getElementById('faxContatoInterno').value = contato[7];
			}
		}
	};
		
	XMLHttp.open("GET",document.formConteudo.action+"?acao=selecionarContato&codigoContatoInterno="+id,true);
	XMLHttp.send(null);
}
//Inclui um banco da empresa (cliente PJ e PF, armazem e transportadora)
function incluirBanco() {
  if(checarDadoBanco()) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idBanco').innerHTML = XMLHttp.responseText;
				limparBanco();
			}
		}
	};
	var banco = new Array();
	if (document.getElementById('nomeBanco').value != '')
		banco[0] = document.getElementById('nomeBanco').value;
	else
		banco[0] = '-1';
	if (document.getElementById('agencia').value != '')
		banco[1] = document.getElementById('agencia').value;
	else
		banco[1] = '-1';
	if (document.getElementById('conta').value != '')
		banco[2] = document.getElementById('conta').value;
	else
		banco[2] = '-1';
	if (document.getElementById('ufBanco').value != '0')
		banco[3] = document.getElementById('ufBanco').value;
	else
		banco[3] = '0';
	if (document.getElementById('municipioBanco').value != '0')
		banco[4] = document.getElementById('municipioBanco').value;
	else
		banco[4] = '0';
	XMLHttp.open("GET",document.formConteudo.action+"?acao=incluirBanco&banco="+banco,true);
	XMLHttp.send(null);
  }
  else event.returnValue = false;
}

function alterarBanco() {
	if(document.formConteudo.nomeBanco.value == "") {
	  mostrarMensagem("Informe o nome do banco.", document.formConteudo.nomeBanco);
	}
    else if(document.formConteudo.agencia.value == "") {
      mostrarMensagem("Informe o número da agência.", document.formConteudo.agencia);
    }
    else if(document.formConteudo.conta.value == "") {
      mostrarMensagem("Informe o número da conta.", document.formConteudo.conta);
    }
    else {
	 	criarXmlHttp();
		XMLHttp.onreadystatechange = function(){
			if (XMLHttp.readyState == 4){
				if (XMLHttp.status == 200){
					document.getElementById('idBanco').innerHTML = XMLHttp.responseText;
					limparBanco();
				}
			}
		};
		var banco = new Array();
		if (document.getElementById('nomeBanco').value != '')
			banco[0] = document.getElementById('nomeBanco').value;
		else
			banco[0] = '-1';
		if (document.getElementById('agencia').value != '')
			banco[1] = document.getElementById('agencia').value;
		else
			banco[1] = '-1';
		if (document.getElementById('conta').value != '')
			banco[2] = document.getElementById('conta').value;
		else
			banco[2] = '-1';
		if (document.getElementById('ufBanco').value != '0')
			banco[3] = document.getElementById('ufBanco').value;
		else
			banco[3] = '0';
		if (document.getElementById('municipioBanco').value != '0')
			banco[4] = document.getElementById('municipioBanco').value;
		else
			banco[4] = '0';
			
		XMLHttp.open("GET",document.formConteudo.action+"?acao=alterarBanco&banco="+banco,true);
		XMLHttp.send(null);
    }
}

function limparBanco() {
	document.formConteudo.nomeBanco.value = "";
	document.formConteudo.agencia.value = "";
	document.formConteudo.conta.value = "";
	document.formConteudo.ufBanco.options[0].selected = true;
	document.formConteudo.municipioBanco.options[0].selected = true;
	document.formConteudo.municipioBanco.length = 1;
	document.formConteudo.municipioBanco.options[0].text = "(Selecione o município)";
	document.formConteudo.municipioBanco.options[0].value = 0;
	
	var botaoIncluir = "<img name=\"imgIncluirBanco\" id=\"imgIncluirBanco\" src=\"imagem/botao/incluir_pq.gif\" style=\"position:absolute; top: 116px; left: 460px; cursor:hand\" onClick=\"incluirBanco()\"  >";
	var botaoAlterar = "<img name=\"imgAlterarBanco\" id=\"imgAlterarBanco\" src=\"imagem/botao/alterar_pqDesabilitado.gif\" style=\"position:absolute; top: 113px; left: 580px; cursor:hand\" >	";
	document.getElementById('idBotoesBanco').innerHTML = botaoIncluir+botaoAlterar;
}

var bancosSelecionados = new Array();

function vetorBancosSelecionados (codLinha) {
  i = bancosSelecionados.length;
  caixaSelecao = document.getElementById(codLinha).firstChild.firstChild;
  agencia = document.getElementById(codLinha).childNodes[2].firstChild.nodeValue.replace("Ag: ", "");
  conta = document.getElementById(codLinha).childNodes[3].firstChild.nodeValue.replace("CC: ", "");
  if(caixaSelecao.checked) {
  	bancosSelecionados[i] = agencia;
        i++;
        bancosSelecionados[i] = conta;
  }
  else {
    for (j = 0;j < i; j++) {
      if(bancosSelecionados[j] == agencia && bancosSelecionados[j+1] == conta) {
		bancosSelecionados.splice(j, 2);
      }
    }
  }
  document.formConteudo.listaBanco.value = bancosSelecionados;
}

//Exclui um banco da empresa (cliente PJ e PF, armazem e transportadora)
function excluirBanco() {
  if(document.formConteudo.listaBanco.value == "") {
    alert("Favor selecionar um banco.");
	event.returnValue = false;
  }
  else {
    if(confirm("Deseja excluir o banco permanentemente?")) {
	  	criarXmlHttp();
		XMLHttp.onreadystatechange = function(){
			if (XMLHttp.readyState == 4){
				if (XMLHttp.status == 200){
					document.getElementById('idBanco').innerHTML = XMLHttp.responseText;
					limparBanco();
				}
			}
		};
		var lista = document.formConteudo.listaBanco.value;
		XMLHttp.open("GET",document.formConteudo.action+"?acao=excluirBanco&listaBanco="+lista,true);
		XMLHttp.send(null);
    }
	else event.returnValue = false;
  }
}

//Selecionar Banco
function selecionarBanco() {
  document.formConteudo.acao.value = "selecionarBanco";
  document.formConteudo.submit();
}

function carregarBanco(id){	
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				var botaoIncluir = "<img name=\"imgIncluirBanco\" id=\"imgIncluirBanco\" src=\"imagem/botao/incluir_pqDesabilitado.gif\" style=\"position:absolute; top: 116px; left: 460px; cursor:hand\"   >";
				var botaoAlterar = "<img name=\"imgAlterarBanco\" id=\"imgAlterarBanco\" src=\"imagem/botao/alterar_pq.gif\" style=\"position:absolute; top: 113px; left: 580px; cursor:hand\" onClick=\"alterarBanco()\" >	";
				document.getElementById('idBotoesBanco').innerHTML = botaoIncluir+botaoAlterar;
				var banco = XMLHttp.responseText.split(',');
				
				document.getElementById('nomeBanco').value = substituiCaracteresHTML(banco[0]);
				document.getElementById('agencia').value = banco[1];
				document.getElementById('conta').value = banco[2];
				var i = 0;
				if (banco[3] == '0'){
					i = 0;
				}else if (banco[3] == 'AC'){
					i = 1;
				}else if (banco[3] == 'AL'){
					i = 2;
				}else if (banco[3] == 'AP'){
					i = 3;	
				}else if (banco[3] == 'AM'){
					i = 4;
				}else if (banco[3] == 'BA'){
					i = 5;
				}else if (banco[3] == 'CE'){
					i = 6;
				}else if (banco[3] == 'DF'){
					i = 7;
				}else if (banco[3] == 'ES'){
					i = 8;	
				}else if (banco[3] == 'GO'){
					i = 9;
				}else if (banco[3] == 'MA'){
					i = 10;
				}else if (banco[3] == 'MT'){
					i = 11;
				}else if (banco[3] == 'MS'){
					i = 12;
				}else if (banco[3] == 'MG'){
					i = 13;	
				}else if (banco[3] == 'PA'){
					i = 14;
				}else if (banco[3] == 'PB'){
					i = 15;
				}else if (banco[3] == 'PR'){
					i = 16;
				}else if (banco[3] == 'PE'){
					i = 17;
				}else if (banco[3] == 'PI'){
					i = 18;	
				}else if (banco[3] == 'RJ'){
					i = 19;
				}else if (banco[3] == 'RN'){
					i = 20;
				}else if (banco[3] == 'RS'){
					i = 21;
				}else if (banco[3] == 'RO'){
					i = 22;
				}else if (banco[3] == 'RR'){
					i = 23;
				}else if (banco[3] == 'SC'){
					i = 24;
				}else if (banco[3] == 'SP'){
					i = 25;
				}else if (banco[3] == 'SE'){
					i = 26;
				}else if (banco[3] == 'TO'){
					i = 27;
				}
				document.getElementById('ufBanco').options[i].selected = true;
				filtrarMunicipioBanco(banco[3],banco[4]);
			}
		}
	};
		
	XMLHttp.open("GET",document.formConteudo.action+"?acao=selecionarBanco&codigoBanco="+id,true);
	XMLHttp.send(null);
}

//Vincula um cliente com um armazem
function vincularArmazem() {
  if (verificaSelecao(document.formConteudo.todosArmazens)) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idArmazem').innerHTML = XMLHttp.responseText;
			}
		}
	};
	var codigo = document.formConteudo.todosArmazens.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=vincularArmazem&codigoArmazem="+codigo,true);
	XMLHttp.send(null);
  }
  else{
   alert("Favor selecionar um armazém antes de vinculá-lo.");
   event.returnValue = false;
  }
}

//Desvincula um cliente com um armazem
function desvincularArmazem() {
  if (verificaSelecao(document.formConteudo.empresaArmazens)) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idArmazem').innerHTML = XMLHttp.responseText;
			}
		}
	};
	var codigo = document.formConteudo.empresaArmazens.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=desvincularArmazem&codigoArmazem="+codigo,true);
	XMLHttp.send(null);
  }
  else {
  	alert("Favor selecionar um armazém antes de desvinculá-lo.");
    event.returnValue = false;
  }
}

//Vincula um cliente com uma motorista
function vincularMotorista() {
  if (verificaSelecao(document.formConteudo.todosMotoristas)) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idMotorista').innerHTML = XMLHttp.responseText;
			}
		}
	};
	var codigo = document.formConteudo.todosMotoristas.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=vincularMotorista&codigoMotorista="+codigo,true);
	XMLHttp.send(null);
  }
  else {
   alert("Favor selecionar um motorista antes de vinculá-lo.");
   event.returnValue = false;
  }
}

//Desvincula um cliente com uma motorista
function desvincularMotorista() {
  if (verificaSelecao(document.formConteudo.empresaMotoristas)) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idMotorista').innerHTML = XMLHttp.responseText;
			}
		}
	};
	var codigo = document.formConteudo.empresaMotoristas.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=desvincularMotorista&codigoMotorista="+codigo,true);
	XMLHttp.send(null);
  }
  else {
   alert("Favor selecionar um motorista antes de desvinculá-lo.");
   event.returnValue = false;
  }
}


function vincularCliente() {
  if (verificaSelecao(document.formConteudo.todosClientes)) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idCliente').innerHTML = XMLHttp.responseText;
			}
		}
	};
	var codigo = document.formConteudo.todosClientes.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=vincularCliente&codigoCliente="+codigo,true);
	XMLHttp.send(null);
  }
  else{
   alert("Favor selecionar um Cliente antes de vinculá-lo.");
   event.returnValue = false;
  }
}

function desvincularCliente() {
  if (verificaSelecao(document.formConteudo.faturanteClientes)) {
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idCliente').innerHTML = XMLHttp.responseText;
			}
		}
	};
	var codigo = document.formConteudo.faturanteClientes.value;
	XMLHttp.open("GET",document.formConteudo.action+"?acao=desvincularCliente&codigoCliente="+codigo,true);
	XMLHttp.send(null);
  }
  else {
  	alert("Favor selecionar um Cliente antes de desvinculá-lo.");
    event.returnValue = false;
  }
}

//Inclui o cadastro do armazem
function incluirArmazem() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvar";
    document.formConteudo.submit();
  }
}

//Exclui o armazém
function excluirArmazem() {
  if(confirm("Deseja excluir o armazém permanentemente?")) {
  document.formConteudo.acao.value = "excluirArmazem";
  document.formConteudo.submit();
  }
}

//Altera o cadastro do armazém
function alterarArmazem() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvarArmazem";
    document.formConteudo.submit();
  }
}

//Inclui o cadastro do transportadora
function incluirTransportadora() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvar";
    document.formConteudo.submit();
  }
}

//Exclui o transportadora
function excluirTransportadora() {
  if(confirm("Deseja excluir a transportadora permanentemente?")) {
  document.formConteudo.acao.value = "excluirTransportadora";
  document.formConteudo.submit();
  }
}

//Altera o cadastro do transportadora
function alterarTransportadora() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvarTransportadora";
    document.formConteudo.submit();
  }
 }

//Inclui o cadastro do motorista
function incluirMotorista() {
  if(checarDadoPrincipal()) {
    if(document.formConteudo.placa.value != "") {
      if(validaPlaca()) {
        document.formConteudo.acao.value = "salvar";
        document.formConteudo.submit();
      }
    }
    else {
      document.formConteudo.acao.value = "salvar";
      document.formConteudo.submit();
    }
  }
}

//Exclui o motorista
function excluirMotorista() {
  if(confirm("Deseja excluir o motorista permanentemente?")) {
  document.formConteudo.acao.value = "excluirMotorista";
  document.formConteudo.submit();
  }
}

//Altera o cadastro do motorista
function alterarMotorista() {
  if(checarDadoPrincipal()) {
    if(document.formConteudo.placa.value != "") {
      if(validaPlaca()) {
        document.formConteudo.acao.value = "salvarMotorista";
        document.formConteudo.submit();
      }
    }
    else {
      document.formConteudo.acao.value = "salvarMotorista";
      document.formConteudo.submit();
    }
  }
 }

//Inclui o cadastro do cliente PJ
function incluirClientePJ() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvar";
    document.formConteudo.submit();
  }
}

//Exclui o cadastro do cliente PJ
function excluirClientePJ() {
  if(confirm("Deseja excluir permanentemente o cliente?")) {
    document.formConteudo.acao.value = "excluirClientePJ";
	document.formConteudo.submit();
  }
}

//Altera o cadastro do cliente PJ
function alterarClientePJ() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvarClientePJ";
	document.formConteudo.submit();
  }
}

//Inclui o cadastro do cliente PF
function incluirClientePF() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvar";
    document.formConteudo.submit();
  }
}

//Exclui o cadastro do cliente PF
function excluirClientePF() {
  if(confirm("Deseja excluir permanentemente o cliente?")) {
    document.formConteudo.acao.value = "excluirClientePF";
    document.formConteudo.submit();
  }
}

//Alterar o cadastro do cliente PF
function alterarClientePF() {
  if(checarDadoPrincipal()) {
    document.formConteudo.acao.value = "salvarClientePF";
    document.formConteudo.submit();
  }
}

//Incluir atividade do cliente
function incluirAtividade() {
  if(document.formConteudo.atividade.value == "") {
    mostrarMensagem("Informe o nome da atividade.", document.formConteudo.atividade);
  }
  else {
    document.formConteudo.acao.value = "incluir";
    document.formConteudo.submit();
  }
}

//Exclui uma atividade do cliente
function excluirAtividade() {
  if(confirm("Deseja excluir a atividade do cliente?")) {
    document.formConteudo.acao.value = "excluir";
    document.formConteudo.submit();
  }
}

function filtrarMunicipioBanco(codigoUf,codigoMunicipio) {  	
	var aguarde = "<select class=\"dados\" style=\"position: absolute; top: 116px; left: 170px; width: 260px;\"><option>Aguarde...</option></select>";	

	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		document.getElementById('idMunicipioBanco').innerHTML = aguarde;
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				document.getElementById('idMunicipioBanco').innerHTML = XMLHttp.responseText;
			}
		}
	};
	XMLHttp.open("GET",document.formConteudo.action+"?acao=filtrarMunicipios&codigoUf="+codigoUf+"&tipo=idMunicipioBanco&codigoMunicipio="+codigoMunicipio,true);
	XMLHttp.send(null);
}

//Verifica os dados do formulario principal
function checarDadoPrincipal() {
  if(document.formConteudo.nome.value == "") {
    mostrarMensagem("Informe o nome do contato.", document.formConteudo.nome);
    trocaCorFonte ("ftNome", vermelho);
    sinalizaCampo ("nome", "campoInvalido");
    return false;
  }
  else {
	  if (verificaCaracteresEspeciais(document.formConteudo.nome.value, 'nome')) {
		trocaCorFonte ("ftNome", preto);
		sinalizaCampo ("nome", "dados");
	  }
	  else {
		trocaCorFonte ("ftNome", vermelho);
	    sinalizaCampo ("nome", "campoInvalido");
		return false;
	  }
  }

  trocaCorFonte ("ftEmail", preto);
  sinalizaCampo ("email", "dados");
  trocaCorFonte ("ftCnpj", preto);
  sinalizaCampo ("cnpj", "dados");

  if(document.formConteudo.cnpj.value != "") {
    if(document.formConteudo.cnpj.value.length == 18) {
      if (!validaCNPJ()) {
		trocaCorFonte ("ftCnpj", vermelho);
		sinalizaCampo ("cnpj", "campoInvalido");
        return false;
      }
    }
    else if(document.formConteudo.cnpj.value.length == 14) {
      if (!validaCPF()) {
		trocaCorFonte ("ftCnpj", vermelho);
		sinalizaCampo ("cnpj", "campoInvalido");
        return false;
      }
    }
    else if((document.formConteudo.cnpj.value.length < 14) ||
            (document.formConteudo.cnpj.value.length > 14 && document.formConteudo.cnpj.value.length < 18)) {
        mostrarMensagem("Número do CNPJ ou CPF muito pequeno. Informe novamente!", document.formConteudo.cnpj);
        document.formConteudo.cnpj.value = "";
		trocaCorFonte ("ftCnpj", vermelho);
		sinalizaCampo ("cnpj", "campoInvalido");
      return false;
    }
  }

  if(document.formConteudo.email.value != "") {
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.formConteudo.email.value))) {
      mostrarMensagem("Favor informar um e-mail válido.", document.formConteudo.email);
		trocaCorFonte ("ftEmail", vermelho);
		sinalizaCampo ("email", "campoInvalido");
      return false;
    }
  }
  return true;
}

//Verifica os dados do contato interno
function checarDadoContatoInterno() {

  if (document.formConteudo.nomeContatoInterno.value == "") {
    mostrarMensagem("Informe o nome do contato interno.", document.formConteudo.nomeContatoInterno);
    return false;
  }
  else {
    linha = document.getElementById('tabelaContatoInterno').firstChild.firstChild;

    while(linha != null){
      nome = linha.childNodes[1].firstChild.firstChild.nodeValue;
      if(document.formConteudo.nomeContatoInterno.value == nome){
        alert("Nome do contato existente, favor digitar outro nome.");
        return false;
      }
      linha = linha.nextSibling;
    }
  }
  if (document.formConteudo.emailContatoInterno.value != "") {
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.formConteudo.emailContatoInterno.value))) {
      mostrarMensagem("Favor informar um e-mail válido.", document.formConteudo.emailContatoInterno);
      return false;
    }
  }
  return true;
}

//Verifica os dados do banco
function checarDadoBanco() {
  if(document.formConteudo.nomeBanco.value == "") {
    mostrarMensagem("Informe o nome do banco.", document.formConteudo.nomeBanco);
    return false;
  }
  else {
    linhaBanco = document.getElementById('tabelaBanco').firstChild.firstChild;

    while(linhaBanco != null){
      agencia = linhaBanco.childNodes[2].firstChild.nodeValue.replace("Ag: ", "");
      if(document.formConteudo.agencia.value == agencia &&
        document.formConteudo.conta.value == linhaBanco.childNodes[3].firstChild.nodeValue.replace("CC: ", "")){
        alert("Agencia e conta já cadastrados, favor digitar outra conta ou agencia.");
        return false;
      }
      linhaBanco = linhaBanco.nextSibling;
    }

    if(document.formConteudo.agencia.value == "") {
      mostrarMensagem("Informe o número da agência.", document.formConteudo.agencia);
      return false;
    }
    else if(document.formConteudo.conta.value == "") {
      mostrarMensagem("Informe o número da conta.", document.formConteudo.conta);
      return false;
    }
  }
  return true;
}


//Verifica a validade do CNPJ
function validaCNPJ() {
  CNPJ = document.formConteudo.cnpj.value;
  erro = new String;
  if (CNPJ.length < 18) erro += "É necessario preencher corretamente o número do CNPJ! \n\n";
  if ((CNPJ.charAt(2) != ".") || (CNPJ.charAt(6) != ".") || (CNPJ.charAt(10) != "/") || (CNPJ.charAt(15) != "-")){
    if (erro.length == 0) erro += "É necessario preencher corretamente o número do CNPJ! \n\n";
  }
  //substituir os caracteres que nao sao numeros
  if(document.layers && parseInt(navigator.appVersion) == 4){
    x = CNPJ.substring(0,2);
    x += CNPJ.substring(3,6);
    x += CNPJ.substring(7,10);
    x += CNPJ.substring(11,15);
    x += CNPJ.substring(16,18);
    CNPJ = x;
  }
  else {
    CNPJ = CNPJ.replace(".","");
    CNPJ = CNPJ.replace(".","");
    CNPJ = CNPJ.replace("-","");
    CNPJ = CNPJ.replace("/","");
  }
  var nonNumbers = /\D/;
  if (nonNumbers.test(CNPJ)) erro += "A verificacao de CNPJ suporta apenas numeros! \n\n";
  if ((CNPJ == "00000000000000") || (CNPJ == "111111111111111")) {
    if (erro.length == 0) {
      erro += "CNPJ inválido, digite novamente!";
    }
  }
  var a = [];
  var b = new Number;
  var c = [6,5,4,3,2,9,8,7,6,5,4,3,2];
  for (i=0; i<12; i++){
    a[i] = CNPJ.charAt(i);
    b += a[i] * c[i+1];
  }
  if ((x = b % 11) < 2) {
    a[12] = 0
  }
  else {
  a[12] = 11-x
  }
  b = 0;
  for (y=0; y<13; y++) {
    b += (a[y] * c[y]);
  }
  if ((x = b % 11) < 2) {
    a[13] = 0;
  }
  else {
    a[13] = 11-x;
  }
  if ((CNPJ.charAt(12) != a[12]) || (CNPJ.charAt(13) != a[13])){
    erro +="CNPJ inválido, digite novamente!";
  }
  if (erro.length > 0){
    alert(erro);
    document.formConteudo.cnpj.value = "";
    document.formConteudo.cnpj.focus();
    return false;
  }
  return true;
}

//Máscara do CNPJ
function mascaraCNPJ(CNPJ, formCampo){
  var campo = eval("document." + formCampo);
  var valorCNPJ = '';
  valorCNPJ = valorCNPJ + CNPJ;
  if (event.keyCode == 8) {
  	if (valorCNPJ.length == 2 || valorCNPJ.length == 6 || valorCNPJ.length == 10 ||
            valorCNPJ.length == 15) {
		valorCNPJ = valorCNPJ.substring(0,valorCNPJ.length-1);
	}
	campo.value = valorCNPJ;
  }
  else if(valorCNPJ.length == 2) {
    valorCNPJ = valorCNPJ + '.';
    campo.value = valorCNPJ;
  }
  else if(valorCNPJ.length == 6) {
    valorCNPJ = valorCNPJ + '.';
    campo.value = valorCNPJ;
  }
  else if(valorCNPJ.length == 10) {
    valorCNPJ = valorCNPJ + '/';
    campo.value = valorCNPJ;
  }
  else if(valorCNPJ.length == 15) {
    valorCNPJ = valorCNPJ + '-';
    campo.value = valorCNPJ;
  }
}

//Valida o CPF
function validaCPF() {
  cpf = document.formConteudo.cnpj.value;
  valor = true;
  erro = new String;
  if(document.layers && parseInt(navigator.appVersion) == 4){
    z = cpf.substring(0,3);
    z += cpf.substring(4,7);
    z += cpf.substring(8,11);
    z += cpf.substring(12,14);
    cpf = z;
  }
  else {
    cpf = cpf.replace(".","");
    cpf = cpf.replace(".","");
    cpf = cpf.replace("-","");
  }
  if (cpf.length < 11) {
    erro += "Sao necessarios 11 digitos para verificacao do CPF! \n\n";
  }
  var nonNumbers = /\D/;
  if (nonNumbers.test(cpf)) {
    erro += "A verificacao de CPF suporta apenas numeros! \n\n";
  }
  if (cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" ||
      cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" ||
      cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" ||
      cpf == "99999999999") {
    erro += "Numero de CPF invalido!";
  }
  var a = [];
  var b = new Number;
  var c = 11;
  for (i=0; i<11; i++) {
    a[i] = cpf.charAt(i);
    if (i < 9) {
      b += (a[i] *  --c);
    }
  }
  if ((x = b % 11) < 2) {
    a[9] = 0
  }
  else {
    a[9] = 11-x
  }
  b = 0;
  c = 11;
  for (y=0; y<10; y++) {
    b += (a[y] *  c--);
  }
  if ((x = b % 11) < 2) {
    a[10] = 0;
  }
  else {
    a[10] = 11-x;
  }
  if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10])){
    erro +="Digito verificador com problema!";
  }
  if (erro.length > 0){
    alert(erro);
    document.formConteudo.cnpj.value = "";
    document.formConteudo.cnpj.focus();
    return false;
  }
  return true;
}

//Máscara do CPF
function mascaraCPF(CPF, formCampo){
  var campo = eval("document." + formCampo);
  var valorCPF = '';
  valorCPF = valorCPF + CPF;
  if(event.keyCode == 37) {
  	var tamanho = valorCPF.length;
	if (tamanho == 4 || tamanho == 8 || tamanho == 12) {
	valorCPF = valorCPF.substring(0,tamanho-2);
	}
	else {
		valorCPF = valorCPF.substring(0,tamanho-1);
	}
	campo.value = valorCPF;
  }
  else if (event.keyCode == 8) {
  	if (valorCPF.length == 3 || valorCPF.length == 7 || valorCPF.length == 11) {
		valorCPF = valorCPF.substring(0,valorCPF.length-1);
	}
	campo.value = valorCPF;
  }
  else if(valorCPF.length == 3) {
    valorCPF = valorCPF + '.';
    campo.value = valorCPF;
  }
  else if(valorCPF.length == 7) {
    valorCPF = valorCPF + '.';
    campo.value = valorCPF;
  }
  else if(valorCPF.length == 11) {
    valorCPF = valorCPF + '-';
    campo.value = valorCPF;
  }
}

//Valida a placa
function validaPlaca() {
  placa = document.formConteudo.placa.value;
  letras = placa.substring(0,3);
  numeros = placa.substring(4, 8);
  var nonNumbers = /\D/;
  if (nonNumbers.test(numeros)) {
    alert("A placa deve conter números nos quatro últimos caracteres.");
    return false;
  }
  var nonWords = /[\b0-9]/;
  if (nonWords.test(letras)) {
    alert("Os três primeiros caracteres devem ser letras.");
    return false;
  }
  return true;
}

//Máscara da placa
function mascaraPlaca(placa, formCampo){
  var campo = eval("document." + formCampo);
  var valorPlaca = '';
  valorPlaca = valorPlaca + placa;
  if(event.keyCode == 37) {
  	var tamanho = valorPlaca.length;
	if (tamanho == 4) {
	valorPlaca = valorPlaca.substring(0,tamanho-2);
	}
	else {
		valorPlaca = valorPlaca.substring(0,tamanho-1);
	}
	campo.value = valorPlaca;
  }
  else if (event.keyCode == 8) {
  	if (valorPlaca.length == 3) {
		valorPlaca = valorPlaca.substring(0,valorPlaca.length-1);
	}
	campo.value = valorPlaca;
  }
  else if(valorPlaca.length == 3) {
    valorPlaca = valorPlaca + '-';
    campo.value = valorPlaca;
  }
}

//Máscara do CEP
function mascaraCEP(cep, formCampo){
  var campo = eval("document." + formCampo);
  var valorCEP = '';
  valorCEP = valorCEP + cep;
  if(event.keyCode == 37) {
  	var tamanho = valorCEP.length;
	if (tamanho == 6) {
	valorCEP = valorCEP.substring(0,tamanho-2);
	}
	else {
		valorCEP = valorCEP.substring(0,tamanho-1);
	}
	campo.value = valorCEP;
  }
  else if (event.keyCode == 8) {
  	if (valorCEP.length == 5) {
		valorCEP = valorCEP.substring(0,valorCEP.length-1);
	}
	campo.value = valorCEP;
  }
  else if(valorCEP.length == 5) {
    valorCEP = valorCEP + '-';
    campo.value = valorCEP;
  }
}

function stAba(abas,conteudo)
{
	this.abas = abas;
	this.conteudo = conteudo;
}

var arAbas = new Array();
arAbas[0] = new stAba('aba_dados','div_dados');
arAbas[1] = new stAba('aba_adicionais','div_adicionais');
arAbas[2] = new stAba('aba_adicionais2','div_adicionais2');
arAbas[3] = new stAba('aba_adicionais3','div_adicionais3');

function AlternarAbas(abas,conteudo)
{
	for (i=0;i<arAbas.length;i++)
	{
		m = document.getElementById(arAbas[i].abas);
		m.className = 'abas';
		c = document.getElementById(arAbas[i].conteudo)
		c.style.display = 'none';
	}
	m = document.getElementById(abas)
	m.className = 'abaSelecionada';
	c = document.getElementById(conteudo)
	c.style.display = '';
}
//Avança para proxima pagina de contato
function proximoPagina() {
	var aba = null;
	if (document.formConteudo.posicaoAba)
		aba = document.formConteudo.posicaoAba.value;
	else
		aba = '';
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				if (aba == 'aba_clientePJ'){
					document.getElementById('div_clientePJ').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePJ.value = parseInt(document.formConteudo.pagAtualClientePJ.value) + 1;
				}else if (aba == 'aba_clientePF'){
					document.getElementById('div_clientePF').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePF.value = parseInt(document.formConteudo.pagAtualClientePF.value) + 1;
				}else if (aba == 'aba_armazem'){
					document.getElementById('div_armazem').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualArmazem.value = parseInt(document.formConteudo.pagAtualArmazem.value) + 1;
				}else if (aba == 'aba_transportadora'){
					document.getElementById('div_transportadora').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualTransportadora.value = parseInt(document.formConteudo.pagAtualTransportadora.value) + 1;
				}else if (aba == 'aba_motorista'){
					document.getElementById('div_motorista').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualMotorista.value = parseInt(document.formConteudo.pagAtualMotorista.value) + 1;
				}else if (aba == ''){
					document.getElementById('div_predefinida').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualPreDefinida.value = parseInt(document.formConteudo.pagAtualPreDefinida.value) + 1;
				}
			}
		}
	};
	var pagAtual = 0;
	var pagTotal = 0;
	var ordenar = '';
	if (aba == 'aba_clientePJ'){
		pagAtual = document.formConteudo.pagAtualClientePJ.value;
		pagTotal = document.formConteudo.pagTotalClientePJ.value;
		ordenar = document.formConteudo.ordenarClientePJ.value;
	}else if (aba == 'aba_clientePF'){
		pagAtual = document.formConteudo.pagAtualClientePF.value;
		pagTotal = document.formConteudo.pagTotalClientePF.value;
		ordenar = document.formConteudo.ordenarClientePF.value;
	}else if (aba == 'aba_armazem'){
		pagAtual = document.formConteudo.pagAtualArmazem.value;
		pagTotal = document.formConteudo.pagTotalArmazem.value;
		ordenar = document.formConteudo.ordenarArmazem.value;
	}else if (aba == 'aba_transportadora'){
		pagAtual = document.formConteudo.pagAtualTransportadora.value;
		pagTotal = document.formConteudo.pagTotalTransportadora.value;
		ordenar = document.formConteudo.ordenarTransportadora.value;
	}else if (aba == 'aba_motorista'){
		pagAtual = document.formConteudo.pagAtualMotorista.value;
		pagTotal = document.formConteudo.pagTotalMotorista.value;
		ordenar = document.formConteudo.ordenarMotorista.value;
	}else if (aba == ''){
		pagAtual = document.formConteudo.pagAtualPreDefinida.value;
		pagTotal = document.formConteudo.pagTotalPreDefinida.value;
	}
	if (aba == ''){
		var pesquisa = document.formConteudo.pesquisa.value;
		XMLHttp.open("GET",document.formConteudo.action+"?acao=proximo&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&pesquisa="+pesquisa,true);
	}else
		XMLHttp.open("GET",document.formConteudo.action+"?acao=proximo&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&ordenar="+ordenar,true);

	XMLHttp.send(null);
}
//Volta para pagina anterior do contato
function anteriorPagina() {
	var aba = null;
	if (document.formConteudo.posicaoAba)
		aba = document.formConteudo.posicaoAba.value;
	else
		aba = '';
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				if (aba == 'aba_clientePJ'){
					document.getElementById('div_clientePJ').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePJ.value = parseInt(document.formConteudo.pagAtualClientePJ.value) - 1;
				}else if (aba == 'aba_clientePF'){
					document.getElementById('div_clientePF').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePF.value = parseInt(document.formConteudo.pagAtualClientePF.value) - 1;
				}else if (aba == 'aba_armazem'){
					document.getElementById('div_armazem').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualArmazem.value = parseInt(document.formConteudo.pagAtualArmazem.value) - 1;
				}else if (aba == 'aba_transportadora'){
					document.getElementById('div_transportadora').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualTransportadora.value = parseInt(document.formConteudo.pagAtualTransportadora.value) - 1;
				}else if (aba == 'aba_motorista'){
					document.getElementById('div_motorista').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualMotorista.value = parseInt(document.formConteudo.pagAtualMotorista.value) - 1;
				}else if (aba == ''){
					document.getElementById('div_predefinida').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualPreDefinida.value = parseInt(document.formConteudo.pagAtualPreDefinida.value) - 1;
				}
			}
		}
	};
	var pagAtual = 0;
	var pagTotal = 0;
	var ordenar = '';
	if (aba == 'aba_clientePJ'){
		pagAtual = document.formConteudo.pagAtualClientePJ.value;
		pagTotal = document.formConteudo.pagTotalClientePJ.value;
		ordenar = document.formConteudo.ordenarClientePJ.value;
	}else if (aba == 'aba_clientePF'){
		pagAtual = document.formConteudo.pagAtualClientePF.value;
		pagTotal = document.formConteudo.pagTotalClientePF.value;
		ordenar = document.formConteudo.ordenarClientePF.value;
	}else if (aba == 'aba_armazem'){
		pagAtual = document.formConteudo.pagAtualArmazem.value;
		pagTotal = document.formConteudo.pagTotalArmazem.value;
		ordenar = document.formConteudo.ordenarArmazem.value;
	}else if (aba == 'aba_transportadora'){
		pagAtual = document.formConteudo.pagAtualTransportadora.value;
		pagTotal = document.formConteudo.pagTotalTransportadora.value;
		ordenar = document.formConteudo.ordenarTransportadora.value;
	}else if (aba == 'aba_motorista'){
		pagAtual = document.formConteudo.pagAtualMotorista.value;
		pagTotal = document.formConteudo.pagTotalMotorista.value;
		ordenar = document.formConteudo.ordenarMotorista.value;
	}else if (aba == ''){
		pagAtual = document.formConteudo.pagAtualPreDefinida.value;
		pagTotal = document.formConteudo.pagTotalPreDefinida.value;
	}
	if (aba == ''){
		var pesquisa = document.formConteudo.pesquisa.value;
		XMLHttp.open("GET",document.formConteudo.action+"?acao=anterior&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&pesquisa="+pesquisa,true);
	}else
		XMLHttp.open("GET",document.formConteudo.action+"?acao=anterior&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&ordenar="+ordenar,true);
	
	XMLHttp.send(null);
}
//Avança para pagina a ultima do contato
function ultimoPagina() {
	var aba = null;
	if (document.formConteudo.posicaoAba)
		aba = document.formConteudo.posicaoAba.value;
	else
		aba = '';
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				if (aba == 'aba_clientePJ'){
					document.getElementById('div_clientePJ').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePJ.value = parseInt(document.formConteudo.pagTotalClientePJ.value);
				}else if (aba == 'aba_clientePF'){
					document.getElementById('div_clientePF').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePF.value = parseInt(document.formConteudo.pagTotalClientePF.value);
				}else if (aba == 'aba_armazem'){
					document.getElementById('div_armazem').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualArmazem.value = parseInt(document.formConteudo.pagTotalArmazem.value);
				}else if (aba == 'aba_transportadora'){
					document.getElementById('div_transportadora').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualTransportadora.value = parseInt(document.formConteudo.pagTotalTransportadora.value);
				}else if (aba == 'aba_motorista'){
					document.getElementById('div_motorista').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualMotorista.value = parseInt(document.formConteudo.pagTotalMotorista.value);
				}else if (aba == ''){
					document.getElementById('div_predefinida').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualPreDefinida.value = parseInt(document.formConteudo.pagTotalPreDefinida.value);
				}
			}
		}
	};
	var pagAtual = 0;
	var pagTotal = 0;
	var ordenar = '';
	if (aba == 'aba_clientePJ'){
		pagAtual = document.formConteudo.pagAtualClientePJ.value;
		pagTotal = document.formConteudo.pagTotalClientePJ.value;
		ordenar = document.formConteudo.ordenarClientePJ.value;
	}else if (aba == 'aba_clientePF'){
		pagAtual = document.formConteudo.pagAtualClientePF.value;
		pagTotal = document.formConteudo.pagTotalClientePF.value;
		ordenar = document.formConteudo.ordenarClientePF.value;
	}else if (aba == 'aba_armazem'){
		pagAtual = document.formConteudo.pagAtualArmazem.value;
		pagTotal = document.formConteudo.pagTotalArmazem.value;
		ordenar = document.formConteudo.ordenarArmazem.value;
	}else if (aba == 'aba_transportadora'){
		pagAtual = document.formConteudo.pagAtualTransportadora.value;
		pagTotal = document.formConteudo.pagTotalTransportadora.value;
		ordenar = document.formConteudo.ordenarTransportadora.value;
	}else if (aba == 'aba_motorista'){
		pagAtual = document.formConteudo.pagAtualMotorista.value;
		pagTotal = document.formConteudo.pagTotalMotorista.value;
		ordenar = document.formConteudo.ordenarMotorista.value;
	}else if (aba == ''){
		pagAtual = document.formConteudo.pagAtualPreDefinida.value;
		pagTotal = document.formConteudo.pagTotalPreDefinida.value;
	}
	if (aba == ''){
		var pesquisa = document.formConteudo.pesquisa.value;
		XMLHttp.open("GET",document.formConteudo.action+"?acao=ultimo&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&pesquisa="+pesquisa,true);
	}else
		XMLHttp.open("GET",document.formConteudo.action+"?acao=ultimo&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&ordenar="+ordenar,true);
	
	XMLHttp.send(null);
}
//Avança para pagina a primeira do contato
function primeiroPagina() {
	var aba = null;
	if (document.formConteudo.posicaoAba)
		aba = document.formConteudo.posicaoAba.value;
	else
		aba = '';
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				if (aba == 'aba_clientePJ'){
					document.getElementById('div_clientePJ').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePJ.value = 1;
				}else if (aba == 'aba_clientePF'){
					document.getElementById('div_clientePF').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualClientePF.value = 1;
				}else if (aba == 'aba_armazem'){
					document.getElementById('div_armazem').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualArmazem.value = 1;
				}else if (aba == 'aba_transportadora'){
					document.getElementById('div_transportadora').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualTransportadora.value = 1;
				}else if (aba == 'aba_motorista'){
					document.getElementById('div_motorista').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualMotorista.value = 1;
				}else if (aba == ''){
					document.getElementById('div_predefinida').innerHTML = XMLHttp.responseText;
					document.formConteudo.pagAtualPreDefinida.value = 1;
				}
			}
		}
	};
	var pagAtual = 0;
	var pagTotal = 0;
	var ordenar = '';
	if (aba == 'aba_clientePJ'){
		pagAtual = document.formConteudo.pagAtualClientePJ.value;
		pagTotal = document.formConteudo.pagTotalClientePJ.value;
		ordenar = document.formConteudo.ordenarClientePJ.value;
	}else if (aba == 'aba_clientePF'){
		pagAtual = document.formConteudo.pagAtualClientePF.value;
		pagTotal = document.formConteudo.pagTotalClientePF.value;
		ordenar = document.formConteudo.ordenarClientePF.value;
	}else if (aba == 'aba_armazem'){
		pagAtual = document.formConteudo.pagAtualArmazem.value;
		pagTotal = document.formConteudo.pagTotalArmazem.value;
		ordenar = document.formConteudo.ordenarArmazem.value;
	}else if (aba == 'aba_transportadora'){
		pagAtual = document.formConteudo.pagAtualTransportadora.value;
		pagTotal = document.formConteudo.pagTotalTransportadora.value;
		ordenar = document.formConteudo.ordenarTransportadora.value;
	}else if (aba == 'aba_motorista'){
		pagAtual = document.formConteudo.pagAtualMotorista.value;
		pagTotal = document.formConteudo.pagTotalMotorista.value;
		ordenar = document.formConteudo.ordenarMotorista.value;
	}else if (aba == ''){
		pagAtual = document.formConteudo.pagAtualPreDefinida.value;
		pagTotal = document.formConteudo.pagTotalPreDefinida.value;
	}
	if (aba == ''){
		var pesquisa = document.formConteudo.pesquisa.value;
		XMLHttp.open("GET",document.formConteudo.action+"?acao=primeiro&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&pesquisa="+pesquisa,true);
	}else
		XMLHttp.open("GET",document.formConteudo.action+"?acao=primeiro&posicaoAba="+aba+"&pagAtual="+pagAtual+"&pagTotal="+pagTotal+"&ordenar="+ordenar,true);

	XMLHttp.send(null);
}

//Ordenar
function ordenar(tipo) {
	var aba = null;
	if (document.formConteudo.posicaoAba)
		aba = document.formConteudo.posicaoAba.value;
	else
		aba = '';
	criarXmlHttp();
	XMLHttp.onreadystatechange = function(){
		if (XMLHttp.readyState == 4){
			if (XMLHttp.status == 200){
				if (aba == 'aba_clientePJ'){
					document.getElementById('ordenarClientePJ').value = "ordenar"+tipo;
					document.getElementById('div_clientePJ').innerHTML = XMLHttp.responseText;
				}else if (aba == 'aba_clientePF'){
					document.getElementById('ordenarClientePF').value = "ordenar"+tipo;
					document.getElementById('div_clientePF').innerHTML = XMLHttp.responseText;
				}else if (aba == 'aba_armazem'){
					document.getElementById('ordenarArmazem').value = "ordenar"+tipo;
					document.getElementById('div_armazem').innerHTML = XMLHttp.responseText;
				}else if (aba == 'aba_transportadora'){
					document.getElementById('ordenarTransportadora').value = "ordenar"+tipo;
					document.getElementById('div_transportadora').innerHTML = XMLHttp.responseText;
				}else if (aba == 'aba_motorista'){
					document.getElementById('ordenarMotorista').value = "ordenar"+tipo;
					document.getElementById('div_motorista').innerHTML = XMLHttp.responseText;
				}else if (aba == ''){
					document.getElementById('div_predefinida').innerHTML = XMLHttp.responseText;
				}
			}
		}
	};
	var pagAtual = 0;
	if (aba == 'aba_clientePJ')
		pagAtual = document.formConteudo.pagAtualClientePJ.value;
	else if (aba == 'aba_clientePF')
		pagAtual = document.formConteudo.pagAtualClientePF.value;
	else if (aba == 'aba_armazem')
		pagAtual = document.formConteudo.pagAtualArmazem.value;
	else if (aba == 'aba_transportadora')
		pagAtual = document.formConteudo.pagAtualTransportadora.value;
	else if (aba == 'aba_motorista')
		pagAtual = document.formConteudo.pagAtualMotorista.value;
	else if (aba == '')
		pagAtual = document.formConteudo.pagAtualPreDefinida.value;
	
	if (aba == ''){
		var pesquisa = document.formConteudo.pesquisa.value;
		XMLHttp.open("GET",document.formConteudo.action+"?acao=ordenar"+tipo+"&pagAtual="+pagAtual+"&posicaoAba="+aba+"&pesquisa="+pesquisa,true);
	}else
		XMLHttp.open("GET",document.formConteudo.action+"?acao=ordenar"+tipo+"&pagAtual="+pagAtual+"&posicaoAba="+aba,true);
	XMLHttp.send(null);
}

/*function ordenarAmostra() {
	document.formConteudo.acao.value = "ordenarAmostra";
	document.formConteudo.submit();
}
//Ordenar pelo telefone
function ordenarTelefone() {
	document.formConteudo.acao.value = "ordenarTelefone";
	document.formConteudo.submit();
}
//Ordenar pelo email
function ordenarEmail() {
	document.formConteudo.acao.value = "ordenarEmail";
	document.formConteudo.submit();
}
//Ordenar pelo municipio
function ordenarMunicipio() {
	document.formConteudo.acao.value = "ordenarMunicipio";
	document.formConteudo.submit();
}
//Ordenar pelo uf
function ordenarUf() {
	document.formConteudo.acao.value = "ordenarUf";
	document.formConteudo.submit();
}*/

function cancelarContato(){
	document.formConteudo.acao.value = "cancelarContato";
	document.formConteudo.submit();
}

function pesquisaDefinida() {
	document.formConteudo.acao.value = "pesquisarPreDefinido";
}

function substituiCaracteresHTML(texto) {
	  while(texto != texto.replace('&aacute;', 'á')) {
		texto = texto.replace('&aacute;', 'á');
	  }	  
	  while(texto != texto.replace('&atilde;', 'ã')) {
		texto = texto.replace('&atilde;', 'ã');
	  }	  
	  while(texto != texto.replace('&acirc;', 'â')) {
		texto = texto.replace('&acirc;', 'â');
	  }	  
	  while(texto != texto.replace('&agrave;', 'à')) {
		texto = texto.replace('&aacute;', 'á');
	  }	  
	  while(texto != texto.replace('&Aacute;', 'Á')) {
		texto = texto.replace('&Aacute;', 'Á');
	  }	  
	  while(texto != texto.replace('&Atilde;', 'Ã')) {
		texto = texto.replace('&Atilde;', 'Ã');
	  }
	  while(texto != texto.replace('&Acirc;', 'Â')) {
		texto = texto.replace('&Acirc;', 'Â');
	  }	  
	  while(texto != texto.replace('&Agrave;', 'À')) {
		texto = texto.replace('&Agrave;', 'À');
	  }	  	  
	  while(texto != texto.replace('&eacute;', 'é')) {
		texto = texto.replace('&eacute;', 'é');
	  }	  
	  while(texto != texto.replace('&ecirc;', 'ê')) {
		texto = texto.replace('&ecirc;', 'ê');
	  }
	  while(texto != texto.replace('&Eacute;', 'É')) {
		texto = texto.replace('&Eacute;', 'É');
	  }	  
	  while(texto != texto.replace('&Ecirc;', 'Ê')) {
		texto = texto.replace('&Ecirc;', 'Ê');
	  }	  	  
	  while(texto != texto.replace('&iacute;', 'í')) {
		texto = texto.replace('&iacute;', 'í');
	  }	  
	  while(texto != texto.replace('&Iacute;', 'Í')) {
		texto = texto.replace('&Iacute;', 'Í');
	  }	  	  
	  while(texto != texto.replace('&oacute;', 'ó')) {
		texto = texto.replace('&oacute;', 'ó');
	  }	  
	  while(texto != texto.replace('&otilde;', 'õ')) {
		texto = texto.replace('&otilde;', 'õ');
	  }
	  while(texto != texto.replace('&ocirc;', 'ô')) {
		texto = texto.replace('&ocirc;', 'ô');
	  }	  
	  while(texto != texto.replace('&Oacute;', 'Ó')) {
		texto = texto.replace('&Oacute;', 'Ó');
	  }	  	  
	  while(texto != texto.replace('&Otilde;', 'Õ')) {
		texto = texto.replace('&Otilde;', 'Õ');
	  }	  
	  while(texto != texto.replace('&Ocirc;', 'Ô')) {
		texto = texto.replace('&Ocirc;', 'Ô');
	  }	  
	  while(texto != texto.replace('&uacute;', 'ú')) {
		texto = texto.replace('&uacute;', 'ú');
	  }	  
	  while(texto != texto.replace('&Uacute;', 'Ú')) {
		texto = texto.replace('&Uacute;', 'Ú');
	  }	  	  
	  while(texto != texto.replace('&ccedil;', 'ç')) {
		texto = texto.replace('&ccedil;', 'ç');
	  }	  
	  while(texto != texto.replace('&Ccedil;', 'Ç')) {
		texto = texto.replace('&Ccedil;', 'Ç');
	  }	  
	return texto;		
}
