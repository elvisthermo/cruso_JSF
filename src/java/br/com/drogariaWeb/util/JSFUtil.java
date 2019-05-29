
package br.com.drogariaWeb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thermo
 */
public class JSFUtil {
    public static void adicionarMensagemSucesso(String mensagem) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,mensagem);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    
    }
    
    public static void adicionarMensagemErro(String menssagem){
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,menssagem,menssagem);
         FacesContext contexto = FacesContext.getCurrentInstance();
         contexto.addMessage(null, msg);
        
    }
}