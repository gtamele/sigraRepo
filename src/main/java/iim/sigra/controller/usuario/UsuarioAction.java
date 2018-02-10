package iim.sigra.controller.usuario;

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
import iim.sigra.model.usuario.UsuarioDAO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;

@Controller
@RequestMapping("/usuario")
public class UsuarioAction {
	
	ArrayList<TipoUsuarioVO> allTipoUsuario = new ArrayList<TipoUsuarioVO>();
	ArrayList<UsuarioVO> allUsuarios = new ArrayList<UsuarioVO>();
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView step0(){
		
		ModelAndView modelView = new ModelAndView("/usuario/usuario-form");
		
		TipoUsuarioDAO tipoUsuarioDao = new TipoUsuarioDAO();
		this.allTipoUsuario = tipoUsuarioDao.getAll();
		this.allTipoUsuario.add(0, new TipoUsuarioVO());
	
		modelView.addObject("allTipoUsuario", this.allTipoUsuario);
		
		UsuarioDAO useDao = new UsuarioDAO();
		this.allUsuarios = useDao.getAll();
		modelView.addObject("allUsuarios", this.allUsuarios);
		
		
		return modelView;
	}
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save (UsuarioVO usuario, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		System.out.println("Salvando.......!");
		

		if((usuario.getTipoUsuario().getSelfId()==0) ||(usuario.getTipoUsuario().getSelfId()<0) ){
			redirectAttributes.addFlashAttribute("errorMsg", Mensagens.OPERATION_FAILED_MSG+" Faltou seleccionar o 'Tipo de Utilizador'");
			return "redirect:";
		}
		
		if(!usuario.getPassword().equals(usuario.getPasswordConfirmacao())){
			redirectAttributes.addFlashAttribute("errorMsg", Mensagens.OPERATION_FAILED_MSG+" A 'PassWord' n&atilde;o confere");
			return "redirect:";
		}
		
		UsuarioDAO userDao = new UsuarioDAO();
		
		if(action.equalsIgnoreCase("Salvar")){
			userDao.save(usuario,user);
		}
		
		else {
			userDao.update(usuario, user);
		}
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	@RequestMapping(value="/selectedUsuario",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadEspecialidade(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		UsuarioVO usuario = new UsuarioVO();
		usuario.setSelfId(id);
		
		
		for ( UsuarioVO auxUsuario : this.allUsuarios) {
			if(auxUsuario.getSelfId()== usuario.getSelfId()){
				
				model.addAttribute("usuario", auxUsuario);
			}	
		}
		
	//	model.addAttribute("currStepEspecialidade", SigraSteps.VISUALIZAR);
		model.addAttribute("allTipoUsuario", this.allTipoUsuario);
		model.addAttribute("allUsuarios", this.allUsuarios);
		
		return new ModelAndView("/usuario/usuario-form");
	}
	

}
