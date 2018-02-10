package iim.sigra.controller.parametrizacao.tipodocidentificacao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoDAO;
import iim.sigra.model.parametrizacao.tipodocumentoidentificacao.TipoDocIdentificacaoVO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoDAO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping(value={"/tipodocidentaction"})
public class TipoDocIdentificacaoAction {
	
	
									  
	ArrayList<TipoDocIdentificacaoVO> allTipoDocIdentificacao = new ArrayList<TipoDocIdentificacaoVO>();


	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView listAllTipoDocIdent(){
	
		
		TipoDocIdentificacaoDAO dao = new TipoDocIdentificacaoDAO();
		allTipoDocIdentificacao = dao.getAll();	               						
		ModelAndView modelView = new ModelAndView("/parametros/tipodocidentificacao/tipodocidentificacao-form", "allTipoDocIdentificacao", this.allTipoDocIdentificacao);
		
		modelView.addObject("tipoDocIdent", new TipoDocIdentificacaoVO());
		
		return modelView;
	}
	
	

	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save(TipoDocIdentificacaoVO tipoDocIdent, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoDocIdentificacaoDAO tipoDocDao = new TipoDocIdentificacaoDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepTipoDocIndent", null);	
			return "redirect:";
		}
		
		else if (action.equalsIgnoreCase("Salvar")) {
			
			tipoDocDao.save(tipoDocIdent, user);
		}
	
		else if (action.equalsIgnoreCase("Actualizar")) {
			
			tipoDocDao.update(tipoDocIdent, user);
			
		}
			
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	
	@RequestMapping(value="/selectedtipo",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadTipoDocIdent(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		TipoDocIdentificacaoVO tipoDocIdent = new TipoDocIdentificacaoVO();
		tipoDocIdent.setSelfId(id);
		
		
		for ( TipoDocIdentificacaoVO tipo : this.allTipoDocIdentificacao) {
			if(tipo.getSelfId()== tipoDocIdent.getSelfId()){
			
				model.addAttribute("tipoDocIdent", tipo);
			}	
		}
														    
		model.addAttribute("currStepTipoDocIndent", SigraSteps.VISUALIZAR);
		
		
		return new ModelAndView("/parametros/tipodocidentificacao/tipodocidentificacao-form", "allTipoDocIdentificacao", this.allTipoDocIdentificacao);
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		System.out.println("tipopedido "+selfId);
		ModelAndView modeView = new ModelAndView("/parametros/tipodocidentificacao/tipodocidentificacao-form", "allTipoDocIdentificacao", this.allTipoDocIdentificacao);
		
		TipoDocIdentificacaoVO tipoDocIdent = new TipoDocIdentificacaoVO();
		tipoDocIdent.setSelfId(selfId);
		
		
		for ( TipoDocIdentificacaoVO tipo : this.allTipoDocIdentificacao) {
			if(tipo.getSelfId()== tipoDocIdent.getSelfId()){
			
				modeView.addObject("tipoDocIdent", tipo);
			}	
		}
		
		modeView.addObject("currStepTipoDocIndent", SigraSteps.EDITAR);	
		
		return modeView;
		
	}
	
	
	@RequestMapping(value="/remove",  method= {RequestMethod.POST, RequestMethod.GET})
	public String remove( TipoDocIdentificacaoVO tipoDocIdent , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoDocIdentificacaoDAO tipoDocDao = new TipoDocIdentificacaoDAO();
		
		tipoDocDao.deleteByID(tipoDocIdent.getSelfId(), user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
			
		return "redirect:";
	}
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}

	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepTipoDocIndent", null);	
		return "redirect:";
	}
	
	

}
