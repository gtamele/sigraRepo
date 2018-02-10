package iim.sigra.controller.parametrizacao.tipousuario;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioDAO;
import iim.sigra.model.parametrizacao.tipousuario.TipoUsuarioVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping(value={"/tipousuarioaction"})
public class TipoUsuarioAction {
	
	ArrayList<TipoUsuarioVO> allTipoUsuarios = new ArrayList<TipoUsuarioVO>();
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(){
	
		
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		allTipoUsuarios = dao.getAll();
		ModelAndView modelView = new ModelAndView("/parametros/tipousuario/tipousuario-form", "allTipoUsuarios", this.allTipoUsuarios);
		
		return modelView;
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save(TipoUsuarioVO tipoUsuario, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoUsuarioDAO tipoUsuarioDao = new TipoUsuarioDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepTipoUsuario", null);	
			return "redirect:";
		}
		
		else if (action.equalsIgnoreCase("Salvar")) {
			
			tipoUsuarioDao.save(tipoUsuario, user);
		}
	
		else if (action.equalsIgnoreCase("Actualizar")) {
			
			tipoUsuarioDao.update(tipoUsuario, user);
			
		}
			
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	
	@RequestMapping(value="/selectedtipousuario",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadTipoUsuario(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		TipoUsuarioVO tipoUsuario = new TipoUsuarioVO();
		tipoUsuario.setSelfId(id);
		
		
		for ( TipoUsuarioVO tipo : this.allTipoUsuarios) {
			if(tipo.getSelfId()== tipoUsuario.getSelfId()){
			
				model.addAttribute("tipoUsuario", tipo);
			}	
		}
														    
		model.addAttribute("currStepTipoUsuario", SigraSteps.VISUALIZAR);
		
		
		return new ModelAndView("/parametros/tipousuario/tipousuario-form", "allTipoUsuarios", this.allTipoUsuarios);
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		
		ModelAndView modeView = new ModelAndView("/parametros/tipousuario/tipousuario-form", "allTipoUsuarios", this.allTipoUsuarios);
		
		TipoUsuarioVO tipoUsuario = new TipoUsuarioVO();
		tipoUsuario.setSelfId(selfId);
		
		
		for ( TipoUsuarioVO tipo : this.allTipoUsuarios) {
			if(tipo.getSelfId()== tipoUsuario.getSelfId()){
			
				modeView.addObject("tipoUsuario", tipo);
			}	
		}
		
		modeView.addObject("currStepTipoUsuario", SigraSteps.EDITAR);	
		
		return modeView;
		
	}
	
	
	@RequestMapping(value="/remove",  method= {RequestMethod.POST, RequestMethod.GET})
	public String remove( TipoUsuarioVO tipoUsuario, UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoUsuarioDAO tipoUsuarioDao = new TipoUsuarioDAO();
		
		tipoUsuarioDao.deleteByID(tipoUsuario.getSelfId(), user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
			
		return "redirect:";
	}
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepTipoUsuario", null);	
		return "redirect:";
	}
}
