//Funcoes de javascript para a pagina de login

function efetuarLogoff() {
  parametros = 'resizable=no, status=yes';
  win = window.open('index.jsp' , 'BidCafe', parametros);
  win.resizeTo(screen.availWidth,screen.availHeight);
  if (parseInt(navigator.appVersion) >= 4) {
    win.window.focus();
  }
  window.opener = window;
  top.close("#");
  document.formCabecalhoSuperior.acao.value = "logoff";
  document.submit();
}

function trocarSenha() {
  if(checarFormTrocarSenha()) {
    document.formLogin.submit();
  }
}

function checarFormTrocarSenha() {
  if(document.formLogin.senha.value == "") {
    mostrarMensagem("Informe a nova senha.", document.formLogin.senha);
    return false;
  }
  else if(document.formLogin.senha.value.length < 4) {
    mostrarMensagem("A nova senha muito pequeno.", document.formLogin.senha);
    return false;
  }

  if(document.formLogin.confirma.value == "") {
    mostrarMensagem("Informe a senha de confirmação.", document.formLogin.confirma);
    return false;
  }
  else if(document.formLogin.confirma.value.length < 4) {
    mostrarMensagem("Senha de confirmação muito pequeno.", document.formLogin.confirma);
    return false;
  }

  if(document.formLogin.senha.value != document.formLogin.confirma.value) {
    document.formLogin.senha.value = "";
    document.formLogin.confirma.value = "";
    mostrarMensagem("A senha nao confere.", document.formLogin.senha);
    return false;
  }
  return true;
}

//Submeter o form
function efetuarLogon() {
  if(checarFormLogin()) {
    document.formLogin.submit();
  }
}

//Checar os campos do login
function checarFormLogin() {
  if(document.formLogin.usuario.value == "") {
    mostrarMensagem("Informe o nome do usuário.", document.formLogin.usuario);
    return false;
  }
  else if(document.formLogin.usuario.value.length < 4) {
    mostrarMensagem("Nome do usuário muito pequeno.", document.formLogin.usuario);
    return false;
  }

  if(document.formLogin.senha.value == "") {
    mostrarMensagem("Informe a senha do usuário.", document.formLogin.senha);
    return false;
  }
  else if(document.formLogin.senha.value.length < 4) {
    mostrarMensagem("Senha do usuário muito pequeno.", document.formLogin.senha);
    return false;
  }
  return true;
}

function esqueciSenha() {
  if(document.formLogin.usuario.value == "") {
    mostrarMensagem("Informe o nome do usuário.", document.formLogin.usuario);
	event.returnValue = false;
  }
  else {
  	document.formLogin.acao.value = "esqueciSenha";
	document.formLogin.submit();
  }
}
