package iim.sigra.controller.disciplina;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iim.sigra.model.disciplina.DisciplinaDAO;
import iim.sigra.model.disciplina.DisciplinaVO;
import iim.sigra.model.usuario.UsuarioVO;
import iim.sigra.utilitarios.Mensagens;
import iim.sigra.utilitarios.SigraSteps;

@Controller
@RequestMapping("/disciplinaaction")
public class DisciplinaAction {
	
	
	ArrayList<DisciplinaVO> allDisciplinas = new ArrayList<DisciplinaVO>();
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView step0(){
		
		DisciplinaDAO discDao = new DisciplinaDAO();
		allDisciplinas = discDao.getAll();
		
		ModelAndView modelView = new ModelAndView("disciplina/disciplina-form","allDisciplinas", this.allDisciplinas);
		
		return modelView;
		
	}
	

	@RequestMapping(value="/save", method= {RequestMethod.POST})
	public String save(DisciplinaVO  disciplina, UsuarioVO user, @RequestParam("action") String action, RedirectAttributes redirectAttributes) throws Exception{
		
		
		DisciplinaDAO discDao = new DisciplinaDAO();
		
		if (action.equalsIgnoreCase("Cancelar")) {
			redirectAttributes.addFlashAttribute("currStepDisciplina", null);	
			return "redirect:";
		}
		
		else if (action.equalsIgnoreCase("Salvar")) {
			
			discDao.save(disciplina, user);
		}
	
		else if (action.equalsIgnoreCase("Actualizar")) {
			
			discDao.update(disciplina, user);
			
			
		}
			
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);
		return "redirect:";
	}
	
	
	@RequestMapping(value="/selecteddisc",  method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loadDisc(@RequestParam("selfId") long id, UsuarioVO user,Model model){
		
		DisciplinaVO disciplina = new DisciplinaVO();
		disciplina.setSelfId(id);
		
		
		for ( DisciplinaVO disc : this.allDisciplinas) {
			if(disc.getSelfId()== disciplina.getSelfId()){
			
				model.addAttribute("disciplina", disc);
			}	
		}
														    
		model.addAttribute("currStepDisciplina", SigraSteps.VISUALIZAR);
		
		
		return new ModelAndView("disciplina/disciplina-form","allDisciplinas", this.allDisciplinas);
	}
	
	
	@RequestMapping(value="/editar",  method= {RequestMethod.GET})
	public ModelAndView editar(@RequestParam("selfId") Long selfId) throws IOException{
		
		System.out.println("tipopedido "+selfId);
		ModelAndView modeView = new ModelAndView("disciplina/disciplina-form","allDisciplinas", this.allDisciplinas);
		
		DisciplinaVO disciplina = new DisciplinaVO();
		disciplina.setSelfId(selfId);
		
		
		for ( DisciplinaVO disc : this.allDisciplinas) {
			if(disc.getSelfId()== disciplina.getSelfId()){
			
				modeView.addObject("disciplina", disc);
			}	
		}
		
		modeView.addObject("currStepDisciplina", SigraSteps.EDITAR);	
		
		return modeView;
		
	}
	
	
	@RequestMapping(value="/remove",  method= {RequestMethod.POST, RequestMethod.GET})
	public String remove( DisciplinaVO disciplina , UsuarioVO user, RedirectAttributes redirectAttributes) throws Exception{
		
		
		DisciplinaDAO discDao = new DisciplinaDAO();
		
		discDao.deleteByID(disciplina.getSelfId(), user);
		
		redirectAttributes.addFlashAttribute("statusMsg", Mensagens.OPERATION_SUCCESS_MSG);	
			
		return "redirect:";
	}
	
	
	@RequestMapping(value="/home",  method= RequestMethod.GET)
	public ModelAndView backToMenu(){

		return new ModelAndView("menu/menu1");
	}
	
	
	@RequestMapping(value="/abortar",  method= RequestMethod.GET)
	public String abortar( RedirectAttributes redirectAttributes){
		
		redirectAttributes.addFlashAttribute("currStepDisciplina", null);	
		return "redirect:";
	}
	

}
