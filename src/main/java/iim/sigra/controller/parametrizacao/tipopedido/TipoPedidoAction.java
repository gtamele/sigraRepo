package iim.sigra.controller.parametrizacao.tipopedido;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoDAO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping(value={"/tipopedidoaction"})
public class TipoPedidoAction {
	
	ArrayList<TipoPedidoVO> allTipoPedido = new ArrayList<TipoPedidoVO>();
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView stetp0(){
		
		ModelAndView modelAndView = new ModelAndView("parametros/tipopedido/tipopedido-form");
		
		TipoPedidoDAO tipoPedidoDao = new TipoPedidoDAO();
		this.allTipoPedido = tipoPedidoDao.getAll();
		
		modelAndView.addObject("allTipoPedido", this.allTipoPedido);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save(TipoPedidoVO tipopedido, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoPedidoDAO tipoDao = new TipoPedidoDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepTipoPedido", null);	
			return "redirect:";
		}
		
		else if (action.equalsIgnoreCase("Salvar")) {
			
			tipoDao.save(tipopedido, user);
		}
	
		else if (action.equalsIgnoreCase("Actualizar")) {
			
			tipoDao.update(tipopedido, user);
			
		}
			
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	
	@RequestMapping(value="/selectedtipo",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadTipoPedido(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		TipoPedidoVO tipopedido = new TipoPedidoVO();
		tipopedido.setSelfId(id);
		
		
		for ( TipoPedidoVO tipo : this.allTipoPedido) {
			if(tipo.getSelfId()== tipopedido.getSelfId()){
			
				model.addAttribute("tipopedido", tipo);
			}	
		}
														    
		model.addAttribute("currStepTipoPedido", SigraSteps.VISUALIZAR);
		
		
		return new ModelAndView("parametros/tipopedido/tipopedido-form", "allTipoPedido", this.allTipoPedido);
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		System.out.println("tipopedido "+selfId);
		ModelAndView modeView = new ModelAndView("parametros/tipopedido/tipopedido-form", "allTipoPedido", this.allTipoPedido);
		
		TipoPedidoVO tipopedido = new TipoPedidoVO();
		tipopedido.setSelfId(selfId);
		
		
		for ( TipoPedidoVO tipo : this.allTipoPedido) {
			if(tipo.getSelfId()== tipopedido.getSelfId()){
			
				modeView.addObject("tipopedido", tipo);
			}	
		}
		
		modeView.addObject("currStepTipoPedido", SigraSteps.EDITAR);	
		
		return modeView;
		
	}
	
	
	@RequestMapping(value="/remove",  method= {RequestMethod.POST, RequestMethod.GET})
	public String remove( TipoPedidoVO tipopedido , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoPedidoDAO tipoPedidoDao = new TipoPedidoDAO();
		
		tipoPedidoDao.deleteByID(tipopedido.getSelfId(), user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
			
		return "redirect:";
	}
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}
	
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepTipoPedido", null);	
		return "redirect:";
	}


}
