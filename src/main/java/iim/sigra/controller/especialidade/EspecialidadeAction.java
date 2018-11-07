package iim.sigra.controller.especialidade;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.departamento.DepartamentoDAO;
import iim.sigra.model.departamento.DepartamentoVO;
import iim.sigra.model.especialidade.EspecialidadeDAO;
import iim.sigra.model.especialidade.EspecialidadeVO;
import iim.sigra.model.parametrizacao.tipopagamento.TipoPagamentoVO;
import iim.sigra.model.parametrizacao.tipopedido.TipoPedidoVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/especialidadeaction")
public class EspecialidadeAction {
	
	ArrayList<EspecialidadeVO> allEspecialidades = new ArrayList<EspecialidadeVO>();
	ArrayList<DepartamentoVO> allDepts = new ArrayList<DepartamentoVO>();
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView step0(){
		
		ModelAndView modelView = new ModelAndView("/especialidade/especialidade-form");
		
		DepartamentoDAO deptDao = new DepartamentoDAO();
		allDepts=deptDao.getAll();
	
		modelView.addObject("allDepts", this.allDepts);
		
		
		EspecialidadeDAO espcDao = new EspecialidadeDAO();
		this.allEspecialidades=espcDao.getAll();
		
		modelView.addObject("allEspecialidades", this.allEspecialidades);
		
		
		return modelView;
	}
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save (EspecialidadeVO especialidade, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		EspecialidadeDAO espDao = new EspecialidadeDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepEspecialidade", null);	
			return "redirect:";
		}
		
		else if(action.equalsIgnoreCase("Salvar")){
			
			espDao.save(especialidade,user);
		}
		
		else if (action.equalsIgnoreCase("Actualizar")){
			espDao.update(especialidade, user);
			
		}
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		
		return "redirect:";
	}	
	
	
	
	@RequestMapping(value="/selectedEsp",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadEspecialidade(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		EspecialidadeVO especialidade = new EspecialidadeVO();
		especialidade.setSelfId(id);
		
		
		for ( EspecialidadeVO esp : this.allEspecialidades) {
			if(esp.getSelfId()== especialidade.getSelfId()){
				
				model.addAttribute("especialidade", esp);
			}	
		}
		
		model.addAttribute("currStepEspecialidade", SigraSteps.VISUALIZAR);
		model.addAttribute("allDepts", this.allDepts);
		model.addAttribute("allEspecialidades", this.allEspecialidades);
		
		return new ModelAndView("/especialidade/especialidade-form" );
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		
		ModelAndView modeView = new ModelAndView("/especialidade/especialidade-form", "allEspecialidades", this.allEspecialidades);
		
		EspecialidadeVO especialidade = new EspecialidadeVO();
		especialidade.setSelfId(selfId);
		
		
		for ( EspecialidadeVO esp : this.allEspecialidades) {
			if(esp.getSelfId()== especialidade.getSelfId()){
			
				modeView.addObject("especialidade", esp);
			}	
		}
		
		modeView.addObject("currStepEspecialidade", SigraSteps.EDITAR);	
		modeView.addObject("allDepts", this.allDepts);
		
		return modeView;
		
	}
	

	@RequestMapping(value="/remove")
	public String remove( EspecialidadeVO especialidade , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		EspecialidadeDAO espDao = new EspecialidadeDAO();
		
		espDao.deleteByID(especialidade.getSelfId(), user);
		
		ModelAndView modelAndView = new ModelAndView("/especialidade/especialidade-form");
		
		modelAndView.addObject("allEspecialidades", this.allEspecialidades );
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	

		return "redirect:";
	}
	
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepEspecialidade", null);	
		return "redirect:";
	}
	
	
}
