package iim.sigra.controller.especialidade;

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
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/especialidade")
public class EspecialidadeAction {
	
	ArrayList<EspecialidadeVO> allEspecialidades = new ArrayList<EspecialidadeVO>();
	ArrayList<DepartamentoVO> allDepts = new ArrayList<DepartamentoVO>();
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView step0(){
		
		ModelAndView modelView = new ModelAndView("/especialidade/especialidade-form");
		
		DepartamentoDAO deptDao = new DepartamentoDAO();
		allDepts=deptDao.getAll();
		allDepts.add(0, new DepartamentoVO());
	
		modelView.addObject("allDepts", this.allDepts);
		
		
		EspecialidadeDAO espcDao = new EspecialidadeDAO();
		this.allEspecialidades=espcDao.getAll();
		
		modelView.addObject("allEspecialidades", this.allEspecialidades);
		
		
		return modelView;
	}
	
	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save (EspecialidadeVO especialidade, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		System.out.println("Salvando.......!");
		

		if((especialidade.getDepartamento().getSelfId()==0) ||(especialidade.getDepartamento().getSelfId()<0) ){
			redirectAttributes.addFlashAttribute("errorMsg", Mensagens.OPERATION_FAILED_MSG+" Faltou seleccionar o 'Departamento'");
			return "redirect:";
		}
		
		EspecialidadeDAO espDao = new EspecialidadeDAO();
		
		if(action.equalsIgnoreCase("Salvar")){
			
			espDao.save(especialidade,user);
		}
		
		else {
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
		
	//	model.addAttribute("currStepEspecialidade", SigraSteps.VISUALIZAR);
		model.addAttribute("allDepts", this.allDepts);
		model.addAttribute("allEspecialidades", this.allEspecialidades);
		
		return new ModelAndView("/especialidade/especialidade-form" );
	}
	

	@RequestMapping(value="/remove")
	public ModelAndView remove( EspecialidadeVO especialidade , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		EspecialidadeDAO espDao = new EspecialidadeDAO();
		
		espDao.deleteByID(especialidade.getSelfId(), user);
		
		ModelAndView modelAndView = new ModelAndView("/especialidade/especialidade-form");
		
		modelAndView.addObject("allEspecialidades", this.allEspecialidades );
		modelAndView.addObject("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		
	//	redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	

		return  modelAndView;
	}
	
	
	@RequestMapping(value="/editar", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView setStepEditar(){
		
		System.out.println("Para edição....!");
		
		ModelAndView modeAndView = new ModelAndView();
		
		modeAndView.addObject("currStepEspecialidade", SigraSteps.EDITAR);
		
		
		return modeAndView;
	}
	

}
