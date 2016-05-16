/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	>>>>>>>>>>>>>>>
	autoComplete.js
	<<<<<<<<<<<<<<<
	------------------------------------------------------------------
	>>>> AUTOR
	Christiano Rodarte Vale
	
    Criado em: 27/12/2006
    
    Ultima modificação: 18/04/2008
    	Descrição da Ultima Alteração: [Adaptação para funcionamento nos navegadores IE e FireFox]
	------------------------------------------------------------------
	>>>> DESCRIÇÃO:
	
	Recurso Caixa de Auto-Sugestão que ao começar a digitar um nome
	a caixa de selecões se abre sugerindo alguns nomes encontrados
	no banco de dados ou repositório da aplicaçao.
	
	Completa automaticamente o nome no campo e setta o codigo relacionado
	à sugestão dada a uma variavel tipo hidden.
	
	Envia dados para o Servidor no formato texto (URL).
	
	Recebe dados do Servidor em formato de arquivo XML.
		EX:
		<?xml version="1.0" encoding="ISO-8859-1"?>
			<itens>
				<item codCliente="0">>
					<nome>Endereço 0</nome>
				</item>
				<item codCliente="1">>
					<nome>Endereço 1</nome>
				</item>
				<item codCliente="2">>
					<nome>Endereço 2</nome>
				</item>
				<item codCliente="3">>
					<nome>Endereço 3</nome>
				</item>
			</itens>
	-------------------------------------------------------------------
	>>>> CÓDIGO NECESSÁRIO PARA O FUNCIONAMENTO (na pagina):
	
	<link rel="stylesheet" type="text/css" href="css/autoComplete.css">
	
	<script language="javascript" src="script/autoComplete.js"></script>
	
	<script type="text/javascript">
	      window.onload = function(){
		    criarDropDown();
		   }
	</script>
	
	<body>
	...
	<input name="codigoPesquisa" type="hidden" id="codigoPesquisa" value="">
		---opcional: para buscar o codigo do objeto selecionado----
	
	<input type="text" name="<nome do componente>"  id="<id do componente>" class="dados" autocomplete="off" onKeyUp="procurarNome(this.id, 'acao', event)">
	
	<div id="autoComplete" class="autoComplete"> </div>
	...
	</body>
	
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

// Funçao para carregar o objeto XMLHttpRequest que faz o
// recebimento assincrono das solicitações ao servidor
var request = createRequest();
var camada;
var caixaTexto;
var tabela;
var tabelaBody;
var timeOutId;
var enviado = false;
var acaoWeb;
var resposta;

// Esta funçao garante que será usada a versao
// mais recente e atual do objeto XMLHttp.
function criarObjetoMicrosoft(){
	var versoes = ["MSXML2.XMLHttp.6.0","MSXML2.XMLHttp.5.0",
				   "MSXML2.XMLHttp.4.0","MSXML2.XMLHttp.3.0",
				   "MSXML2.XMLHttp","Microsoft.XMLHttp"];
	for (var i = 0; i < versoes.length; i++){
		try{
			var objetoXMLHttp = new ActiveXObject(versoes[i]);
			return objetoXMLHttp;
		}catch(ex){
			//faz nada
		}
	}
	throw new Error("MSXML não está instalado.");
}

// Cria o objeto XMLHttpRequest
function createRequest() {
  if (window.XMLHttpRequest) { 
      a=new XMLHttpRequest(); //Objeto nativo - XMLHttpRequest (FireFox/Safari/Opera7.6+)
  } 
  else {
	  a = criarObjetoMicrosoft(); // Objeto ActiveX (Microsoft - Internet Explorer)
  } 
  return a;
}
//-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

// Versão simplificada do metodo getElementById()
function getElmBI(campo){
	var elemento = document.getElementById(campo);
	return elemento;
}
//---------
// Inicia o processo no carregamento da pagina, na chamada da classe.
function init(id){
	caixaTexto = getElmBI(id);
	tabela = getElmBI("tabela");
	camada = getElmBI("popup");
	tabelaBody = getElmBI("tabela_body");
}

//------------------------------------------------------------------------------------------------------------------
//******************************************************************************************************************
//------------------------------------------------------------------------------------------------------------------
// Faz a requisiçao assincrona de busca ao servidor.
// Chama metodos que adicionam o nome selecionado ao campo e o codigo relacionado ao nome.
function procurarNomeCodigo(id, acao, evt){
	init(id);
	try{
		if(caixaTexto.value.length > 0){
			if(!verificarTeclaPressionada(evt, true)) {
				if(!enviado){
					var url = document.formConteudo.action+"?acao=" + acao + "&pesquisa=" + encodeURIComponent(caixaTexto.value);
					request.open("GET", url, true);
					request.onreadystatechange = recuperarListaNomeCodigoServidor;
					timeOutId = setTimeout(timesUp, 10000);
					enviado = true;
					request.send(null);
				}
				else{
					mensagem(true,"autoCompletar");
				}
			}
			else if (navigator.appName != "Microsoft Internet Explorer"){
				if(evt.which == "37" || evt.which == "39") {
					limparResultados();
					mensagem(false, "popup");
				}
			} else if(event.keyCode == "37" || event.keyCode == "39") {
				limparResultados();
				mensagem(false, "popup");
			}
		}
		else{
			limparResultados();
			mensagem(false, "popup");
		}
	}catch(erro){
		alert("Erro: " + erro.message);
	}
}

// Recupera os dados vindos do Servidor como um arquivo XML
function recuperarListaNomeCodigoServidor(){
	if (request.readyState == 4) {
		clearTimeout(timeOutId);//limpa o timer
         if (request.status == 200) {
		  try{ 
			 enviado = false;
			 mensagem(false,"autoComplete");
			 resposta = request.responseXML;
			 var nome = resposta.getElementsByTagName("nome")[0].firstChild.data;
			 dados = resposta.getElementsByTagName("nome");
			 if(dados[0].firstChild.data != "Nenhum Resultado.") {
			 	adicionarNomeCodigo(resposta);
			 }
			 else limparResultados();
		  }catch(ex){}	 
		 }
		 else if (request.status == 404){
			 limparResultados();
		 }
	}
}

//Constroi a tabela com os dados recuperados
function adicionarNomeCodigo(resposta){
	dados = resposta.getElementsByTagName("nome");
	limparResultados();
	var tamanho = dados.length;
	setOffsets();
	var row, cell, textNode;
	for(var i = 0; i < tamanho; i++){
		var proxNo = dados[i].firstChild.data;
		row = document.createElement("tr");
		cell = document.createElement("td");
		cell.onmouseout = function() {this.className='corFora';};
		cell.onmouseover = function() {this.className='corSobre';};
		if(i == 0) cell.className = 'corSobre';
		else cell.className = 'corFora';
		cell.onclick = function(){adicionarNomeSettarCodigo(this, resposta);};
		textNode = document.createTextNode(proxNo);
		cell.appendChild(textNode);
		row.appendChild(cell);
		tabelaBody.appendChild(row);
	}
	document.getElementById("popup").style.visibility = "visible";

}


// Coloca o nome selecionado no campo e setta a variavel tipo hidden com o respectivo codigo
function adicionarNomeSettarCodigo(valor, resposta){
	caixaTexto.value = valor.firstChild.nodeValue;
	dados = resposta.getElementsByTagName("nome");
	var codigo = "";
	for(i=0 ; i<resposta.getElementsByTagName("nome").length ; i++){
		if(dados[i].firstChild.data == valor.firstChild.nodeValue){
			codigo = resposta.getElementsByTagName("item")[i].getAttribute("codCliente");
		}
	}
	
	document.getElementById("codigoPesquisa").value = codigo;
	limparResultados();
	mensagem(false,"popup");

	
}
//------------------------------------------------------------------------------------------------------------------
//******************************************************************************************************************
//------------------------------------------------------------------------------------------------------------------
// Faz a requisiçao assincrona de busca ao servidor.
// Chama metodos que adicionam apenas o nome selecionado ao campo.
function procurarNome(id, acao, evt){
	init(id);
	acaoWeb = acao;
	mensagem(true,"popup");
	try{
		if(caixaTexto.value.length > 0){
			if(!verificarTeclaPressionada(evt, false)) {			
				if(!enviado){
					var url = document.formConteudo.action+"?acao=" + acao + "&pesquisa=" + encodeURIComponent(caixaTexto.value);
					request.open("GET", url, true);
					request.onreadystatechange = recuperarListaNomesServidor;
					timeOutId = setTimeout(timesUp, 10000);
					enviado = true;
					request.send(null);
				}
				else{
					mensagem(true);
				}
			}
			else if (navigator.appName != "Microsoft Internet Explorer"){
				if(evt.which == "37" || evt.which == "39") {
					limparResultados();
					mensagem(false, "popup");
				}
			} else if(event.keyCode == "37" || event.keyCode == "39") {
				limparResultados();
				mensagem(false, "popup");
			}
		}
		else{
			limparResultados();
			mensagem(false, "popup");
		}
	}catch(erro){
		alert("Erro: " + erro.message);
	}
}


// Recupera os dados vindos do Servidor como um arquivo XML
function recuperarListaNomesServidor(){
	if (request.readyState == 4) {
		clearTimeout(timeOutId);//limpa o timer
         if (request.status == 200) {
		   try{	 
			 enviado = false;
			 mensagem(false,"autoComplete");
			 resposta = request.responseXML;
			 var nome = resposta.getElementsByTagName("nome")[0].firstChild.data;
			 dados = resposta.getElementsByTagName("nome");
			 if(dados[0].firstChild.data != "Nenhum Resultado.") {
				 adicionarListaNomes(resposta);
			 }
			 else limparResultados();			 
		   }catch(ex){}
		 }
		 else if (request.status == 404){
			 limparResultados();
		 }
	}
}


//Constroi a tabela com os dados recuperados
function adicionarListaNomes(resposta){
	dados = resposta.getElementsByTagName("nome");
	limparResultados();
	var tamanho = dados.length;
	setOffsets();
	var row, cell, textNode;
	for(var i = 0; i < tamanho; i++){
		var proxNo = dados[i].firstChild.data;
		row = document.createElement("tr");
		cell = document.createElement("td");
		cell.onmouseout = function() {this.className='corFora';};
		cell.onmouseover = function() {this.className='corSobre';};
		if(i == 0) cell.className = 'corSobre';
		else cell.className = 'corFora';
		cell.onclick = function(){adicionarNome(this);};
		textNode = document.createTextNode(proxNo);
		cell.appendChild(textNode);
		row.appendChild(cell);
		tabelaBody.appendChild(row);
	}
	document.getElementById("popup").style.visibility = "visible";
}


// Coloca o nome selecionado no campo
function adicionarNome(valor){
	if(valor.firstChild.nodeValue != "Nenhum Resultado."){
		caixaTexto.value = valor.firstChild.nodeValue;
	}
	else{
		caixaTexto.value = "";
	}
	
	limparResultados();
	mensagem(false,"popup");
}

//------------------------------------------------------------------------------------------------------------------
//******************************************************************************************************************
//------------------------------------------------------------------------------------------------------------------

// Posicionamento da Caixa de Auto-Completar na tela
function setOffsets(){
	var end = caixaTexto.offsetWidth;
	var left = calcularOffsetLeft(caixaTexto);
	var top = calcularOffsetTop(caixaTexto) + caixaTexto.offsetHeight + 2;
	camada.style.border = "black 1px solid";
	camada.style.left = left + "px";
	camada.style.top = top + "px";
	tabela.style.width = end + "px";
}
//---------
function calcularOffsetLeft(campo){
	return calcularOffset(campo, "offsetLeft");
}
//---------
function calcularOffsetTop(campo){
	return calcularOffset(campo, "offsetTop");
}
//---------
function calcularOffset(campo, atributo){
	var offset = 0;
	while (campo){
		offset += campo[atributo];
		campo = campo.offsetParent;
	}
	return offset;
}

//---------
// Retira a caixa de Auto Completar da tela
function limparResultados(){	
	var ind = tabelaBody.childNodes.length;
	for (var i = ind-1; i >= 0; i--){
		tabelaBody.removeChild(tabelaBody.childNodes[i]);
	}
	camada.style.border = "none";
}
//---------
// Cria a tabela (ainda invisivel) ao carregar a pagina.
// Cria o layer para receber os dados
function criarDropDown(){
	var layer = document.createElement("div");
	layer.className = "sugestoes";
	layer.id = "popup";
	var tabela = document.createElement("table");
	var tBody = document.createElement("tbody");
	tBody.setAttribute("id","tabela_body");
	tabela.setAttribute("id","tabela");
	tabela.appendChild(tBody);
	layer.appendChild(tabela);
	document.body.appendChild(layer);
}
//---------
// metodo que aborta o recebimento dos dados
function timesUp(){
	request.abort();
	alert("Está demorando demais! Verifique sua conexao com a rede.");
}
//---------
// metodo que mostra a caixa de Auto Completar
function mensagem(mostrar, id){
	var msg = document.getElementById(id);
	var vis = null;
	if(mostrar)
		vis = 'visible';
	  else 
	  vis = 'hidden';
	
	 msg.style.visibility = vis;
}

//---------
// Verifica se o usuario pressionou as teclas direcionais 'para cima', 'para baixo' ou 'enter'
function verificarTeclaPressionada(ev, setarCodigo) {
  if (navigator.appName != "Microsoft Internet Explorer") { 
	if(ev.which == 40) { //baixo
		linha = tabela.firstChild.firstChild;
		indice = 0;
		primeiro = linha.firstChild;
		while(linha != null) {
			if(indice == 2) {
				linha.firstChild.className = 'corSobre';
				indice = 4;
			}				
			else if(linha.firstChild.className == 'corSobre' && indice == 0) {
				linha.firstChild.className = 'corFora';
				indice = 2;
			}
			else if(linha.firstChild.className == "" && indice == 0) {
				linha.firstChild.className = 'corSobre';
				indice = 1;
			}
			else if(indice == 1) {
				linha.firstChild.className = 'corFora';
			}
			
			linha = linha.nextSibling;
			if(indice == 2 && linha == null) {
				primeiro.className = 'corSobre';
			}
			else if(indice == 0 && linha == null) {
				primeiro.className = 'corSobre';
			}
		}
		return true;
	}
	
	else if(ev.which == 38) {//cima
		linha = tabela.firstChild.lastChild;
		indice = 0;
		ultimo = linha.firstChild;
		while(linha != null) {
			if(indice == 2) {
				linha.firstChild.className = 'corSobre';
				indice = 4;
			}				
			else if(linha.firstChild.className == 'corSobre' && indice == 0) {
				linha.firstChild.className = 'corFora';
				indice = 2;
			}
			else if(linha.firstChild.className == "" && indice == 0) {
				linha.firstChild.className = 'corSobre';
				indice = 1;
			}
			else if(indice == 1) {
				linha.firstChild.className = 'corFora';
			}
			
			linha = linha.previousSibling;
			if(indice == 2 && linha == null) {
				ultimo.className = 'corSobre';
			}
			else if(indice == 0 && linha == null) {
				ultimo.className = 'corSobre';
			}
		}
		return true;		
	}//esquerda, direita e enter
	else if(ev.which == 39 || ev.which == 37 || ev.which==13) {
		linha = tabela.firstChild.firstChild;
		while(linha != null) {
			if(linha.firstChild.className == 'corSobre') {
				if(setarCodigo){
					adicionarNomeSettarCodigo(linha.firstChild, resposta);
				}else{
					adicionarNome(linha.firstChild);
				}
			}
			linha = linha.nextSibling;
		}
		return true;		
	}//esc
	else if(ev.which == 27) {
		limparResultados();
		mensagem(false, "popup");
		return true;
	}
	else return false;
 
 } else { //(Microsoft - Internet Explorer)

	if(event.keyCode == 40) {//cima
		linha = tabela.firstChild.firstChild;
		indice = 0;
		primeiro = linha.firstChild;
		while(linha != null) {
			if(indice == 2) {
				linha.firstChild.className = 'corSobre';
				indice = 4;
			}				
			else if(linha.firstChild.className == 'corSobre' && indice == 0) {
				linha.firstChild.className = 'corFora';
				indice = 2;
			}
			else if(linha.firstChild.className == "" && indice == 0) {
				linha.firstChild.className = 'corSobre';
				indice = 1;
			}
			else if(indice == 1) {
				linha.firstChild.className = 'corFora';
			}
			
			linha = linha.nextSibling;
			if(indice == 2 && linha == null) {
				primeiro.className = 'corSobre';
			}
			else if(indice == 0 && linha == null) {
				primeiro.className = 'corSobre';
			}
		}
		return true;
	}
	else if(event.keyCode == 38) {//baixo
		linha = tabela.firstChild.lastChild;
		indice = 0;
		ultimo = linha.firstChild;
		while(linha != null) {
			if(indice == 2) {
				linha.firstChild.className = 'corSobre';
				indice = 4;
			}				
			else if(linha.firstChild.className == 'corSobre' && indice == 0) {
				linha.firstChild.className = 'corFora';
				indice = 2;
			}
			else if(linha.firstChild.className == "" && indice == 0) {
				linha.firstChild.className = 'corSobre';
				indice = 1;
			}
			else if(indice == 1) {
				linha.firstChild.className = 'corFora';
			}
			
			linha = linha.previousSibling;
			if(indice == 2 && linha == null) {
				ultimo.className = 'corSobre';
			}
			else if(indice == 0 && linha == null) {
				ultimo.className = 'corSobre';
			}
		}
		return true;		
	}//esquerda, direita e enter
	else if(event.keyCode == 39 || event.keyCode == 37 || event.keyCode==13) {
		linha = tabela.firstChild.firstChild;
		while(linha != null) {
			if(linha.firstChild.className == 'corSobre') {
				if(setarCodigo){
					adicionarNomeSettarCodigo(linha.firstChild, resposta);
				}else{
					adicionarNome(linha.firstChild);
				}
			}
			linha = linha.nextSibling;
		}
		return true;		
	}//esc
	else if(event.keyCode == 27) {
		limparResultados();
		mensagem(false, "popup");
		return true;
	}
	else return false;
 }
}
