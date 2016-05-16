
//Entrar na pagina principal
function abrirSistema(campo) {
  var x = (screen.width - 600) / 2;
  var y = (screen.height - 480) / 2;

  window.resizeTo(350, 350);
  window.moveTo(x, y);
  document.formLogin.usuario.focus();
}

//Entrar na pagina principal
function entrarSistema() {
  parametros = 'height=704, width=1014, top=0, left=0, scrollbars=no, resizable=no, status=yes, menubar=no';
  win = window.open('frameset.jsp' , 'sistemaBid', parametros);
  win.resizeTo(screen.availWidth,screen.availHeight);
  if (parseInt(navigator.appVersion) >= 4) {
    win.window.focus();
  }
  window.opener = window;
  window.close("#");  
}
