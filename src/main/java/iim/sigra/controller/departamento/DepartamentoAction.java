package iim.sigra.controller.departamento;

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
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/deptaction")
public class DepartamentoAction {
	
	ArrayList<DepartamentoVO> allDepts = new ArrayList<DepartamentoVO>();
	
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(){
		
		DepartamentoDAO deptDao = new DepartamentoDAO();
		allDepts = deptDao.getAll();
		
		ModelAndView modelView = new ModelAndView("dept/dept-form","allDepts", this.allDepts);
		
		return modelView;
		
	}
	
	

	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save(DepartamentoVO departamento, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		DepartamentoDAO deptDao = new DepartamentoDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepDept", null);	
			return "redirect:";
		}
		
		else if (action.equalsIgnoreCase("Salvar")) {
			
			deptDao.save(departamento, user);
		}
	
		else if (action.equalsIgnoreCase("Actualizar")) {
			
			deptDao.update(departamento, user);
			
		}
			
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	
	@RequestMapping(value="/selecteddept",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadDept(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		DepartamentoVO departamento = new DepartamentoVO();
		departamento.setSelfId(id);
		
		
		for ( DepartamentoVO dept : this.allDepts) {
			if(dept.getSelfId()== departamento.getSelfId()){
			
				model.addAttribute("departamento", dept);
			}	
		}
														    
		model.addAttribute("currStepDept", SigraSteps.VISUALIZAR);
		
		
		return new  ModelAndView("dept/dept-form","allDepts", this.allDepts);
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		ModelAndView modeView = new ModelAndView("dept/dept-form","allDepts", this.allDepts);
		
		DepartamentoVO departamento = new DepartamentoVO();
		departamento.setSelfId(selfId);
		
		
		for ( DepartamentoVO dept : this.allDepts) {
			if(dept.getSelfId()== departamento.getSelfId()){
			
				modeView.addObject("departamento", dept);
			}	
		}
		
		modeView.addObject("currStepDept", SigraSteps.EDITAR);	
		
		return modeView;
		
	}
	
	
	@RequestMapping(value="/remove",  method= {RequestMethod.POST, RequestMethod.GET})
	public String remove( DepartamentoVO departamento , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		DepartamentoDAO deptDao = new DepartamentoDAO();
		
		deptDao.deleteByID(departamento.getSelfId(), user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
			
		return "redirect:";
	}
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepDept", null);	
		return "redirect:";
	}

}
