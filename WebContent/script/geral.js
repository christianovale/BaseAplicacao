//******************************************************
//Metodo de teste do Exemplo Foo************************
function enviarFoo(){
   document.formConteudo.acao.value = "incluirFoo";
   document.formConteudo.submit();
}
//******************************************************
//******************************************************







//Mostrar uma tela de alerta
function mostrarMensagem(msg, campo) {
   alert(msg);
   campo.focus();
}

//Selecionar um item do cabecalho
function selecionarItem(acao) {
  document.formCabecalho.acao.value=acao;
}

//Navegacao da tabela
function navegar(valor) {
   document.formConteudo.acao.value = "navegar";
   document.formConteudo.navegacao.value = valor;
   document.formConteudo.submit();
}

//Submeter a acao da pagina de mensagem
function submeterMensagem(acao) {
  document.formMensagem.acao.value = acao;
  document.formMensagem.submit();
}

//Variaveis de cor
  preto = "#000000";
  fundo = "#EAEAEA";
  vermelho = "#FF0000";
  
//Troca a cor de uma fonte
function trocaCorFonte (fonte, cor) {
  x = document.getElementById(fonte);
  x.setAttribute("color", cor);
}

//Marca o campo em vermelho como inválido
function sinalizaCampo (campo, classe) {
  x = document.getElementById(campo);
  x.className = classe;
}

//Verifica se o valor de um campo é número
function verificaNumero(valor, campo) {
  var objeto = document.getElementById(campo);
  if(objeto.value != "") {
	  if(!( /^((\d+|\d{1,3}(\.\d{3})+)(\,\d{1,2})?|\,\d{1,2})$/.test(valor))) {
		  alert("Favor digitar os números no formato certo, com duas casas decimais. (Separador de milhar '.' | Separador de casa decimal ','). Não são permitidos números negativos.");
		  objeto.focus();
		  objeto.value = "";
		  return false;
	  }
	  else return true;
  }
}

function verificaNumeroInteiro(valor, campo) {
  var objeto = document.getElementById(campo);
  if(objeto.value != "") {
	  objeto.value = parseInt(objeto.value);
	  if(isNaN(objeto.value)) {
		  alert("Este campo aceita somente números inteiros.");
		  objeto.focus();
		  objeto.value = "";
		  return false;
	  }
	  else return true;
  }
}

//Formata um número para o padrão brasileiro
function formataNumero(valor, campo) {
	valor = valor.replace('.', '');
	Number(valor);
	var inteiro = new Number(valor);	
	inteiro = Math.abs(inteiro);
	if(inteiro == valor) {
		inteiro = String(inteiro);
		valor = inteiro + ",00";
	}
	var arrayValor = new String(valor);
	
	arrayValor = arrayValor.split(',');
	decimal = arrayValor[1];
	arrayInteiro = arrayValor[0].split("");
	cont = 0;
	for(i = arrayInteiro.length; i > 1; i--) {
		cont++;
		if(cont == 3) {
			arrayInteiro.splice(i-1, 0, '.');
			cont = 0;
		}	
	}
	var numeroFormatado = new String();
	for(i = 0; i < arrayInteiro.length; i++) {
		numeroFormatado = numeroFormatado + arrayInteiro[i];
	}
	numeroFormatado = numeroFormatado +  "," + decimal;

	objeto = document.getElementById(campo);	
	objeto.value = numeroFormatado;
}

//Verifica se existe algum item selecionado em uma lista (select)
function verificaSelecao (objeto) {
  var lista = objeto.options;
  for (i = 0; i < lista.length; i++) {
    if (lista.options[i].selected == true) {
      return true;
    }
  }
  return false;
}

//Mascara para uma data no formato dd/mm/aaaa ou mm/dd/aaaa
function mascaraData(data, formCampo){
  var campo = eval("document." + formCampo);
  var valorData = "";
  valorData = valorData + data;

  if (event.keyCode == 8) {//backspace
  	if (valorData.length == 2 || valorData.length == 5) {
		valorData = valorData.substring(0,valorData.length-1);
	}
	campo.value = valorData;
  }
  else if(valorData.length == 2) {
    valorData = valorData + '/';
    campo.value = valorData;
  }
  else if(valorData.length == 5) {
    valorData = valorData + '/';
    campo.value = valorData;
  }
}

//Verifica se uma data é válida
function verificaData(data) {
	if((/^((0[1-9]|[12]\d)\/(0[1-9]|1[0-2])|30\/(0[13-9]|1[0-2])|31\/(0[13578]|1[02]))\/\d{4}$/.test(data))) {
		return true;
	}
	else return false;
}

//Verifica se existe algum caractere especial como ! @ # $ % & * + ] [ { } " ' 
function verificaCaracteresEspeciais(valor, campo) {
  var objeto = document.getElementById(campo);
  if(objeto.value != "") {
	  if(( /[\b&%$#@!*{}+=\]\[\(\)\"\']/.test(valor))) {
		  alert("Favor digitar somente caracteres alfa numéricos. Os caracteres especiais como: $ % & * ! [ ] } { etc não são permitidos.");
		  objeto.focus();
		  objeto.value = "";
		  return false;
	  }
	  else return true;
  }
  return true;
}
//Relogio do frame superior
function moveRelogio(){ 
    momentoAtual = new Date(); 
    hora = momentoAtual.getHours(); 
    minuto = momentoAtual.getMinutes(); 
    segundo = momentoAtual.getSeconds(); 

    str_segundo = new String (segundo) 
    if (str_segundo.length == 1) 
       segundo = "0" + segundo; 

    str_minuto = new String (minuto) 
    if (str_minuto.length == 1) 
       minuto = "0" + minuto; 

    str_hora = new String (hora) 
    if (str_hora.length == 1) 
       hora = "0" + hora; 

    horaImprimivel = hora + ":" + minuto + ":" + segundo;

	document.getElementById('relogio').firstChild.nodeValue = horaImprimivel;

    setTimeout("moveRelogio()",1000) 
} 


function fecharPagina(){
   window.close();	
}


//Parametro, numero com 2 casas decimais (Ex: 12345.67) --- Retorna o número R$ 12.345,67
function retornaNumeroFormatado(numero) {
		valor = numero;
		valor = String(valor);
		if(valor == valor.replace('.', ',')) {
			valor = valor + ".00";
		}
		
		var arrayValor = new String(valor);
		arrayValor = arrayValor.split('.');
		decimal = arrayValor[1];
		arrayInteiro = arrayValor[0].split("");
		cont = 0;
		tamanho = arrayInteiro.length;
		for(i = tamanho; i >= 1; i--) {
			cont++;
			if(cont == 3 && i != 1) {
				arrayInteiro.splice(i-1, 0, '.');
				cont = 0;
			}
		}
		var numeroFormatado = new String();
		for(i = 0; i < arrayInteiro.length; i++) {
			numeroFormatado = numeroFormatado + arrayInteiro[i];
		}
		if (decimal.length == 1) decimal = decimal + 0;
		numeroFormatado = numeroFormatado +  "," + decimal;
		resultado = numeroFormatado;
		return resultado;
}
