var tXHR=0;
 
         function XMLHTTPRequest() {
           if (window.XMLHttpRequest) { 
               a=new XMLHttpRequest(); } //Objeto nativo (FF/Safari/Opera7.6+)
           else {
             try { 
                a=new ActiveXObject("Msxml2.XMLHTTP");  //activeX (IE5.5+/MSXML2+)
             }   
             catch(e) {
               try { 
                  a=new ActiveXObject("Microsoft.XMLHTTP"); //activeX (IE5+/MSXML1)
               }   
               catch(e) { /* O navegador não tem suporte */ 
                  a=false; 
               }
             }
           } 
           return a;
         }
 		
		  // Fun�ao Ajax que atualiza o comboBox de Cidades
		  // @param servlet, o nome do servlet que tratar� a a�ao
		  // @param elementoCidades, o ID do comboBox que listar� as cidades
		  // @param elementoUf, o ID do comboBox que lista os estados
         function atualizaCidades(servlet, elementoCidades, elementoUf) {
             var pEstado = document.getElementById(elementoUf).options[document.getElementById(elementoUf).selectedIndex].value;
             tXHR=XMLHTTPRequest();
             if (tXHR) {
				 document.getElementById(elementoCidades).length = 0;
				 document.getElementById(elementoCidades).options[0] = new Option("Aguarde....","");
                 tXHR.open("GET", servlet+"?acao=filtrarMunicipios&estado="+pEstado, true);    
                 tXHR.onreadystatechange=recebeResultado;
                 tXHR.send(null);
             }
         }
         
		 // Fun�ao Ajax que retorna o resultado para a pagina
         function recebeResultado() {
             if (!tXHR) {
                 return false;
             }
             else {
                 if (tXHR.readyState == 4) {             
                     if (tXHR.status == 200) {
                         document.getElementById("idCidades").innerHTML = tXHR.responseText;
                     }
                     else {
                         alert('Erro! "'+ tXHR.statusText +'" (erro '+ tXHR.status +')'); 
                     }
                 }    
             }
         }

