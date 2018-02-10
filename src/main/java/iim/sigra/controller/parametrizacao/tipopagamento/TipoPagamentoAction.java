package iim.sigra.controller.parametrizacao.tipopagamento;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoDAO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping(value={"/tipopagamentoaction"})
public class TipoPagamentoAction {
	
	
	
	ArrayList<TipoPagamentoVO> allTipoPagamentos = new ArrayList<TipoPagamentoVO>();
	

	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView stetp0(){
		
		ModelAndView modelAndView = new ModelAndView("/parametros/tipopagamento/tipopagamento-form");
		
		TipoPagamentoDAO tipoPagamentoDao = new TipoPagamentoDAO();
		this.allTipoPagamentos = tipoPagamentoDao.getAll();
		
		modelAndView.addObject("allTipoPagamentos", this.allTipoPagamentos);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save(TipoPagamentoVO tipoPagamento, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoPagamentoDAO tipoPagamentoDao = new TipoPagamentoDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepTipoPagamento", null);	
			return "redirect:";
		}
		
		else if (action.equalsIgnoreCase("Salvar")) {
			
			tipoPagamentoDao.save(tipoPagamento, user);
		}
	
		else if (action.equalsIgnoreCase("Actualizar")) {
			
			tipoPagamentoDao.update(tipoPagamento, user);
			
		}
			
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	
	@RequestMapping(value="/selectedtipopagamento",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadTipoPagamento(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		TipoPagamentoVO tipoPagamento = new TipoPagamentoVO();
		tipoPagamento.setSelfId(id);
		
		
		for ( TipoPagamentoVO tipo : this.allTipoPagamentos) {
			if(tipo.getSelfId()== tipoPagamento.getSelfId()){
			
				model.addAttribute("tipoPagamento", tipo);
			}	
		}
														    
		model.addAttribute("currStepTipoPagamento", SigraSteps.VISUALIZAR);
		
		
		return new ModelAndView("/parametros/tipopagamento/tipopagamento-form", "allTipoPagamentos", this.allTipoPagamentos);
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		
		ModelAndView modeView = new ModelAndView("/parametros/tipopagamento/tipopagamento-form", "allTipoPagamentos", this.allTipoPagamentos);
		
		TipoPagamentoVO tipoPagamento = new TipoPagamentoVO();
		tipoPagamento.setSelfId(selfId);
		
		
		for ( TipoPagamentoVO tipo : this.allTipoPagamentos) {
			if(tipo.getSelfId()== tipoPagamento.getSelfId()){
			
				modeView.addObject("tipoPagamento", tipo);
			}	
		}
		
		modeView.addObject("currStepTipoPagamento", SigraSteps.EDITAR);	
		
		return modeView;
		
	}
	
	
	@RequestMapping(value="/remove",  method= {RequestMethod.POST, RequestMethod.GET})
	public String remove( TipoPagamentoVO tipoPagamento , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		TipoPagamentoDAO tipoPagamentoDao = new TipoPagamentoDAO();
		
		tipoPagamentoDao.deleteByID(tipoPagamento.getSelfId(), user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
			
		return "redirect:";
	}
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}
	
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepTipoPagamento", null);	
		return "redirect:";
	}
	
	

}
